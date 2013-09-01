package com.habitualcoder.springpetclinic.selenium.utils.selenium;

import org.openqa.selenium.WebDriverBackedSelenium;

import static java.lang.String.format;

public abstract class BasePage implements Page {
    private String internalPageName;
    protected final WebDriverBackedSelenium selenium;

    public BasePage(String internalPageName, WebDriverBackedSelenium selenium, String expectedPageText) {
        this.internalPageName = internalPageName;
        this.selenium = selenium;
        String html = getHtml();
        if (!html.contains(expectedPageText)) {
            String msg = format("Page body (%s) does not contain expected text (%s), current page is: %s", html, expectedPageText, selenium.getLocation());
            throw new NotCorrectPageException(msg);
        }
    }

    public String getHtml() {
        return selenium.getHtmlSource();
    }

    public String getInternalPageName() {
        return internalPageName;
    }

    @Override
    public String toString() {
        return "BasePage{" +
                "internalPageName='" + internalPageName + '\'' +
                '}';
    }
}
