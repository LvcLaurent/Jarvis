#Author: lau.sion@gmail.com
# Scénario pour le service d'authentification
@tag
Feature: account
  Le service account permet la création de compte, le changement de mot de passe, ainsi que tout la partie modification et connexion à l API

  @tag1
  Scenario Outline: L utilisateur veut créer un compte dans l application
    Given L utilisateur veut créer un compte avec identifiant "<login>", le "<tel>" et adresse mail "<mail>" : est-ce <possible>
    When Si le mail et le login n existe pas en base alors une demande est fait avec le "<mdp>", l adresse "<rue>", le "<codeP>", la "<ville>", le "<nom>" et le "<prenom>", avec etat <admin> si pas possible <code>
    Then Le compte est bien <etat> dans la base de donnée en invité

    Examples: 
      | login      | mail                       | mdp        | tel        | nom       | prenom  | rue                     | codeP | ville  | possible | etat | code | admin |
      |            | newadress@hotmail.com      | Qsdfgh21!  | 0855221144 | Sion      | bilbon  | 134 rue jean jaures     | 59172 |  59172 | false    | NOK  | 2001 | false |
      | lvclaurent | lau.sion@gmail.com         | AZERTY1!   | 0617382442 | Sion      | Laurent | 134 rue jean jaures     | 59172 | Roeulx | true     | NOK  | 2008 | false |
      | lvclaurent | lau.sion@gmail.com         | Azerty1!   | 0617382442 | Sion      | Laurent | 134 rue jean jaures     | 59172 | Roeulx | true     | OK   |  200 | true  |
      | Marcel     | laurent.sion@gfi.fr        | Sdv!!d478  | 0385356845 | Sion      | Marcel  | 134 rue jean jaures     | 62136 | Roeulx | true     | OK   |  200 | false |
      | Marcel     | lau2.sion@gmail.com        | Msdji48??  | 0754236845 | Sion      | Laurent | 10 rue Leo Lagrange     | 59874 | Ouille | false    | NOK  | 2001 | false |
      | bakanezumi | pauline.trigault@gmail.com | TouTou62!  | 0532557896 | Sion      | Pauline | 134 rue Jean Jaures     | 59000 | Coool  | true     | OK   |  200 | false |
      | bakanonos  | pauline.trigault@gmail.com | OyeOye999? | 0456321657 | Sion      | Nonos   | 1346 rue de la paix     | 94000 | Paris  | false    | NOK  | 2000 | false |
      | reyvun     | loic.trigault@gmail.com    | mot25!ass  | 0523579864 | Trigault  | Loic    | 10 rue Leo Lagrance     | 65245 | Roeulx | true     | NOK  | 2008 | false |
      | roikku1    | roiku1@gmail.com           | Laurent62  | 0632187986 | Trigault  | Roikku  | 134 rue Jean jaures     | 32547 | Roeulx | true     | NOK  | 2008 | false |
      | roikku2    | roiku2@gmail.com           | okok12!!!  | 0632187986 | Trigault  | Roikku  | 134 rue Jean jaures     | 32547 | Roeulx | true     | NOK  | 2008 | false |
      | roikku3    | roiku3@gmail.com           | okok       | 0632187986 | Trigault  | Roikku  | 134 rue Jean jaures     | 32547 | Roeulx | true     | NOK  | 2008 | false |
      | bilbon     | hobbit.joufkye@laposte.net | ProutMas?  | 0636888888 | Couillon  | Bilbon  | -35 rue de ta mère      | 88568 | Nastu  | true     | NOK  | 2008 | false |
      | bilbon3    | hobbit.jouflue@laposte.net | Azerty3!!  | 2158632165 | Couillon2 | Bilbon  | 123 rue de chez soit    | 62158 | TrouP  | false    | NOK  | 2003 | false |
      | bilbon3    | hobbit.jmlflue@laposte.net | Azerty3!!  | 01586fg165 | Couillon2 | Bilbon  | 123 rue de chez soit    | 62158 | TrouP  | false    | NOK  | 2003 | false |
      | bilbon62   | holbit.jouflue@laposte.net | Qsdfgh21!  |      06368 | Aucun     | bilbon  | je sais pas ou j habite | 00000 | ?????  | false    | NOK  | 2003 | false |
      | Marcel62   | marcelpan@hotmail.com      | Qsdfgh21!  | 0617382442 | Sion      | bilbon  | 134 rue jean jaures     | 59172 |  59172 | false    | NOK  | 2004 | false |
      |            | newadress@hotmail.com      | Qsdfgh21!  | 0855221144 | Sion      | bilbon  | 134 rue jean jaures     | 59172 |  59172 | false    | NOK  | 2001 | false |
      | Marcel62   |                            | Qsdfgh21!  | 0855221144 | Sion      | bilbon  | 134 rue jean jaures     | 59172 |  59172 | false    | NOK  |  400 | false |
      | Marcel63   | newadress@hotmail.com      | Qsdfgh21!  |            | Sion      | bilbon  | 134 rue jean jaures     | 59172 |  59172 | true     | OK   |  200 | false |
      | Marcel62   | newadress3@hotmail.com     |            | 0785352156 | Sion      | bilbon  | 134 rue jean jaures     | 59172 |  59172 | true     | NOK  | 2008 | false |
      | Marcel62   | newadress3@hotmail.com     | Qsdfgh21!  | 0785352156 |           |         |                         |       |        | true     | OK   |  200 | false |
      | Marcel83   | newadres12@hotmail.com     | Qsdfgh21!  | 0786542156 |           |         |                         |       |        | true     | OK   |  200 | false |
      | Marcel85   | newadres65@hotmail.com     | Qsdfgh21!  | 0785355486 |           |         |                         |       |        | true     | OK   |  200 | false |

  @tag2
  Scenario Outline: L admin veut ajouter un admin en base
    Given L admin fait la demande pour le "<login>" et attend un <retour>
    When l API fait la modifcation avec le "<loginAdmin>", le "<mdpAdmin>" et attend le <retour>
    Then Vérification en base avec le <status>

    Examples: 
      | login       | retour | loginAdmin  | mdpAdmin | statut |
      | lvclaurent  |   2070 | bakanezumi  | mdpAdmin | NOK    |
      | bakanezumi  |   2005 | lvclaurent5 | mdpAdmin | NOK    |
      | bakanezumi  |    200 | lvclaurent  | Azerty1! | OK     |
      | bakanezumi  |   2008 | lvclaurent  |          | NOK    |
      | bakanezumi  |   2005 |             | Azerty1! | NOK    |
      | bakanezumi  |   2011 | lvclaurent  | Azerty2! | NOK    |
      | lvclaurent5 |   2005 | lvclaurent  | mdpAdmin | NOK    |
      |             |    400 | lvclaurent  | mdpAdmin | NOK    |

  @tag3
  Scenario Outline: L utilisateur veut se connecter à l api
    Given L utilisateur veut se connecter avec son "<login>" et son "<mdp>"
    When L api vérifie que la demande est <viable>
    Then L utilisateur <arrive> à se connecter sinon il a le <code> suivant

    Examples: 
      | login       | mdp        | arrive | viable | code |
      | lvclaurent  | Azerty1!   | true   | true   |  200 |
      | lvclaurent  | motdepasse | false  | false  | 2008 |
      | lvclaurent  | Azerty3!   | false  | true   | 2011 |
      | lvclaurent3 | Qsdfghj2!! | false  | true   | 2005 |
      | bakanezumi  | TouTou62!  | true   | true   |  200 |
      | banezumi    | qd4e       | false  | false  | 2008 |
      | bakanezumi  | qd4e       | false  | false  | 2008 |
      |             | Qsdfgh21!  | false  | false  |  400 |
      | bakanezumi  |            | false  | false  | 2008 |

  @tag4
  Scenario Outline: un utilisateur admin veut activer un compte
    Given L admin remonte le nombre de compte à activer avec son "<loginAdmin>" et son "<mdpAdmin>"
    When L admin active le compte "<login>"
    Then L admin vérifie que "<login>" est bien <retour>

    Examples: 
      | login      | retour | loginAdmin | mdpAdmin  |
      | lvclaurent |   2070 | Marcel62   | Qsdfgh21! |
      | lvclaurent |    200 | lvclaurent | Azerty1!  |
      | bakanezumi |    200 | lvclaurent | Azerty1!  |
      | bakanezumi |   2011 | lvclaurent | Azerty3!  |
      | Marcel69   |   2005 | lvclaurent | Azerty1!  |
      |            |    400 | lvclaurent | Azerty1!  |
      | bakanezumi |   2008 | lvclaurent |           |
      | bakanezumi |    400 |            | Azerty1!  |

  @tag5
  Scenario Outline: L admin veut ajouter l acces à la position pour un utilisateur
    Given L admin fait la demande d acces pour le "<login>" avec son "<loginAdmin>" et son "<mdpAdmin>"
    When l API ajoute le droit a l api localizer
    Then La demande est bien enregistrer en base avec un retour <retour>

    Examples: 
      | login       | retour | loginAdmin | mdpAdmin  |
      | lvclaurent  |   2070 | Marcel62   | Qsdfgh21! |
      | lvclaurent  |    200 | lvclaurent | Azerty1!  |
      | lvclaurent5 |   2005 | lvclaurent | Azerty1!  |
      |             |    400 | lvclaurent | Azerty1!  |
      | lvclaurent5 |   2005 |            | Azerty1!  |
      | lvclaurent5 |   2008 | lvclaurent |           |

  @tag6
  Scenario Outline: Un utilisateur vérifie si il a acces a localizer
    Given L api fait la demande pour son "<login>" et son "<password>"
    When l API fait la vérification
    Then l api retour qu il a <acces> à localizer

    Examples: 
      | login       | acces | password |
      | Marcel      | false | Test12k  |
      | lvclaurent  | true  | Azerty1! |
      |             |   400 | Azerty1! |
      | lvclaurent  |  2008 |          |
      | lvclaurent  | false | Azert31! |
      | lvclaurent3 |  2005 | Dm452    |

  @tag7
  Scenario Outline: L admin veut supprimer un utilisateur en base non admin
    Given L admin fait la demande de suppression pour le "<login>"
    When l API fait la suppression avec le "<loginAdmin>" et son "<password>"
    Then l utilisateur nes pas présent en base avec un <retour>

    Examples: 
      | login       | retour | loginAdmin | password  |
      | lvclaurent  |   2070 | Marcel62   | Qsdfgh21! |
      | lvclaurent3 |   2005 | lvclaurent | Azerty1!  |
      | Marcel62    |   2011 | lvclaurent | Azerty3!  |
      | Marcel62    |   2008 | lvclaurent |           |
      | Marcel62    |    400 |            | Azerty1!  |
      | Marcel62    |    200 | lvclaurent | Azerty1!  |
      | bakanezumi  |   2020 | lvclaurent | Azerty1!  |
      | lvclaurent3 |   2005 | lvclaurent | Azerty1!  |
      | lvclaurent3 |   2005 |            | Azerty1!  |
      |             |    400 | lvclaurent | Azerty1!  |
      | lvclaurent3 |   2005 | lvclaurent | Azerty1!  |

  @tag8
  Scenario Outline: L admin récupère la liste des compte inactif
    Given L api recherche l ensemble des utilisateurs non actif
    When l API fait la recherche de la liste des inactif
    Then Vérification qu il y a bien le <nb> de compte inactif 

    Examples: 
      | nb |
      | 4  |

  @tag9
  Scenario Outline: L api supprime tout les utilisateurs en base
    Given L api recherche l ensemble des utilisateurs
    When l API fait la suppression de l ensemble des uutilisateur
    Then Il n y a plus rien dans la base


  @tag10
  Scenario Outline: L admin récupère la liste des compte inactif
    Given L api recherche l ensemble des utilisateurs non actif
    When l API fait la recherche de la liste des inactif
    Then Vérification qu il y a bien le <nb> de compte inactif 

    Examples: 
      | nb |
      | 0  |