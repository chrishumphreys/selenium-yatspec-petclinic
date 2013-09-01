package com.habitualcoder.springpetclinic.selenium.tests;

import com.habitualcoder.springpetclinic.selenium.owners.pages.OwnerPage;
import com.habitualcoder.springpetclinic.selenium.owners.scenarios.AddOwner;
import com.habitualcoder.springpetclinic.selenium.owners.scenarios.FindOwner;
import com.habitualcoder.springpetclinic.selenium.utils.SpringPetClinicWebDriverTestSupport;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A demonstration of two scenarios using our selenium scenario and page objects in pure unit test style
 */
public class OwnersJUnitTest extends SpringPetClinicWebDriverTestSupport {

    /**
     * Notes:
     *
     * For this demo we are not starting the application under test.
     * You must manually start Spring PetClinic first.
     *
     * Then run these tests either from Maven or IntelliJ.
     *
     * If firefox hangs, or doesn't open then it could be your Firefox version has upgraded itself (this happens a lot).
     * Check selenium version in pom and upgrade if not latest.
     *
     * If the test fails you can set the SpringPetClinicWebDriverTestSupport.DELAY_AFTER_TEST to see the browser window.
     */

    @Test
    public void canAddANewOwner() {
        AddOwner addOwner = new AddOwner(homepage);
        String firstName = "test";
        String lastName = "owner";
        String address = "address";
        String city = "city";
        String telephone = "12345";
        OwnerPage ownerPage = addOwner.addOwner(firstName, lastName, address, city, telephone);
        assertEquals(firstName + " " + lastName, ownerPage.getName());
        assertEquals(address, ownerPage.getAddress());
        assertEquals(city, ownerPage.getCity());
        assertEquals(telephone, ownerPage.getTelephone());
    }

    @Test
    public void canFindExistingOwnerByLastName() throws Exception {
        FindOwner findOwner = new FindOwner(homepage);
        OwnerPage ownerPage = findOwner.findOwner("Schroeder");
        assertEquals("David Schroeder", ownerPage.getName());
        assertEquals("2749 Blackhawk Trail", ownerPage.getAddress());
        assertEquals("Madison", ownerPage.getCity());
        assertEquals("6085559435", ownerPage.getTelephone());
    }
}
