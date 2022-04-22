Feature: Changing address

  Scenario Outline: change my address
    Given  open the main page and press the singin
    When login into the shop page with my email <email> and password <password>
    And set the alias <alias> address <address> city <city> zip <zip> phone <phone>
    And verify the data
    And delete the data and verify
    Then close browser

    Examples:
      | email                        | password | alias   | address       | city     | zip    | phone        |
      | hcggctlmtnzicmznqu@bvhrk.com | hasło    | Brygida | Golędzinowska | Warszawa | 03-302 | 72 260 72 18 |
