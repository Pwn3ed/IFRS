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

# JPA - Java Persistence API (2006) && Hibernate
- Entity
- JPQL (linguagem do JPA para SQL)
- Persistence.xml

# Persistence
- Criar arquivo "persistence.xml" local pasta "META-INF" dentro do classpath do projeto.
- Este arquivo será a Unidade de Persistência, com todas informações do banco.

* Dados de conexão:
* - URL
* - Usuário
* - Senha
* - Driver

Criação automática:
- Create
- Update
- Validate

* hibernate.show_sql
* hibernate.format_sql

# Entity (modelo associado a uma tabela)
- Nova forma utilizando annotation ao invés do arquivo "persistance.xml"
- Classe em tabela
- Atributos em colunas
- Definições de restrições de integridade
- @id: define chave primária
- @Transient: salvo em memória, não salva no banco

Exemplo:
@Entity
public class empregado {
    @Id
    private String cpf;
    private String nome;
    private LocalDate datanascimento;
}

@Table(name="<valor>")
@Column
@GeneratedValue

Exemplo:
@Entity
@Table(name="\"funcionario\"")
public class empregado {
    @Id
    @GeneratedValue
    private int id;

    @Column(name="nome_emp", nullable=true, unique=true, length=150)
    private String nome;
    private LocalDate datanascimento;
}

# Conexão com o banco
- EntityManagerFactory
- EntityManager (pode executar queries)

## Métodos
- persist: INSERT
- find: SELECT
- merge: UPDATE ou INSERT, se o objeto já existe ele faz UPDATE, se não, INSERT
- remove: DELETE
- createNativeQuery(): SQL nativo (menos recomendável)
- createQuery(): JPQL (mais recomendável)

## Controle de Transação
- getTransaction().begin() [COMEÇAR CADA COMANDO]
- getTransaction().commit() [FINALIZAR CADA COMANDOG]

# Estado do Objeto (entity) JPA
- New
- Managed
- Detached
- Removed

# Relacionamentos 
- OneToOne
- OneToMany
- ManyToOne
- ManyToMany


# Prova (04/06/25)
- Testes (unitário, integração, sistema)

## Cola de papel:
- Folha A4 (frente e verso), escrita a mão

## Código:
- Testes Unitários -> JUnit (annotations, assertivas ...)
- Mocking (mockito)

## Teórico:
- TDD
- Teste de Integração
- Teste de Sistema

