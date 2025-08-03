

Ator -> Caso de uso

- Sistema:
    - Gerenciar planos
    - Gerenciar matriculas
    - Notificar vencimento

- Administrador:
    - Cadastrar plano
    - Cadastrar instrutor
    - Cadastrar aluno
    - Gerar matricula

- Instrutor:
    - Montar treino
    - Atualizar treino
    - Visualizar alunos

- Aluno:
    - Visualizar treinos
    - Visualizar plano


                           
     ┌─────┐                                                     ┌─────────┐
     │Aluno│   ◄──┐                                              │Instrutor│
     └─────┘      │                                              └─────────┘
                  │      Cadastrar plano de mensalidade  
                  │
                  │
                  ├────────────── Matricula
                  │                   ▲
                  │                   │
                  │                   │
                  │                 Plano
                  │
                  │
                  │
                  │
                  └──────────────── Treino




