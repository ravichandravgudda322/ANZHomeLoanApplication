Feature: Home Loan Borrowing Power Calculator

  Scenario Outline: Calculate The Home Loan Borrow amount with Earning and Expanses
    Given Launch The Browser
    And Navigate to ANZ URL
    When I select User details
    And User enters earnings as "<annual_income>" and "<annual_other_income>"
    And User enters expenses as "<monthly_living_expenses>", "<current_home_loan_monthly_repayment>", "<other_loan_monthly_repayment>", "<other_monthly_commitments>" and "<total_credit_card_limit>"
    And I click on "Work out how much I could borrow" button
    Then Verify that borrowing estimate is successfully returned
    And I click on "Start over"
    Then I enter only "Living Expenses" as "1"
    And I click on "Work out how much I could borrow" button
    Then I should see a message as "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."
    And I close the browser
    Examples:
      | annual_income | annual_other_income | monthly_living_expenses | current_home_loan_monthly_repayment | other_loan_monthly_repayment | other_monthly_commitments | total_credit_card_limit |
      | 80000         | 10000               | 500                     | 0                                   | 100                          | 0                         | 10000                   |





