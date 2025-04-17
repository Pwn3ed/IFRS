# Frameworks Java

# Junit

# Mock

# 09/04

- Teste de Unidade: Isolar partes com mock (framework junit).

- Teste de Integração: Testar integrações entre classes (framework junit).
Exemplo:
Testar DAO e sua integração com o banco.

- Teste de Sistema: Caso de Uso completo. (teste de interface).

## Como criar testes

Fazer um conjunto de operações e depois voltar.

Criar rotinas antes de cada teste:
- Connection .setAutoCommit(false) //para poder fazer rollback depois

Criar rotinas depois de cada teste:
- fechar recursos
- fazer rollback (controle transacional)
- Connection .setAutoCommit(true) //para sempre salvar as alterações no banco

## Teste de Sistema

- Caixa preta: testa sem analisar o que tem dentro.
- Caixa branca: testa analisando o que tem dentro do código.

- Site: testa como as páginas se comunicam.

Selenium: framework utilizando para automatizar navegadores.

# Apresentação

- PDF explicando como funciona os testes, quais serão as entradas, quais serão os testes, e quais serão as saídas.

Entradas: clicar em um botão pode ser uma entrada.

- em média 5 minutos de apresentação.

