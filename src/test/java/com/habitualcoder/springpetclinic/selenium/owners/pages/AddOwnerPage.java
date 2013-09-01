package com.habitualcoder.springpetclinic.selenium.owners.pages;

import com.habitualcoder.springpetclinic.selenium.utils.selenium.BasePage;
import com.habitualcoder.springpetclinic.selenium.home.HomePage;
import com.habitualcoder.springpetclinic.selenium.utils.selenium.NotCorrectPageException;
import org.openqa.selenium.WebDriverBackedSelenium;

import static java.lang.String.format;

public class AddOwnerPage extends BasePage {
    public AddOwnerPage(WebDriverBackedSelenium selenium) {
        super("Add Owner", selenium, HomePage.PAGE_TITLE);
        if (!selenium.getHtmlSource().contains(" New  Owner")) {
            String msg = format("Add Owner page has not been loaded from [%s]", selenium.getLocation());
            throw new NotCorrectPageException(msg);
        }
    }

    public void setLastName(String lastName) {
        selenium.type("name=lastName", lastName);
    }

    public void setFirstName(String firstName) {
        selenium.type("name=firstName", firstName);
    }

    public void setAddress(String address) {
        selenium.type("name=address", address);
    }

    public void setCity(String city) {
        selenium.type("name=city", city);
    }

    public void setTelephone(String telephone) {
        selenium.type("name=telephone", telephone);
    }

    public OwnerPage submitAddForm() {
        selenium.click("xpath=//button[@type='submit']");
        selenium.waitForPageToLoad("1000");
        return new OwnerPage(selenium);
    }
}
