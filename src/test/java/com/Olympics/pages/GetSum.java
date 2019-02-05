package com.Olympics.pages;

import com.Olympics.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class GetSum extends TestBase {
    public GetSum(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /* Test Case 5: GET SUM
       1. Write a method that returns a list of two countries whose sum of bronze medals is 18.
    */

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr/th/a")
    List<WebElement> countriesColumn;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr[position() > 0 and position() < 11]/td[4]")
    List<WebElement> bronzeColumn;


    public String sumMedals() {
        String str = "";

        for(int i = 0; i < bronzeColumn.size(); i++){
            int bronzeOne = Integer.parseInt(bronzeColumn.get(i).getText());
            for(int j= 0; j < bronzeColumn.size(); j++){
                int bronzeTwo = Integer.parseInt(bronzeColumn.get(j).getText());
                if(bronzeOne + bronzeTwo == 18 && i != j){
                    str = countriesColumn.get(i).getText() + " ," + countriesColumn.get(j).getText();
                }
            }
        }
        return str;
    }
}