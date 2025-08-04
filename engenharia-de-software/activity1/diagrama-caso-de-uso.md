# Diagrama de caso de uso:

https://app.diagrams.net/?src=about#LUntitled%20Diagram.drawio#%7B%22pageId%22%3A%22m8m2iFlxCTWb-2zP2oj0%22%7D

┌───────┐                                   ┌───────────────┐
│ Aluno │                                   │ Administrador │
├───────┴────────────┐                      ├───────────────┴─────┐
│ Visualizar treinos │                      │ Cadastrar plano     │
│ Visualizar plano   │                      │ Cadastrar instrutor │
└────────────────────┘                      │ Cadastrar aluno     │
                                            │ Gerar matricula     │
                                            └─────────────────────┘



┌───────────┐                               ┌─────────┐
│ Instrutor │                               │ Sistema │
├───────────┴───────┐                       ├─────────┴────────────┐
│ Montar treino     │                       │ Gerenciar planos     │
│ Atualizar treino  │                       │ Gerenciar matriculas │
│ Visualizar alunos │                       │ Notificar vencimento │
└───────────────────┘                       └──────────────────────┘

