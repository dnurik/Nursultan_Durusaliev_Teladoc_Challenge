@Assignment
Feature: Create new employee functionality Validation
  Scenario: First repeated steps in all  scenarios
    Given user navigates to Protractor application
    And user clicks on Add User button

  Scenario Outline: Validating Create employee functionality with valid data
    And user creates user with data
      | First Name | <First Name>  |
      | Last Name  | <Last Name>   |
      | User Name  | <User Name>   |
      | Password   | <Password>    |
      | Customer   | <Customer>    |
      | Role       | <Role>        |
      | Email      | <Email>       |
      | Cell Phone | <Cell Phone > |

    Then user validates that user added to the list
    Examples:
      | First Name | Last Name | User Name | Password | Customer    | Role       | Email              | Cell Phone |
      | Paul       | Kim       | paul kim  | 12345    | Company AAA | Sales Team | pkim@gmail.com | 123456789  |

Feature: Create delete user functionality Validation
  Scenario: First repeated steps in all  scenarios
    Given user navigates to Protractor application
    And user clicks on delete button
    Then user validates that user deleted from the list
