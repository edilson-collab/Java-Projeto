package lpoo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TurmaServico {
	
	  public static void criarTurma(Scanner scanner, RepositorioAcademia repositorio) {
		  
		  String idTurma = GeradorMatricula.gerarIdTurma(repositorio);

		        try {

		            String horario = EntradaDados.lerHorario(scanner);

		            if (repositorio.getProfessores().isEmpty()) {
		                System.out.println("Nenhum professor cadastrado.");
		                return;
		            }

		            System.out.println("\n===== PROFESSORES DISPONÍVEIS =====");

		            for (int indice = 0; indice < repositorio.getProfessores().size(); indice++) {
		                System.out.println(
		                        indice + " - " +
		                        repositorio.getProfessores().get(indice).getNome()
		                );
		            }

		            System.out.print("Escolha o professor: ");
		            int indiceProfessor = scanner.nextInt();
		            scanner.nextLine();

		            if (indiceProfessor < 0 || indiceProfessor >= repositorio.getProfessores().size()) {
		                System.out.println("Professor inválido.");
		                return;
		            }

		            Professor professorEscolhido =
		                    repositorio.getProfessores().get(indiceProfessor);

		            Turma turma = new Turma(idTurma, horario, professorEscolhido);
		            

		            repositorio.getTurmas().add(turma);

		            System.out.println("Turma criada com sucesso.");
		            System.out.println(turma);

		        } catch (InputMismatchException erro) {
		            System.out.println("Entrada inválida.");
		            scanner.nextLine();
	        }
		        catch (IllegalArgumentException erro) {

		            System.out.println(erro.getMessage());
		        }
	}
	  public static void matricularAluno(
		        Scanner scanner,
		        RepositorioAcademia repositorio) {

		    if (repositorio.getAlunos().isEmpty()) {
		        System.out.println("Nenhum aluno cadastrado.");
		        return;
		    }

		    if (repositorio.getTurmas().isEmpty()) {
		        System.out.println("Nenhuma turma cadastrada.");
		        return;
		    }

		    System.out.println("\n===== ALUNOS =====");

		    for (int i = 0; i < repositorio.getAlunos().size(); i++) {

		        System.out.println(
		            i + " - " +
		            repositorio.getAlunos().get(i).getNome()
		        );
		    }

		    System.out.print("Escolha o aluno: ");
		    int indiceAluno = scanner.nextInt();
		    scanner.nextLine();

		    if (indiceAluno < 0 ||
		        indiceAluno >= repositorio.getAlunos().size()) {

		        System.out.println("Aluno inválido.");
		        return;
		    }

		    System.out.println("\n===== TURMAS =====");

		    for (int i = 0; i < repositorio.getTurmas().size(); i++) {

		        Turma turma = repositorio.getTurmas().get(i);

		        System.out.println(
		            i + " - Turma " +
		            turma.getIdTurma() +
		            " (" +
		            turma.getModalidade().getNome() +
		            ")"
		        );
		    }

		    System.out.print("Escolha a turma: ");
		    int indiceTurma = scanner.nextInt();
		    scanner.nextLine();

		    if (indiceTurma < 0 ||
		        indiceTurma >= repositorio.getTurmas().size()) {

		        System.out.println("Turma inválida.");
		        return;
		    }

		    Aluno aluno =
		        repositorio.getAlunos().get(indiceAluno);

		    Turma turma =
		        repositorio.getTurmas().get(indiceTurma);

		    turma.adicionarAluno(aluno);

		    System.out.println(
		        "Aluno matriculado com sucesso."
		    );
		}
	  
	  public static void listarTurmas(RepositorioAcademia repositorio) {

		    if (repositorio.getTurmas().isEmpty()) {

		        System.out.println("Nenhuma turma cadastrada.");
		        return;
		    }

		    System.out.println("\n===== TURMAS CADASTRADAS =====");

		    for (Turma turma : repositorio.getTurmas()) {

		        System.out.println(turma);
		        System.out.println("------------------------------");
		    }
		}
}
