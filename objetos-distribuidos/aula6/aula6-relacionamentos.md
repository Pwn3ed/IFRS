# Relacionamentos

## Tipos

- 1:1 - OneToOne
- 1:N - OneToMany
- N:N - ManyToMany

# Practice Example

Classes: Cliente, Endereço.

Cliente possui um Endereço.

Na classe cliente foi criado uma variável privada: private Endereco endereco;

## Anotations:

#Entity
Public class Cliente {
	@OneToOne(cascade = CascadeType.ALL);
	private Endereco endereco;
}

#Id
Public class Endereco {}


