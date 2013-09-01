package com.habitualcoder.springpetclinic.selenium.tests;

import com.googlecode.yatspec.junit.Notes;
import com.googlecode.yatspec.junit.SpecRunner;
import com.googlecode.yatspec.state.givenwhenthen.*;
import com.habitualcoder.springpetclinic.selenium.home.HomePage;
import com.habitualcoder.springpetclinic.selenium.owners.pages.AddOwnerPage;
import com.habitualcoder.springpetclinic.selenium.owners.pages.FindOwnersPage;
import com.habitualcoder.springpetclinic.selenium.utils.SpringPetClinicWebDriverTestSupport;
import com.habitualcoder.springpetclinic.selenium.utils.selenium.Page;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.habitualcoder.springpetclinic.selenium.tests.OwnersMatchers.*;
import static com.habitualcoder.springpetclinic.selenium.tests.OwnersSyntacticSugar.*;

/**
 * A demonstration of two scenarios using in BDD test style using Yatspec
 */
@RunWith(SpecRunner.class)
public class OwnersTest extends SpringPetClinicWebDriverTestSupport {
    private Page currentPage;

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


    @Notes("All users can search for owners registered in the application using the Find Owners page accessible from the main menu.")
    @Test
    public void canSearchForAnExistingOwner() throws Exception {
        given(theUserIsAtTheApplicationHomePage());
        when(theUserClicksFindOwnersLink());
        then(thePageChangesTo(), theFindOwnersPage());
        when(theUserSearchesFor("Schroeder"));
        then(thePageChangesTo(), theOwnersPage(forOwnerName("David Schroeder"), withAddress("2749 Blackhawk Trail"), withCity("Madison"), withTelephone("6085559435")));
    }

    @Notes("All users can add a new owner to the application using the Add Owner page accessible from the Find Owners page via the main menu.")
    @Test
    public void canAddANewOwner() throws Exception {
        given(theUserIsAtTheApplicationHomePage());
        when(theUserClicksFindOwnersLink());
        then(thePageChangesTo(), theFindOwnersPage());
        when(theUserClicksAddOwnerLink());
        then(thePageChangesTo(), theAddOwnerPage());
        when(theUserEntersUserDetails(lastName("owner"), And(firstName("test")), And(address("address")), And(telephone("12345")), And(city("city"))));
        then(thePageChangesTo(), theOwnersPage(forOwnerName("test owner"), withAddress("address"), withTelephone("12345"), withCity("city")));
    }

    private ActionUnderTest theUserClicksAddOwnerLink() {
        return new ActionUnderTest() {
            @Override
            public CapturedInputAndOutputs execute(InterestingGivens interestingGivens, CapturedInputAndOutputs capturedInputAndOutputs) throws Exception {
                currentPage = ((FindOwnersPage)currentPage).clickAddOwner();
                return capturedInputAndOutputs;
            }
        };
    }

    public ActionUnderTest theUserEntersUserDetails(final String lastName, final String firstName, final String address, final String telephone, final String city) {
        return new ActionUnderTest() {
            @Override
            public CapturedInputAndOutputs execute(InterestingGivens givens, CapturedInputAndOutputs capturedInputAndOutputs) throws Exception {
                AddOwnerPage addOwnerPage = (AddOwnerPage)currentPage;
                addOwnerPage.setAddress(address);
                addOwnerPage.setCity(city);
                addOwnerPage.setFirstName(firstName);
                addOwnerPage.setLastName(lastName);
                addOwnerPage.setTelephone(telephone);
                currentPage = addOwnerPage.submitAddForm();
                return capturedInputAndOutputs;
            }
        };
    }

    private StateExtractor<Page> thePageChangesTo() {
        return new StateExtractor<Page>() {
            @Override
            public Page execute(CapturedInputAndOutputs capturedInputAndOutputs) throws Exception {
                return currentPage;
            }
        };
    }

    private ActionUnderTest theUserClicksFindOwnersLink() {
        return new ActionUnderTest() {
            @Override
            public CapturedInputAndOutputs execute(InterestingGivens interestingGivens, CapturedInputAndOutputs capturedInputAndOutputs) throws Exception {
                currentPage = ((HomePage)currentPage).clickFindOwners();
                return capturedInputAndOutputs;
            }
        };
    }

    private ActionUnderTest theUserSearchesFor(final String searchTerm) {
        return new ActionUnderTest() {
            @Override
            public CapturedInputAndOutputs execute(InterestingGivens interestingGivens, CapturedInputAndOutputs capturedInputAndOutputs) throws Exception {
                interestingGivens.add("Search term", searchTerm);
                ((FindOwnersPage)currentPage).setSearchTerm(searchTerm);
                currentPage = ((FindOwnersPage)currentPage).submitSearchForm();
                return capturedInputAndOutputs;
            }
        };
    }

    private GivensBuilder theUserIsAtTheApplicationHomePage() {
        return new GivensBuilder() {
            @Override
            public InterestingGivens build(InterestingGivens interestingGivens) throws Exception {
                currentPage = homepage.clickHome();
                return interestingGivens;
            }
        };
    }

}
