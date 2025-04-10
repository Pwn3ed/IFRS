import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class GerenciadorLivroTest {
	private GerenciadorLivro gerenciadorLivro;
	private LivroDao lDaoMock;
	private ArrayList<Livro> reservados;
	private ArrayList<Livro> locados;

	public void start() {
		this.lDaoMock = mock(LivroDao.class);
		this.reservados = new ArrayList<>();
		this.locados = new ArrayList<>();

		this.reservados.add(new Livro(1, "Dev1", 300, 0, Stats.RESERVADO, LocalDate.now().minusDays(3),
				"dev1@email.com"));
		this.reservados.add(new Livro(2, "Dev2", 250, 0, Stats.RESERVADO, LocalDate.now().minusDays(6),
				"dev2@email.com"));
		this.reservados.add(new Livro(3, "Dev3", 250, 0, Stats.RESERVADO, LocalDate.now().minusDays(8),
				"dev3@email.com"));				
		this.locados.add(new Livro(4, "Dev4", 200, 0, Stats.LOCADO, LocalDate.now().minusDays(12),
				"dev4@email.com"));
		this.locados.add(new Livro(5, "Dev5", 150, 0, Stats.LOCADO, LocalDate.now().minusDays(18),
				"dev5@email.com"));

		this.gerenciadorLivro = new GerenciadorLivro(this.lDaoMock);
	}

	@Test
	public void shouldCancelarLivros() {
		start();
		when(this.lDaoMock.listarReservados()).thenReturn(this.reservados);
		Livro livro = this.reservados.get(2);

		this.gerenciadorLivro.cancelarReservas();

		verify(lDaoMock).listarReservados();
		verify(lDaoMock).alterar(livro);
	}

	@Test
	public void shouldLocarLivro() {
		start();
		Livro livro = new Livro(0, "Dev", 300, 0, Stats.DISPONIVEL, null, null);
		when(this.lDaoMock.get(0)).thenReturn(livro);

		this.gerenciadorLivro.locar(0, "dev@email.com");
		verify(this.lDaoMock).alterar(livro);
	}

	@Test
	public void shouldReservarLivro() {
		start();
		Livro livro = new Livro(0, "Dev", 300, 0, Stats.DISPONIVEL, null, null);
		when(this.lDaoMock.get(0)).thenReturn(livro);

		this.gerenciadorLivro.reservar(0, "dev@email.com");
		verify(this.lDaoMock).alterar(livro);
	}

	@Test
	public void shouldDevolverLivro() {
		start();
		when(this.lDaoMock.get(0)).thenReturn(this.locados.get(0));

		this.gerenciadorLivro.devolver(0);
		verify(this.lDaoMock).alterar(this.locados.get(0));
	}

	@Test
	public void shouldAvisarReservaNoFinal() {
		start();
		EmailService serviceMock = mock(EmailService.class);

		when(this.lDaoMock.listarReservados()).thenReturn(this.reservados);

		this.gerenciadorLivro.avisarReservaNoFinal(serviceMock);

		verify(this.lDaoMock).listarReservados();
		verify(serviceMock).enviaEmail("Seu periodo de reserva do livro está acabando, fique atento ao prazo!",
				"Reserva no final", this.reservados.get(1).getEmail());

	}

	@Test
	public void shouldAvisarLocacoesNoFinal() {
		start();
		EmailService serviceMock = mock(EmailService.class);

		when(this.lDaoMock.listarLocados()).thenReturn(this.locados);

		this.gerenciadorLivro.avisarLocacaoFinal(serviceMock);

		verify(this.lDaoMock).listarLocados();
		verify(serviceMock).enviaEmail("Seu livro está prestes a expirar, fique atento ao prazo.",
				"Locação prestes a expirar", this.locados.get(0).getEmail());
		verify(serviceMock).enviaEmail(
				"Seu livro expirou! Por favor, realize uma nova locação ou devolva o livro para a loja, obrigado.",
				"Locação expirada", this.locados.get(1).getEmail());
	}
}
