package com.github.bgomar.bgdevtoys.tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.Map;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;

public class SvgEncoder {
    private Document doc;
    private Element initTextarea;
    private Element resultTextarea;
    private Element resultCssTextarea;
    private Element resultDemo;
    private Element demoWrapper;
    private NodeList contrastButtons;
    private Element dropzoneEl;
    private Element contrastButtonCurrent;
    private String backgroundColor;
    private NodeList expanders;
    private String expandedClass;
    private String symbols;
    private NodeList quotesInputs;
    private String externalQuotesValue;
    private String quotes;

    public SvgEncoder(Document doc) {
        this.doc = doc;
        initializeElements();
        setupEventListeners();
    }

    private void initializeElements() {
        initTextarea = doc.getElementById("init");
        resultTextarea = doc.getElementById("result");
        resultCssTextarea = doc.getElementById("result-css");
        resultDemo = doc.getElementById("demo");
        demoWrapper = doc.querySelector(".demo-wrapper");
        contrastButtons = doc.querySelectorAll(".contrast-button");
        dropzoneEl = doc.getElementById("dropzone");
        contrastButtonCurrent = null;
        backgroundColor = "";
        expanders = doc.querySelectorAll(".expander");
        expandedClass = "expanded";
        symbols = "[\\r\\n%#()<>?[\\\\\\]^`{|}]";
        quotesInputs = doc.querySelectorAll(".options__input");
        externalQuotesValue = doc.querySelector(".options__input:checked").value;
        quotes = getQuotes();
    }

    private void setupEventListeners() {
        initTextarea.oninput = e -> getResults();

        resultTextarea.oninput = e -> {
            String value = resultTextarea.value.trim()
                    .replace("background-image:\\s{0,}url\\(", "")
                    .replace("[\"']{0,}data:image/svg\\+xml,", "")
                    .replace("[\"']\\);{0,}$", "");
            initTextarea.value = decodeURIComponent(value);
            getResults();
        };

        for (int i = 0; i < expanders.getLength(); i++) {
            Element expander = (Element) expanders.item(i);
            expander.addEventListener("click", e -> {
                Element parent = expander.getParentNode();
                Element expanded = parent.querySelector("." + expandedClass);
                expanded.classList.toggle("hidden");
                expander.classList.toggle("opened");
            });
        }

        for (int i = 0; i < quotesInputs.getLength(); i++) {
            Element input = (Element) quotesInputs.item(i);
            input.addEventListener("input", e -> {
                externalQuotesValue = input.getValue();
                quotes = getQuotes();
                getResults();
            });
        }

        buttonExample.addEventListener("click", e -> {
            initTextarea.setValue("<svg>\n" +
                    "  <circle r=\"50\" cx=\"50\" cy=\"50\" fill=\"tomato\"/>\n" +
                    "  <circle r=\"41\" cx=\"47\" cy=\"50\" fill=\"orange\"/>\n" +
                    "  <circle r=\"33\" cx=\"48\" cy=\"53\" fill=\"gold\"/>\n" +
                    "  <circle r=\"25\" cx=\"49\" cy=\"51\" fill=\"yellowgreen\"/>\n" +
                    "  <circle r=\"17\" cx=\"52\" cy=\"50\" fill=\"lightseagreen\"/>\n" +
                    "  <circle r=\"9\" cx=\"55\" cy=\"48\" fill=\"teal\"/>\n" +
                    "</svg>");
            getResults();
        });

        for (int i = 0; i < contrastButtons.getLength(); i++) {
            Element button = (Element) contrastButtons.item(i);
            button.addEventListener("click", e -> {
                contrastButtonsSetCurrent(button);
                demoWrapper.setStyle("background", backgroundColor);
            });
        }

        Element copyResultButton = doc.getElementById("copy-result-button");
        Element copyCSSResultButton = doc.getElementById("copy-css-result-button");

        copyResultButton.addEventListener("click", e -> {
            Element textToCopy = doc.getElementById("result");
            textToCopy.select();
            doc.execCommand("copy");
        });

        copyCSSResultButton.addEventListener("click", e -> {
            Element textToCopy = doc.getElementById("result-css");
            textToCopy.select();
            doc.execCommand("copy");
        });

        if (dropzoneEl != null) {
            String dropzoneActiveCls = "dropzone--active";

            doc.addEventListener("dragover", e -> {
                e.preventDefault();
                dropzoneEl.classList.add(dropzoneActiveCls);
            });

            dropzoneEl.addEventListener("dragleave", e -> {
                dropzoneEl.classList.remove(dropzoneActiveCls);
            });

            dropzoneEl.addEventListener("drop", e -> {
                e.preventDefault();
                DataTransfer data = e.getDataTransfer();
                FileReader reader = new FileReader();
                File file = data.getFiles().get(0);

                if (file.getType().equals("image/svg+xml")) {
                    reader.readAsText(file);
                    reader.onload = () -> {
                        initTextarea.setValue(reader.getResult());
                        getResults();
                    };
                }
                dropzoneEl.classList.remove(dropzoneActiveCls);
            });
        }
    }

    private void getResults() {
        if (initTextarea.value.isEmpty()) {
            resultCssTextarea.value = "";
            resultDemo.setAttribute("style", "");
            return;
        }

        String namespaced = addNameSpace(initTextarea.value);
        String escaped = encodeSVG(namespaced);
        resultTextarea.value = escaped;
        String resultCss = "background-image: url(" + quotes.level1 + "data:image/svg+xml," + escaped + quotes.level1 + ");";
        resultCssTextarea.value = resultCss;
        resultDemo.setAttribute("style", resultCss);
    }

    private void contrastButtonsSetCurrent(Element button) {
        String classCurrent = "contrast-button--current";

        if (contrastButtonCurrent != null) {
            contrastButtonCurrent.classList.remove(classCurrent);
        }

        backgroundColor = button.getAttribute("data-color");
        contrastButtonCurrent = button;
        button.classList.add(classCurrent);
    }

    private String addNameSpace(String data) {
        if (data.indexOf("http://www.w3.org/2000/svg") < 0) {
            data = data.replace("<svg", "<svg xmlns=" + quotes.level2 + "http://www.w3.org/2000/svg" + quotes.level2);
        }

        return data;
    }

    private String encodeSVG(String data) {
        if (externalQuotesValue.equals("double")) {
            data = data.replace("\"", "'");
        } else {
            data = data.replace("'", "\"");
        }

        data = data.replace(">[\\s]{1,}<", "><");
        data = data.replace("\\s{2,}", " ");

        return data.replaceAll(symbols, Matcher.quoteReplacement(URLEncoder.encode("$0", StandardCharsets.UTF_8.name())));
    }

    private Map<String, String> getQuotes() {
        String doubleQuote = "\"";
        String singleQuote = "'";

        return Map.of(
                "level1", externalQuotesValue.equals("double") ? doubleQuote : singleQuote,
                "level2", externalQuotesValue.equals("double") ? singleQuote : doubleQuote
        );
    }

    private void out(String data) {
        System.out.println(data);
    }
}