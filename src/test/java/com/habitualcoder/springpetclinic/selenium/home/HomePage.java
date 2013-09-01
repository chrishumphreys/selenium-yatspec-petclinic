package com.habitualcoder.springpetclinic.selenium.home;

import com.habitualcoder.springpetclinic.selenium.utils.selenium.BasePage;
import com.habitualcoder.springpetclinic.selenium.owners.pages.FindOwnersPage;
import com.habitualcoder.springpetclinic.selenium.utils.selenium.NotCorrectPageException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverBackedSelenium;

import static java.lang.String.format;

public class HomePage extends BasePage {
    public static final String PAGE_TITLE = "PetClinic :: a Spring Framework demonstration";

    public HomePage(WebDriverBackedSelenium selenium) {
        super("Home", selenium, PAGE_TITLE);
        if (!selenium.getHtmlSource().contains("Welcome")) {
            String msg = format("Home page has not been loaded from [%s]", selenium.getLocation());
            throw new NotCorrectPageException(msg);
        }
    }

    public FindOwnersPage clickFindOwners() {
        selenium.getWrappedDriver().findElement(By.linkText("Find owners")).click();
        selenium.waitForPageToLoad("1000");
        return new FindOwnersPage(selenium);
    }

    public HomePage clickHome() {
        selenium.getWrappedDriver().findElement(By.linkText("Home")).click();
        selenium.waitForPageToLoad("1000");
        return new HomePage(selenium);
    }
}
