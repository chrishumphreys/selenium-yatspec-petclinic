package com.habitualcoder.springpetclinic.selenium.owners.scenarios;

import com.habitualcoder.springpetclinic.selenium.home.HomePage;
import com.habitualcoder.springpetclinic.selenium.owners.pages.FindOwnersPage;
import com.habitualcoder.springpetclinic.selenium.owners.pages.OwnerPage;

public class FindOwner {

    private final HomePage homePage;

    public FindOwner(HomePage homePage) {
        this.homePage = homePage;
    }

    public OwnerPage findOwner(String lastName) {
        FindOwnersPage findPage = homePage.clickFindOwners();
        findPage.setSearchTerm(lastName);
        return findPage.submitSearchForm();
    }

}
