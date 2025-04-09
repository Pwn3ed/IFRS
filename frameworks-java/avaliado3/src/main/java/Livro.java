import java.time.LocalDate;

public class Livro {
	private int id;
	private String titulo;
	private int paginasLidas;
	private int paginas;
	private Stats stats;
	private LocalDate dataReserva;
	private String email;

	public Livro(int id, String titulo, int paginas, int pagsLidas, Stats stats, LocalDate dataReserva, String email) {
		this.id = id;
		this.titulo = titulo;
		this.paginas = paginas;
		this.paginasLidas = pagsLidas;
		this.stats = stats;
		this.dataReserva = dataReserva;
		this.email = email;
	}

	public Livro(String titulo, int paginas) {
		this.paginas = paginas;
		this.titulo = titulo;
		this.stats = Stats.DISPONIVEL;
		this.dataReserva = null;
		this.paginasLidas = 0;
	}

	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public void ler(int pags) {
		if (this.paginasLidas + pags < this.paginas) {
			this.paginasLidas = +pags;
		} else {
			this.paginasLidas = this.paginas;
		}

	}

	public int lerAndGetQuantidadePaginasFaltantes(int pgs) {
		this.ler(pgs);
		return this.paginas - this.paginasLidas;
	}
	
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPaginasLidas() {
		return this.paginasLidas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Stats getStats() {
		return this.stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void reservar(String email) {
		if (this.stats != Stats.DISPONIVEL) {
			throw new IllegalArgumentException("Error. Livro não está disponível.");
		}
		this.setStats(Stats.RESERVADO);
		this.setEmail(email);
		this.setDataReserva(LocalDate.now());
	}

	public void cancelaReserva() {
		if (this.stats == Stats.RESERVADO) {
			this.dataReserva = null;
			this.stats = Stats.DISPONIVEL;
			this.email = null;
		}
		else {
			throw new IllegalArgumentException("Error. Livro já está reservado.");
		}
	}

	public void locar(String email) {
		if (this.stats == Stats.LOCADO) {
			throw new IllegalArgumentException("Error. Livro já está locado.");
		}
		if (this.stats == Stats.RESERVADO && !this.getEmail().equals(email)) {
			throw new IllegalArgumentException("Error. Livro está reservado para outro email.");
		}
		this.setStats(Stats.LOCADO);
		this.setEmail(email);
		this.setDataReserva(LocalDate.now());
	}

	public void devolver() {
		this.setStats(Stats.DISPONIVEL);
		this.setEmail(null);
		this.setDataReserva(null);
	}
	
}
