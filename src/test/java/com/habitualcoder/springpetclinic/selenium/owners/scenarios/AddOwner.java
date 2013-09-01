package com.habitualcoder.springpetclinic.selenium.owners.scenarios;

import com.habitualcoder.springpetclinic.selenium.home.HomePage;
import com.habitualcoder.springpetclinic.selenium.owners.pages.AddOwnerPage;
import com.habitualcoder.springpetclinic.selenium.owners.pages.FindOwnersPage;
import com.habitualcoder.springpetclinic.selenium.owners.pages.OwnerPage;

public class AddOwner {

    private final HomePage homePage;

    public AddOwner(HomePage homePage) {
        this.homePage = homePage;
    }

    public OwnerPage addOwner(String firstName, String lastName, String address, String city, String telephone) {
        FindOwnersPage findPage = homePage.clickFindOwners();
        AddOwnerPage addOwnerPage = findPage.clickAddOwner();
        addOwnerPage.setLastName(lastName);
        addOwnerPage.setFirstName(firstName);
        addOwnerPage.setAddress(address);
        addOwnerPage.setCity(city);
        addOwnerPage.setTelephone(telephone);
        return addOwnerPage.submitAddForm();
    }
}
