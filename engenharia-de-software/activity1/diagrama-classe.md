# Diagrama de classe

 https://app.diagrams.net/#LUntitled%20Diagram.drawio#%7B%22pageId%22%3A%22PuDE8fyEbCvzkWqKJKRD%22%7D

```txt
┌─────┐                                              
│aluno│                                      
├─────┴───────────────────────┐                      
│- cpf: String                │
│- nome: String               │                           
│- telefone: String           │                           
│- endereco: String           │                           
│- peso: Double               │
│- altura: Double             │                           
│- observacoes: String        │
├─────────────────────────────┤                           
│+ visualizarTreinos(): void  │                           
│                             │
└─────────────────────────────┘


┌─────┐                           
│plano│          
├─────┴───────────────────────────┐
│- id: Integer                    │
│- tipos: tipo_pagamento          │
│- valor: Float                   │      
│- horarios: String               │
├─────────────────────────────────┤
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

┌─────────┐
│matricula│        
├─────────┴─────────────────────┐
│- data_inicial                 │
│- vencimento_plano             │
│- valor_matricula              │       
│- forma_pagamento              │       
│- instrutor_resposavel         │       
├───────────────────────────────┤
│- forma_pagamento: String()    │
│                               │
│                               │
│                               │
│                               │
│                               │
└───────────────────────────────┘
 
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


                   

```





