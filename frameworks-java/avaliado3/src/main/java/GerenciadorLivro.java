import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class GerenciadorLivro {
	private LivroDao lDao;

	public GerenciadorLivro(LivroDao ldao) {
		this.lDao = ldao;
	}

	public void cancelarReservas() {
		List<Livro> reservados = lDao.listarReservados();

		for (Livro livro : reservados) {
			Period period = Period.between(livro.getDataReserva(), LocalDate.now());
			if (period.getDays() > 7) {
				livro.cancelaReserva();
				lDao.alterar(livro);
			}
		}

	}

	public boolean locar(int id, String email) {
		Livro livro = lDao.get(id);

		try {
			livro.locar(email);
			lDao.alterar(livro);
		} catch (IllegalArgumentException e) {
			throw e;
		}

		return true;
	}

	public boolean devolver(int id) {
		Livro livro = lDao.get(id);

		try {
			livro.devolver();
		} catch (IllegalArgumentException e) {
			throw e;
		}
		lDao.alterar(livro);

		return true;
	}

	public boolean reservar(int id, String email) {
		Livro livro = lDao.get(id);

		try {
			livro.reservar(email);
			lDao.alterar(livro);
		} catch (IllegalArgumentException e) {
			throw e;
		}

		return true;
	}

	public void avisarReservaNoFinal(EmailService service) {
		List<Livro> reservados = lDao.listarReservados();

		for (Livro livro : reservados) {
			Period period = Period.between(livro.getDataReserva(), LocalDate.now());
			int days = period.getDays();

			if (days >= 5 && days <= 7) {
				service.enviaEmail(
						"Seu periodo de reserva do livro está acabando, fique atento ao prazo!",
						"Reserva no final", livro.getEmail());
			}
		}
	}

	public void avisarLocacaoFinal(EmailService service) {
		List<Livro> locados = lDao.listarReservados();

		for (Livro livro : locados) {
			Period period = Period.between(livro.getDataReserva(), LocalDate.now());
			int days = period.getDays();

			if (days >= 12 && days <= 14) {
				service.enviaEmail("Seu livro está prestes a expirar, fique atento ao prazo.",
						"Locação prestes a expirar", livro.getEmail());
			} else if (days > 14) {
				service.enviaEmail(
						"Seu livro expirou! Por favor, realize uma nova locação ou devolva o livro para a loja, obrigado.",
						"Locação expirada", livro.getEmail());
			}
		}
	}

}
