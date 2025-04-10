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


