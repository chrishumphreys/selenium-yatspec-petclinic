package com.habitualcoder.springpetclinic.selenium.owners.pages;

import com.habitualcoder.springpetclinic.selenium.utils.selenium.BasePage;
import com.habitualcoder.springpetclinic.selenium.home.HomePage;
import com.habitualcoder.springpetclinic.selenium.utils.selenium.NotCorrectPageException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverBackedSelenium;

import static java.lang.String.format;

public class FindOwnersPage extends BasePage {

    public FindOwnersPage(WebDriverBackedSelenium selenium) {
        super("Find Owners", selenium, HomePage.PAGE_TITLE);
        if (!selenium.getHtmlSource().contains("Find Owners")) {
            String msg = format("Find Owners page has not been loaded from [%s]", selenium.getLocation());
            throw new NotCorrectPageException(msg);
        }
    }

    public void setSearchTerm(String searchTerm) {
        selenium.type("name=lastName", searchTerm);
    }

    public OwnerPage submitSearchForm() {
        selenium.click("xpath=//button[@type='submit']");
        selenium.waitForPageToLoad("1000");
        return new OwnerPage(selenium);
    }

    public AddOwnerPage clickAddOwner() {
        selenium.getWrappedDriver().findElement(By.linkText("Add Owner")).click();
        selenium.waitForPageToLoad("1000");
        return new AddOwnerPage(selenium);
    }
}
