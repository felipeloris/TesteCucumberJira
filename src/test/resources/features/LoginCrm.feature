Feature: LoginCrm
	Realizar o login na plataforma CRM da empresa

  Scenario: Login na plataforma CRM da empresa com sucesso
    Given Acesso a plataforma CRM da empresa
    Given Forneco o usuario "Pedrinho"
    Given Forneco a senha "senha_certa"
    When Pressiono o botao login
    Then Acesso a area privada da plataforma CRM da empresa

  Scenario: Login na plataforma CRM da empresa com erro usuario invalido
    Given Acesso a plataforma CRM da empresa
    Given Forneco o usuario "Inexistente"
    Given Forneco a senha "senha_certa"
    When Pressiono o botao login
    Then Acesso a area privada da plataforma CRM da empresa    

  Scenario: Login na plataforma CRM da empresa com erro senha invalida
    Given Acesso a plataforma CRM da empresa
    Given Forneco o usuario "Pedrinho"
    Given Forneco a senha "senha_invalida"
    When Pressiono o botao login
    Then Acesso a area privada da plataforma CRM da empresa        
