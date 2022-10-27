package stepDefinitions;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CalculatorandToolsPage;


import resources.baseClass;

import org.junit.runner.RunWith;

public class calculatorAndToolsteps extends baseClass {


  @Given("^Launch The Browser$")
  public void launch_the_browser() throws Throwable {
    driver = initializeWebDriver();
  }

  @When("^I select User details$")
  public void i_select_user_details() throws Throwable {
    CalculatorandToolsPage ctp = new CalculatorandToolsPage(driver);
    ctp.getApplicationTypeInput().click();
    ctp.getNumberOfDependants("0");
    ctp.getPropertyLikeTobyInput().click();
  }

  @Then("^Verify that borrowing estimate is successfully returned$")
  public void verify_that_borrowing_estimate_is_successfully_returned() throws Throwable {
    CalculatorandToolsPage ctp = new CalculatorandToolsPage(driver);
    String ActualEstimateText = ctp.getBorrowEstimateText();
    String ExpectedEstimateText = "We estimate you could borrow:";
    WebDriverWait wait = new WebDriverWait(driver, 300000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='borrowResultTextAmount' and contains(.,'$419,000')]")));
    String actualAmount = ctp.getBorrowEstimateAmount();
    String expectedAmount = "$419,000";


    Assert.assertEquals(ActualEstimateText, ExpectedEstimateText);
    Assert.assertEquals(actualAmount, expectedAmount);
  }

  @And("^Navigate to ANZ URL$")
  public void navigate_to_anz_url() throws Throwable {
    driver.get(properties.getProperty("url"));
  }

  @And("^User enters earnings as \"([^\"]*)\" and \"([^\"]*)\"$")
  public void earnings(String annualIncome, String annualOthIncome) throws Throwable {
    CalculatorandToolsPage ctp = new CalculatorandToolsPage(driver);
    ctp.getAnnualIncomeBeforeTax().sendKeys(annualIncome);
    ctp.getOtherEarnings().sendKeys(annualOthIncome);
  }

  @And("^User enters expenses as \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
  public void expenses(String monthly_living_expenses, String current_home_loan_monthly_repayment, String other_loan_monthly_repayment, String other_monthly_commitments, String total_credit_card_limit) throws Throwable {
    CalculatorandToolsPage ctp = new CalculatorandToolsPage(driver);
    ctp.getMonthlyExpenses().sendKeys(monthly_living_expenses);
    ctp.getCurrentHomeLoan().sendKeys(current_home_loan_monthly_repayment);
    ctp.getOtherLoanRepayment().sendKeys(other_loan_monthly_repayment);
    ctp.getOtherCommintments().sendKeys(other_monthly_commitments);
    ctp.getTotalCreditCardLimit().sendKeys(total_credit_card_limit);
  }

  @And("^I click on \"Work out how much I could borrow\" button$")
  public void iClickOnButton() {
    CalculatorandToolsPage ctp = new CalculatorandToolsPage(driver);
    ctp.getHowMuchCouldBorrow().click();
  }

  @And("^I close the browser$")
  public void closeBrowser() {
    driver.close();
  }

  @And("^I click on \"Start over\"$")
  public void iClickOnStartOverButton() throws InterruptedException {
    //Thread.sleep(20000);
    CalculatorandToolsPage ctp = new CalculatorandToolsPage(driver);
    ctp.getStartOverClicked().click();
  }

  @And("^I enter only \"Living Expenses\" as \"1\"$")
  public void iEnterLivingExpensesOnly() {
    CalculatorandToolsPage ctp = new CalculatorandToolsPage(driver);
    ctp.getMonthlyExpenses().sendKeys("1");
  }

  @Then("^I should see a message as \"([^\"]*)\"$")
  public void verifyMessage(String expectedMessage){
    CalculatorandToolsPage ctp = new CalculatorandToolsPage(driver);
    String actualText = ctp.getBorrowErrorText();
    Assert.assertEquals(actualText, expectedMessage);
  }

}


