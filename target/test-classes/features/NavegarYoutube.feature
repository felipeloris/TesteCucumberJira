Feature: NavegarYoutube
	Navegar no canal @TheNoite do youtube usando Selenium

  Scenario: Navegar no canal do youtube usando Selenium
    Given Abrir a pagina do Youtube
    When Procurar pelo canal @TheNoite no youtube
    And Navegar para o canal
    Then Verificar o titulo da pagina
