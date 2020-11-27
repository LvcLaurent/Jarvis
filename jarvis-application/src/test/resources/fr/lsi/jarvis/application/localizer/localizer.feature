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
      | locationName | longitude  | lattitude | status |
      | maison       | 50.3106593 | 3.3398644 | OK     |
      | travail Veto | 50.3271336 | 3.3968988 | OK     |
      | travail      | 50.3271336 | 3.3968988 | NOK    |

  @tag2
  Scenario Outline: L utilisateur connaitre sa position en fonction des lieux présent en base
    Given L utilisateur veut ajouter fournit la <longitude> et la <lattitude>
    When Un calcul est effectuer par l API
    Then la <distance1> et la <distance2> correspond bien à la distance attendu

    Examples: 
      | longitude  | lattitude | distance1 | distance2 |
      | 50.3106593 | 3.3398644 |         0 |      4444 |
      | 50.3271336 | 3.3968988 |      4444 |         0 |
      | 50.3271336 | 3.3968988 |      4444 |         0 |

  @tag3
  Scenario Outline: L utilisateur veut supprimer tout les lieux en base
    Given L utilisateur fait la demande
    When l API fait la suppression
    Then Il n y a plus rien en base
