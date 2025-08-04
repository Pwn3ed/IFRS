# Diagrama de classe



┌─────┐                                              
│aluno│                                      
├─────┴───────────────────────┐                      
│- cpf: String                │
│- nome: String               │                           
│- telefone: String           │                           
│- endereco: String           │                           
│- altura: double             │                           
│- observacoes: String        │
├─────────────────────────────┤                           
│- visualizarTreinos(): void  │                           
│                             │                           
│                             │       
│                             │
│                             │
│                             │
│                             │
└─────────────────────────────┘

 
 ┌──────┐                                      
 │treino│                          
 ├──────┴───────────────────┐      
 │- data_inicio: Date       │
 │- data_fim: Date          │
 │- data_montado: Date      │
 │- montado_por: String     │                  
 │- aluno: String           │
 │- exercicios: String      │
 │- series: int             │
 │- repeticoes: int         │
 ├──────────────────────────┤
 │                          │
 │                          │
 │                          │
 │                          │
 │                          │
 │                          │
 │                          │
 └──────────────────────────┘
                 
                 
 ┌─────────┐     
 │instrutor│
 ├─────────┴─────────────────┐
 │- nome                     │
 │- email                    │
 │- celular                  │
 ├───────────────────────────┤
 │                           │
 │                           │
 │                           │
 │                           │
 │                           │
 │                           │
 │                           │
 │                           │
 └───────────────────────────┘





┌─────────┐
│matricula│        
├─────────┴─────────────────────┐
│- data_inicial                 │
│- vencimento_plano             │
│- valor_matricula              │       
│- forma_pagamento              │       
│- instrutor_resposavel         │       
├───────────────────────────────┤
│                               │
│                               │
│                               │
│                               │
│                               │
│                               │
└───────────────────────────────┘
                   


┌─────┐                           
│plano│          
├─────┴───────────────────────────┐
│- tipos: tipo_pagamento          │
│- tempo_validade                 │
│- valor                          │
│- horarios                       │
├─────────────────────────────────┤
│                                 │
│                                 │
│                                 │
│                                 │
│                                 │
│                                 │
└─────────────────────────────────┘

┌────────────────┐
│<<enumeration>> │
│tipo_pagamento  │
├────────────────┤
│mensal          │
│semestral       │
│anual           │
└────────────────┘







