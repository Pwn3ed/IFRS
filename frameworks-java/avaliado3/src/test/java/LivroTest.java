import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.time.LocalDate;

public class LivroTest {

	@Test
	@DisplayName("testa leitura positiva")
	public void testaLerPos() {
		Livro l = new Livro("Harry Potter 1", 300);
		l.ler(10);
		Assertions.assertEquals(10, l.getPaginasLidas());
	}

	@Test
	@DisplayName("testa leitura positiva de muitas paginas")
	public void testaLerPos2() {
		Livro l = new Livro("Harry Potter 1", 300);
		l.ler(350);
		Assertions.assertEquals(300, l.getPaginasLidas());
	}

	@Test
	@DisplayName("teste simples de sintaxe do mockito")
	public void testaMockito() {
		Livro livroFalso = mock(Livro.class);

		String titulo = "senhor dos aneis";
		livroFalso.setTitulo(titulo);
		System.out.println("chamada antes de simular get: " + livroFalso.getTitulo());

		// simulando a chamada de getTitulo()
		when(livroFalso.getTitulo()).thenReturn(titulo);

		System.out.println("chamada após simular get: " + livroFalso.getTitulo());

		// simulando a chamada de lerAndGetQuantidadePaginasFaltantes()
		when(livroFalso.lerAndGetQuantidadePaginasFaltantes(10)).thenReturn(100);

		System.out.println("chamada de leEGetPagsFaltam sem um parâmetro simulado:"
				+ livroFalso.lerAndGetQuantidadePaginasFaltantes(5));

		System.out.println("chamada de leEGetPagsFaltam com um parâmetro simulado:"
				+ livroFalso.lerAndGetQuantidadePaginasFaltantes(10));

		// verifica se o método getTitulo foi chamado duas vezes
		verify(livroFalso, times(2)).getTitulo();

	}

	@Test
	public void shouldCreateNewLivro() {
		String titulo = "Dev";
		int paginas = 300;

		Livro livro = new Livro(titulo, paginas);

		Assertions.assertEquals(livro.getTitulo(), titulo);
		Assertions.assertEquals(livro.getPaginas(), paginas);
	}

	public void shouldCreateNewLivroWithDataReserva() {
		int id = 1;
		String titulo = "Dev2";
		int paginas = 350;
		int pagsLidas = 0;
		Stats stats = Stats.RESERVADO;
		LocalDate localDate = LocalDate.of(2025, 4, 6);
		String email = "dev2@email.com";

		Livro livro = new Livro(id, titulo, paginas, pagsLidas, stats, localDate, email);

		Assertions.assertEquals(livro.getId(), 0);
		Assertions.assertEquals(livro.getTitulo(), titulo);
		Assertions.assertEquals(livro.getPaginas(), paginas);
		Assertions.assertEquals(livro.getPaginasLidas(), pagsLidas);
		Assertions.assertEquals(livro.getStats(), stats);
		Assertions.assertEquals(livro.getDataReserva(), localDate);
		Assertions.assertEquals(livro.getEmail(), email);
	}

	@Test
	public void shouldReservarLivro() {
		String titulo = "Dev";
		int paginas = 300;
		String email = "dev@email.com";

		Livro livro = new Livro(titulo, paginas);
		livro.reservar(email);

		Assertions.assertEquals(livro.getTitulo(), titulo);
		Assertions.assertEquals(livro.getPaginas(), paginas);
		Assertions.assertEquals(livro.getStats(), Stats.RESERVADO);
		Assertions.assertEquals(livro.getEmail(), email);
		Assertions.assertEquals(livro.getDataReserva(), LocalDate.now());
	}

	@Test
	public void shouldLocarLivro() {
		String titulo = "Dev";
		int paginas = 300;
		String email = "dev@email.com";

		Livro livro = new Livro(titulo, paginas);
		livro.locar(email);

		Assertions.assertEquals(livro.getTitulo(), titulo);
		Assertions.assertEquals(livro.getPaginas(), paginas);
		Assertions.assertEquals(livro.getStats(), Stats.LOCADO);
		Assertions.assertEquals(livro.getEmail(), email);
		Assertions.assertEquals(livro.getDataReserva(), LocalDate.now());
	}

	@Test
	public void shouldDevolverLivro() {
		String titulo = "Dev";
		int paginas = 300;
		String email = "dev@email.com";

		Livro livro = new Livro(titulo, paginas);
		livro.devolver();

		Assertions.assertEquals(livro.getTitulo(), titulo);
		Assertions.assertEquals(livro.getPaginas(), paginas);
		Assertions.assertEquals(livro.getStats(), Stats.DISPONIVEL);
		Assertions.assertEquals(livro.getEmail(), null);
		Assertions.assertEquals(livro.getDataReserva(), null);
	}

	@Test
	public void shouldCancelarReserva() {
		String titulo = "Dev";
		int paginas = 300;
		String email = "dev@email.com";

		Livro livro = new Livro(titulo, paginas);
		livro.reservar(email);

		livro.cancelaReserva();

		Assertions.assertEquals(livro.getTitulo(), titulo);
		Assertions.assertEquals(livro.getPaginas(), paginas);
		Assertions.assertEquals(livro.getStats(), Stats.DISPONIVEL);
		Assertions.assertEquals(livro.getEmail(), null);
		Assertions.assertEquals(livro.getDataReserva(), null);
	}

}
