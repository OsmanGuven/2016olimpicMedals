package com.Olympics.pages;
import com.Olympics.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;


public class GetIndex extends TestBase {
    public GetIndex(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

     /*
    Test Case 4: GET INDEX
    1. Write a method that takes country name and returns the row and column
    number. You decide the datatype of the return.
     */

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody/tr/th/a")
    List<WebElement> countriesRow;

    @FindBy(xpath = "//*[@id='mw-content-text']/div/table[8]/thead/tr/th")
    List<WebElement> headers;


    public String getCell(String country){
        String col ="";
        String row = "";

        for (int i = 0; i <countriesRow.size() ; i++) {
            if(countriesRow.get(i).getText().equals(country)){
                row = "" + (i+1);
            }
            for (int j = 0; j <headers.size() ; j++) {
                if (headers.get(j).getText().equals("NOC")){
                    col = "" + (j+1);
                }
            }
        }
        return "Row: " + row + ", Column: " + col;
    }
}