package browserstack.stepdefs;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import browserstack.utils.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LoginPageSteps  {

	 @And("I press Log In Button")
	    public void iPressLogin() {
	        ThreadLocalDriver.getWebDriver().findElement(By.cssSelector(".Button_root__24MxS")).click();
	    }

	    @Then("I should see {string} as Login Error Message")
	    public void iShouldSeeAsLoginErrorMessage(String expectedMessage) {
	        WebDriverWait wait = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 5);
	        try {
	            String errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".api-error"))).getText();
	            Assert.assertEquals(expectedMessage, errorMessage);
	        } catch (NoSuchElementException e) {
	            throw new AssertionError("Error in logging in");
	        }
	    }

	    @And("I SignIn as {string} with {string} password")
	    public void iSignInAsWithPassword(String username, String password) {
	        WebDriverWait wait = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 5);
	        ThreadLocalDriver.getWebDriver().findElement(By.linkText("Sign In")).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username > div > div:nth-child(1)"))).click();
	        ThreadLocalDriver.getWebDriver().findElement(By.id("react-select-2-input")).sendKeys(username);
	        ThreadLocalDriver.getWebDriver().findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);
	        ThreadLocalDriver.getWebDriver().findElement(By.cssSelector("#password > div > div:nth-child(1)")).click();
	        ThreadLocalDriver.getWebDriver().findElement(By.id("react-select-3-input")).sendKeys(password);
	        ThreadLocalDriver.getWebDriver().findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
	        ThreadLocalDriver.getWebDriver().findElement(By.cssSelector(".Button_root__24MxS")).click();
	        Utility.mockGPS(ThreadLocalDriver.getWebDriver());
	    }

}