package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalculatorandToolsPage {

  public WebDriver driver;

  By applicationTypeInput1 = By.xpath("//label[@for='application_type_single']/input");

  By numberOfDependantsDropdown = By.xpath("//select[@title='Number of dependants']");

  By propertyLikeToByInput = By.xpath("//input[@id='borrow_type_home']");
  By yourAnnualIncomeBeforeTax = By.xpath("//label[contains(.,'Your annual income (before tax)')]//..//div[@class='input__wrapper']/input");
  By yourAnnualOtherIncome = By.xpath("//label[contains(.,'Your annual other income (optional)')]//..//div[@class='input__wrapper']/input");
  By monthlyLivingExpenses = By.id("expenses");
  By currentHomeLoan = By.id("homeloans");
  By otherLoanRepayment = By.id("otherloans");
  By otherCommintments = By.xpath("//label[contains(.,'Other monthly commitments')]//..//div[@class='input__wrapper']/input");
  By totalCreditCardLimit = By.xpath("//label[contains(.,'Total credit card limits')]//..//div[@class='input__wrapper']/input");

  By borrowCalculator = By.xpath("//button[@id='btnBorrowCalculater']");

  By borrowEstimateText = By.cssSelector("h3[class='homeloan__borrow__text']");
  By borrowEstimateAmount = By.cssSelector("#borrowResultTextAmount");
  By borrowerEstimatedAmountwithCalculatedPrice = By.xpath("//span[@id='borrowResultTextAmount' and contains(.,'$419,000')]");

  By startOverButton = By.xpath("(//button[@role='button' and contains(.,'Start over')]/span)[1]");

  By borrowText = By.cssSelector(".borrow__error__text");

  public CalculatorandToolsPage(WebDriver driver) {

    this.driver = driver;

  }

  public String getNumberOfDependants(String noOfDependants) {

    WebElement dependants = driver.findElement(By.xpath("//select[@title='Number of dependants']"));
    Select noOfDependantsDropDown = new Select(dependants);
    noOfDependantsDropDown.selectByVisibleText(noOfDependants);
    return noOfDependants;
  }

  public WebElement getPropertyLikeTobyInput() {

    WebElement propertyLikeTobyInput = driver.findElement(propertyLikeToByInput);
    return propertyLikeTobyInput;
  }

  public WebElement getApplicationTypeInput() {

    WebElement applicationTypeInput = driver.findElement(applicationTypeInput1);
    return applicationTypeInput;
  }

  public WebElement getAnnualIncomeBeforeTax() {

    WebElement annualIncomeBeforeTax = driver.findElement(yourAnnualIncomeBeforeTax);

    return annualIncomeBeforeTax;
  }

  public WebElement getOtherEarnings() {
    WebElement otherAnnualIncome = driver.findElement(yourAnnualOtherIncome);

    return otherAnnualIncome;
  }

  public WebElement getMonthlyExpenses() {
    WebElement monthlyExpenses = driver.findElement(monthlyLivingExpenses);

    return monthlyExpenses;
  }

  public WebElement getCurrentHomeLoan() {
    WebElement HomeLoan = driver.findElement(currentHomeLoan);

    return HomeLoan;
  }

  public WebElement getOtherLoanRepayment() {
    WebElement OtherLoan = driver.findElement(otherLoanRepayment);

    return OtherLoan;
  }

  public WebElement getOtherCommintments() {
    WebElement Commitments = driver.findElement(otherCommintments);

    return Commitments;
  }

  public WebElement getTotalCreditCardLimit() {
    WebElement CreditLimit = driver.findElement(totalCreditCardLimit);

    return CreditLimit;
  }

  public WebElement getHowMuchCouldBorrow() {
    WebElement CouldBorrow = driver.findElement(borrowCalculator);
    return CouldBorrow;

  }

  public String getBorrowEstimateText() {
    String EstimateBorrowText = driver.findElement(borrowEstimateText).getText();
    return EstimateBorrowText;

  }

  public String getBorrowEstimateAmount() {
    String EstimateBorrowAmount = driver.findElement(borrowEstimateAmount).getText();

    String amount = EstimateBorrowAmount;
    return amount;

  }

  public WebElement getStartOverClicked() {
    WebElement clickStartOverButton = driver.findElement(startOverButton);

    return clickStartOverButton;


  }

  public String getBorrowErrorText() {
    String borrowTextError = driver.findElement(borrowText).getText();

    return borrowTextError;
  }


}
