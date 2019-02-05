package com.Olympics.pages;

import com.Olympics.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import java.util.List;

public class OlympicTablePage extends TestBase {

    public OlympicTablePage(WebDriver driver) {
        this.driver = driver;
        //using the driver initialize or locate all elements in this class
        PageFactory.initElements(driver, this);
    }

    //Using @FindBy specify a way to locate the webelement
    @FindBy(xpath="//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position()>0 and position()<11]/td[1]")
    public List<WebElement> rankRow;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[2]")
    public WebElement noc;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th[position()>0 and position()<11]")
    public List<WebElement> countryNames;

    @FindBy(xpath="/table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() > 0 and position() < 12 and not(position()=8)]/td[1]")
    public List <WebElement> afterRankRow;

    int current;
    int next;

    public void order(){
        for (int i = 0; i < rankRow.size()-1; i++) {
            current = Integer.parseInt(rankRow.get(i).getText());
            next = Integer.parseInt(rankRow.get(i+1).getText());
            Assert.assertTrue(next > current);
        }
    }

    public void countryAsci(){
        for (int i = 0; i <countryNames.size()-1; i++) {
            String a = countryNames.get(i).getText();
            String b = countryNames.get(i+1).getText();
            Assert.assertTrue(a.compareTo(b)<0);
        }
    }
    //5. Verify that Rank column is not in ascending order anymore.
    public void orderAfterRank() {
        for (int i = 0; i < afterRankRow.size() - 1; i++) {
            current = Integer.parseInt(afterRankRow.get(i).getText());
            next = Integer.parseInt(afterRankRow.get(i + 1).getText());
            Assert.assertFalse(next != current);
        }
    }
}