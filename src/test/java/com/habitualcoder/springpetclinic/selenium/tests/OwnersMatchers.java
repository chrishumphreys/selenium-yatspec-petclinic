package com.habitualcoder.springpetclinic.selenium.tests;

import com.habitualcoder.springpetclinic.selenium.owners.pages.OwnerPage;
import com.habitualcoder.springpetclinic.selenium.utils.selenium.Page;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OwnersMatchers {

    public static Matcher<Page> theOwnersPage(Matcher<Page>... additionalMatchers) {
        List<Matcher<? super Page>> matchers = new ArrayList<Matcher<? super Page>>();
        matchers.add(pageNameMatcher("Owners"));
        matchers.addAll(Arrays.asList(additionalMatchers));
        return Matchers.allOf((Iterable<Matcher<? super Page>>) matchers);
    }

    public static Matcher<Page> forOwnerName(final String ownerName) {
        return new TypeSafeMatcher<Page>() {
            @Override
            protected boolean matchesSafely(Page item) {
                return item instanceof OwnerPage &&
                        ((OwnerPage)item).getName().equals(ownerName);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("owner name ").appendValue(ownerName);
            }
        };
    }

    public static Matcher<Page> withAddress(final String address) {
        return new TypeSafeMatcher<Page>() {
            @Override
            protected boolean matchesSafely(Page item) {
                return item instanceof OwnerPage &&
                        ((OwnerPage)item).getAddress().equals(address);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("owner address ").appendValue(address);
            }
        };
    }

    public static Matcher<Page> withCity(final String city) {
        return new TypeSafeMatcher<Page>() {
            @Override
            protected boolean matchesSafely(Page item) {
                return item instanceof OwnerPage &&
                        ((OwnerPage)item).getCity().equals(city);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("owner city ").appendValue(city);
            }
        };
    }

    public static Matcher<Page> withTelephone(final String telephone) {
        return new TypeSafeMatcher<Page>() {
            @Override
            protected boolean matchesSafely(Page item) {
                return item instanceof OwnerPage &&
                        ((OwnerPage)item).getTelephone().equals(telephone);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("owner telephone ").appendValue(telephone);
            }
        };
    }



    public static Matcher<Page> theFindOwnersPage() {
        return pageNameMatcher("Find Owners");
    }

    public static Matcher<Page> theAddOwnerPage() {
        return pageNameMatcher("Add Owner");
    }

    public static TypeSafeMatcher<Page> pageNameMatcher(final String name) {
        return new TypeSafeMatcher<Page>() {
            @Override
            protected boolean matchesSafely(Page item) {
                return item.getInternalPageName().equals(name);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("page with name of ").appendValue(name);
            }
        };
    }
}
