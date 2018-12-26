Feature: Groups

#    Scenario: Group creation
#      Given a set of groups
#      When  I create new  groups with name xxx, header yyy and footer zzz
#      Then  the new set of groups is equal to the old set with the added group
    Scenario Outline: Group creation
      Given a set of groups
      When  I create new  groups with name <name>, header <header> and footer <footer>
      Then  the new set of groups is equal to the old set with the added group

      Examples:
      | name      | header      | footer       |
      | test name | test header | test footer  |
      | test name1 | test header1 | test footer1  |