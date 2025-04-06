import java.util.List;

public class GerenciadorLivro {
	private LivroDao lDao;
	public GerenciadorLivro(LivroDao ldao) {
		this.lDao = ldao;
	}
	public void cancelarReservas() {
		//implementação feita só para passar no teste... implementar solucao completa
		
		//buscar livros reservados 
		List<Livro> reservados = lDao.listarReservados();
		//percorre e verificar se a reserva é maior que 7 dias ou nao.
		//caso seja deve cancelarReserva
		lDao.alterar(reservados.get(0));
		//persistir no bd o livro alterado 
	}
}
