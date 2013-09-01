package com.habitualcoder.springpetclinic.selenium.owners.pages;

import com.habitualcoder.springpetclinic.selenium.utils.selenium.BasePage;
import com.habitualcoder.springpetclinic.selenium.home.HomePage;
import com.habitualcoder.springpetclinic.selenium.utils.selenium.NotCorrectPageException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverBackedSelenium;

import static java.lang.String.format;

public class OwnerPage extends BasePage {

    public OwnerPage(WebDriverBackedSelenium selenium) {
        super("Owners", selenium, HomePage.PAGE_TITLE);
        if (!selenium.getHtmlSource().contains("Owner Information")) {
            String msg = format("Owner Information page has not been loaded from [%s]", selenium.getLocation());
            throw new NotCorrectPageException(msg);
        }
    }

    public String getName() {
        return selenium.getWrappedDriver().findElement(By.xpath("//table/tbody/tr[th='Name']/td")).getText();
    }

    public String getAddress() {
        return selenium.getWrappedDriver().findElement(By.xpath("//table/tbody/tr[th='Address']/td")).getText();
    }

    public String getCity() {
        return selenium.getWrappedDriver().findElement(By.xpath("//table/tbody/tr[th='City']/td")).getText();
    }

    public String getTelephone() {
        return selenium.getWrappedDriver().findElement(By.xpath("//table/tbody/tr[th='Telephone']/td")).getText();
    }
}
