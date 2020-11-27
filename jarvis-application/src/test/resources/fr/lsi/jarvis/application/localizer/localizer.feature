#Author: lau.sion@gmail.com
# Scénario pour le service de localisation
@tag
Feature: localizer
  Le service de localisation permet l ajout de lieux ainsi que de savoir ou on est positionné par rapport à un lieux

  @tag1
  Scenario Outline: L utilisateur veut ajouter un lieu
    Given L utilisateur veut ajouter "<locationName>" comme lieu
    When L utilisateur fait une demande d ajout avec la <longitude> et la <lattitude>
    Then L utilisateur verifie que le statut de la demande est <status>

    Examples:	 
      | locationName  | longitude  | lattitude  | status |
      | maison        | 50.3106593 | 3.3398644  | OK     |
      | travail Veto  | 50.3271336 | 3.3968988  | OK     |
      | travail       | 50.3271336 | 3.3968988  | NOK    |


