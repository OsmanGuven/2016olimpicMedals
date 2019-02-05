package com.Olympics.tests;

import com.Olympics.pages.MedalTablePage;
import com.Olympics.utilities.BrowserUtilities;
import com.Olympics.utilities.ConfigurationReader;
import com.Olympics.utilities.TestBase;
import com.sun.tools.internal.jxc.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;



public class MedalTableTests extends TestBase {
    MedalTablePage medalTablePage;

    /*
        Go to the page
        Verify that Rank is sorted
     */
    @Test
    public void sortTest() {
        medalTablePage = new MedalTablePage();

        // 1. Go to url
        driver.get(ConfigurationReader.getProperty("url"));

//        // Store the elements of Rank column in a String []
//        String[] test = BrowserUtils.elementsToStringArray(
//                medalTablePage.tableRows);
//
//        System.out.println(Arrays.toString(test));
//
//        String[] strArr = BrowserUtils.elementsToStringArray(
//                medalTablePage.tableHeadings);
//
//        System.out.println(Arrays.toString(strArr));

        // correct chained methods
        String[] foundIt = BrowserUtilities.elementsToStringArray(
                medalTablePage.medalTableColumnElements("Rank")
        );

        System.out.println(Arrays.toString(foundIt));

        int[] toTest = BrowserUtilities.convertStringArrayToIntArray(foundIt);
        System.out.println(Arrays.toString( toTest ));

        // Verify that Rank is sorted
        for (int i = 0; i < toTest.length - 1; i++) {
            Assert.assertTrue(toTest[i + 1] == toTest[i] + 1);
            System.out.println("1st element " + toTest[i] + " vs next element " +
                    toTest[i + 1]);
        }
    }
}
