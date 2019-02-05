package com.Olympics.pages;

import com.Olympics.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class MedalsPage extends TestBase {
    public MedalsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        /*
    1. Write a method that returns the name of the country with the greatest
    number of gold medals.
    2. Write a method that returns the name of the country with the greatest
    number of silver medals.
    3. Write a method that returns the name of the country with the greatest
    number of bronze medals.
    4. Write a method that returns the name of the country with the greatest
    number of medals.
     */

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr[position() > 0 and position() < 11]/td[2]")
    List<WebElement> goldColumn;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr[position() > 0 and position() < 11]/td[3]")
    List<WebElement> silverColumn;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr[position() > 0 and position() < 11]/td[4]")
    List<WebElement> bronzeColumn;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr[position() > 0 and position() < 11]/td[5]")
    List<WebElement> totalColumn;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr/th/a")
    List<WebElement> countries;


    public String getAnyMaxMedalsCountry(List<WebElement> medalColumn) {
        int mostMedalNo = 0;
        int medalIndex = 0;

        for (int i = 0; i < medalColumn.size() ; i++) {
            int medalNo = Integer.parseInt(medalColumn.get(i).getText());
            if (medalNo > mostMedalNo) {
                mostMedalNo = medalNo;
                medalIndex = i;
            }
        }
        System.out.println(mostMedalNo);
        String mostCountry = countries.get(medalIndex).getText();
        return mostCountry;
    }

    //1. Write a method that returns the name of the country with the greatest number of gold medals.
    public String getMostGoldMedalCountry() {
        return getAnyMaxMedalsCountry(goldColumn);
    }

    //2. Write a method that returns the name of the country with the greatest number of silver medals.
    public String getMostSilverMedalCountry() {
        return getAnyMaxMedalsCountry(silverColumn);
    }

    //3. Write a method that returns the name of the country with the greatest number of bronze medals.
    public String getMostBronzeMedalCountry() {
        return getAnyMaxMedalsCountry(bronzeColumn);
    }

    //4. Write a method that returns the name of the country with the greatest number of medals.
    public String getMostMedalCountry() {
        return getAnyMaxMedalsCountry(totalColumn);
    }
}