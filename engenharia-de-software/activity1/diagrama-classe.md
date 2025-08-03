# Diagrama de classe

┌─────┐                                         ┌─────┐                                             ┌─────────┐
│aluno├──┬───► cpf                              │plano├──┬───► mensal                               │matricula│──┬───► data_inicial
└─────┘  │                                      └─────┘  │                                          └─────────┘  │
         ├───► nome                                      ├───► semestral                                         ├───► vencimento_plano
         │                                               │                                                       │
         ├───► telefone                                  ├───► anual                                             ├───► valor_matricula
         │                                               │                                                       │
         ├───► endereco                                  ├───► tempo_validade                                    ├───► forma_pagamento
         │                                               │                                                       │
         ├───► peso                                      ├───► valor                                             └───► instrutor_resposavel
         │                                               │
         ├───► altura                                    └───► horarios
         │
         └───► observacoes


 ┌──────┐                                       ┌─────────┐
 │treino│──┬───► data_inicio                    │instrutor│──┬───► nome
 └──────┘  │                                    └─────────┘  │
           ├───► data_fim                                    ├───► email
           │                                                 │
           ├───► data_montado                                └───► celular
           │
           ├───► montado_por
           │
           ├───► aluno
           │
           ├───► exercicios
           │
           ├───► series
           │
           └───► repeticoes
