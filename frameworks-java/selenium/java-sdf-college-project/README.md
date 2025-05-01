## Projeto da cadeira Frameworks para Desenvolvimento de Softwares

* Grupo: **Leonardo Luz & Diego Prestes**
* 5º Semestre ADS

* Site testado [Leonardo-Luz/social-media-website](https://github.com/Leonardo-Luz/social-media-website/)

* Páginas testadas

1. [Página de Cadastro](./src/main/java/ifrs/edu/com/SignInPage.java)
2. [Página Inicial](./src/main/java/ifrs/edu/com/HomePage.java)
3. [Página de Perfil](./src/main/java/ifrs/edu/com/ProfilePage.java)
4. [Página de Login](./src/main/java/ifrs/edu/com/LoginPage.java)

* [Teste do Sistema](./src/test/java/ifrs/edu/com/SystemTest.java)

## Plano de testes

<!-- Login Page (localhost:5432/login) -->
1. Começa na Página de Login
2. Clicar no link "form-to-link" (className) que deve nos leva para a Página de Cadastro


<!-- SignIn Page (localhost:5432/register) -->
1. Inserir no input "name" (name) "SystemTest is a test USER"
2. Inserir no input "age" (name) "99"
3. Inserir no input "username" (name) um UUID (UUID1)
4. Inserir no input "password" (name) outro UUID (UUID2)
5. Clicar no botão "form-button" (className)
6. Aceitar o alert "User succefully created!"
7. Aceitar o alert "User logged succefully", esta ação deve nos leva para a Página Inicial e cria um novo usuário


<!-- Home Page (localhost:5432) -->
1. Clicar no botão "link-to-profile" (id) que deve nos leva para a Página de Perfil


<!-- Profile Page (localhost:5432/profile) -->
1. Clicar no botão "logout-button" (name) que deve nos leva para a Página de Login


<!-- Login Page (localhost:5432/login) -->
1. Inserir no input "username" (name) o UUID1 previamente salvo
2. Inserir no input "password" (name) o UUID2 previamente salvo
3. Clicar no botão "form-button" (className)
4. Aceitar o alert "User logged succefully", esta ação deve nos leva para a Página Inicial e nos logar no usuário previamente cadastrado


<!-- Home Page (localhost:5432) -->
1. Inserir no input "chat-text-input" (className) a mensagem: UUID1 + UUID2
2. Clicar no botão "chat-text-submit" (className) para enviar mensagem e checar se a mensagem foi enviada com sucesso.
3. Inserir no input "chat-text-input" (className) a mensagem "/clear"
4. Clicar no botão "chat-text-submit" (className) para enviar mensagem e checar se não há mais mensagens no sistema.
5. Clicar no botão "link-to-profile" (id) que deve nos leva para a Página de Perfil


<!-- Profile Page (localhost:5432/profile) -->
1. Clicar no botão "delete-account-button" (name)
2. Inserir no prompt o password (UUID2)
3. Aceitar o prompt
4. Aceita o alert "User succefully deleted!", isto nos leva para a página de Login e deleta o usuário previamente cadastrado

<!-- Login Page (localhost:5432/login) -->
1. Inserir no input "username" (name) o UUID1 previamente salvo
2. Inserir no input "password" (name) o UUID2 previamente salvo
3. Clicar no botão "form-button" (className), esta ação deve falhar pois não há mais um usuário com estas credenciais cadastrado
4. Aceitar o alert "Login or Password invalid!"


## Fluxo dos testes

      +-----------------+
      | Página de Login |
      +-----------------+
               |
      para página de cadastro
               |
               v
      +--------------------+                  +----------------+                            +------------------+
      | Página de Cadastro |--testa cadastro->| Página Inicial |----para página de perfil-->| Página de Perfil |-----+
      +--------------------+                  +----------------+                            +------------------+     |
                                                                                                                     |
                                            +-------------------+                  +-----------------+               |
             +----envia e limpar mensagens--| Página de Inicial |<--efetuar login--| Página de Login |<----logout----+
             |                              +-------------------+                  +-----------------+
       para página de perfil
             |
             v
     +-------------------+                 +-----------------+                  +-----+
     | Página de Perfil  |--excluir conta->| Página de Login |--falhar login--->| FIM |
     +-------------------+                 +-----------------+                  +-----+
