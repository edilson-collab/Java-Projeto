package lpoo;

public class RelatorioServico {
	public static void exibirResumo(
	        RepositorioAcademia repositorio) {
		if (repositorio.getAlunos().isEmpty()
		        && repositorio.getProfessores().isEmpty()
		        && repositorio.getRecepcionistas().isEmpty()
		        && repositorio.getTurmas().isEmpty()) {

		    System.out.println("Nenhum relatório disponível.");
		    return;
		}

	    System.out.println("\n===== RESUMO GERAL =====");

	    System.out.println(
	            "Alunos: "
	            + repositorio.getAlunos().size());

	    System.out.println(
	            "Professores: "
	            + repositorio.getProfessores().size());

	    System.out.println(
	            "Recepcionistas: "
	            + repositorio.getRecepcionistas().size());

	    System.out.println(
	            "Turmas: "
	            + repositorio.getTurmas().size());
	}
	public static void listarAlunosPorTurma(
	        RepositorioAcademia repositorio) {

	    if (repositorio.getTurmas().isEmpty()) {

	        System.out.println(
	                "Nenhuma turma cadastrada."
	        );

	        return;
	    }

	    System.out.println(
	            "\n===== ALUNOS POR TURMA ====="
	    );

	    for (Turma turma : repositorio.getTurmas()) {

	        System.out.println(
	                "\nTurma: "
	                + turma.getIdTurma()
	        );

	        System.out.println(
	                "Professor: "
	                + turma.getProfessor().getNome()
	        );

	        System.out.println(
	                turma.listarAlunos()
	        );
	    }
	}
	public static void listarProfessoresETurmas(
	        RepositorioAcademia repositorio) {

	    if (repositorio.getProfessores().isEmpty()) {

	        System.out.println(
	                "Nenhum professor cadastrado."
	        );

	        return;
	    }

	    System.out.println(
	            "\n===== PROFESSORES E TURMAS ====="
	    );

	    for (Professor professor :
	            repositorio.getProfessores()) {

	        System.out.println(
	                "\nProfessor: "
	                + professor.getNome()
	        );

	        System.out.println(
	                professor.listarTurmas()
	        );
	    }
	}
}
