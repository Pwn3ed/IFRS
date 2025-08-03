# Diagrama de caso de uso:

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

