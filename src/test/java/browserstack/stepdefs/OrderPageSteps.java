package browserstack.stepdefs;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;


public class OrderPageSteps  {


	 @Then("I should see elements in list")
	    public void iShouldSeeElementsInList() {
	        WebDriverWait wait = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 5);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logout")));
	        WebElement element = null;
	        try {
	            element = ThreadLocalDriver.getWebDriver().findElement(By.cssSelector("#__next > main > div > div"));
	            List<WebElement> orders = element.findElements(By.tagName("div"));
	            Assert.assertNotEquals(0, orders.size());
	        } catch (NoSuchElementException e) {
	            throw new AssertionError("There are no orders");
	        }
	    }

}