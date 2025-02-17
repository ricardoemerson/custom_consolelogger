package com.github.bgomar.bgconsolelogger.tools;

import com.cronutils.descriptor.CronDescriptor;
import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class CronTools {

    private static final DateTimeFormatter DATETIME_FORMAT_24H = DateTimeFormatter.ofPattern("yyyy-MM-dd E HH:mm:ss");
    private static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();

    public static String explainAndGetDates(String cronStr, CronType cronType, long nbDays) {
        try {
            CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(cronType);
            CronParser parser = new CronParser(cronDefinition);
            Cron quartzCron = parser.parse(cronStr);
            quartzCron.validate();

            CronDescriptor descriptor = CronDescriptor.instance();
            String description = descriptor.describe(parser.parse(cronStr));

            ExecutionTime executionTime = ExecutionTime.forCron(quartzCron);

            ZonedDateTime startDate = LocalDateTime.now().atZone(DEFAULT_ZONE_ID);
            ZonedDateTime endDate = startDate.plusDays(nbDays);

            Optional<ZonedDateTime> lastExecution = executionTime.lastExecution(startDate);

            List<ZonedDateTime> executionDates = executionTime.getExecutionDates(startDate, endDate);

            StringBuilder result = new StringBuilder("Description: " + description + "\n");
            lastExecution.ifPresent(dateTime -> result.append("Last execution: ").append(DATETIME_FORMAT_24H.format(dateTime)).append("\n"));
            if (executionDates.isEmpty()) {
                result.append("Next executions: none");
            } else {
                result.append("Next executions:\n");
                int idx = 1;
                for (ZonedDateTime executionDate : executionDates) {
                    result.append("- ").append(DATETIME_FORMAT_24H.format(executionDate)).append("\n");
                    if (idx++ > 200) {
                        result.append("\n").append(executionDates.size()).append(" executions found, but ")
                            .append("showing the 200 first executions only.\n")
                            .append("Result is truncated to preserve the responsiveness of the IDE.");
                        break;
                    }
                }
            }
            return result.toString().trim();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}