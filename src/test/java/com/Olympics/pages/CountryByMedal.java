package com.Olympics.pages;


import com.Olympics.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class Countries extends TestBase {
    public Countries(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*
    Test Case 3: COUNTRY BY MEDAL
    1. Write a method that returns a list of countries by their silver medal count.
    You decide the datatype of the return.
     */

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() >0 and position() <11]/td[3]")
    public List<WebElement> silverCounts;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() >0 and position() <11]/th")
    public List<WebElement> countries;

    public String silverCountries() {
        int mostCount = 0;
        int countIndex = 0;

        for (int i = 0; i < countries.size() ; i++) {
            int countNo = Integer.parseInt(silverCounts.get(i).getText());
            if (countNo > mostCount ) {
                mostCount = countNo;
                countIndex = i;
            }
        }
        System.out.println(mostCount);
        String listCountry = countries.get(countIndex).getText();
        System.out.println(listCountry);
        return listCountry;
    }
}