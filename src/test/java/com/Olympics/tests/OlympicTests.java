package com.Olympics.tests;

import com.Olympics.pages.*;
import com.Olympics.utilities.TestBase;
import org.testng.annotations.Test;


public class OlympicTests extends TestBase {
    OlympicTablePage olympic;
    MedalsPage medalsPage;
    CountryByMedal countries;
    GetIndex getIndex;
    GetSum sum;
    @Test
    public void sort() {
        olympic = new OlympicTablePage(driver);
        olympic.order();
        olympic.noc.click();
        olympic.countryAsci();
        olympic.orderAfterRank();

    }
    @Test
    public void medal(){
        medalsPage = new MedalsPage(driver);
        medalsPage.getMostBronzeMedalCountry();
        medalsPage.getMostGoldMedalCountry();
        medalsPage.getMostSilverMedalCountry();
        medalsPage.getMostMedalCountry();

    }

    @Test
    public void country(){
        countries = new CountryByMedal(driver);
        countries.silverCountries();
    }

    @Test
    public void getIndex(){
        getIndex = new GetIndex(driver);
        getIndex.getCell("United States");
    }

    @Test
    public void getSum() {
        sum = new GetSum(driver);
        sum.sumMedals();
    }
}
