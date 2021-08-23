package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver sdriver){
        this.driver = sdriver;
    }

    @FindBy(name = "q" )
    WebElement input;

    @FindAll({
            @FindBy(xpath = "//cite")
    })
    private List<WebElement> results;

    public void searchText(String text){
        input.sendKeys(text);
        input.submit();
    }

    public void resultsFind(){

       for (int i = 0; i < results.size(); i++)
        {
           System.out.println(results.get(i).getText());
        }
        Assert.assertEquals(results.get(0).getText(),"https://kirasystems.com");
    }

}
