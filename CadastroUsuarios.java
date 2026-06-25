package lpoo;

import java.util.Scanner;
import java.util.InputMismatchException;

public class CadastroUsuarios {

    public static void cadastrarAluno( Scanner scanner, RepositorioAcademia repositorio) {    	 
    	
        try {
            String matricula = GeradorMatricula.gerarMatricula("AL", repositorio.getAlunos(), repositorio.getProfessores(), repositorio.getRecepcionistas());

            System.out.println("Matrícula gerada: " + matricula);

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Peso: ");
            double peso = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Nascimento: ");
            String nascimento = scanner.nextLine();

            System.out.print("Graduação: ");
            String graduacao = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            if (!Validador.validarCpf(cpf)) {
                throw new IllegalArgumentException("CPF inválido.");
            }

            if (Validador.cpfJaExiste(cpf, repositorio.getAlunos(), repositorio.getProfessores(), repositorio.getRecepcionistas())) {
                throw new IllegalArgumentException("CPF já cadastrado.");
            }

            repositorio.getAlunos().add(new Aluno(matricula, nome, peso, email, nascimento, graduacao, cpf));

            System.out.println("Aluno cadastrado com sucesso.");

        } catch (InputMismatchException erro) {
            System.out.println("Erro de entrada.");
            scanner.nextLine();
        }
        catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public static void cadastrarProfessor( Scanner scanner,
    		 RepositorioAcademia repositorio) {
    	
        try {
            String matricula = GeradorMatricula.gerarMatricula("PR", repositorio.getAlunos(), repositorio.getProfessores(), repositorio.getRecepcionistas());

            System.out.println("Matrícula gerada: " + matricula);

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Agência: ");
            String agencia = scanner.nextLine();

            System.out.print("Conta: ");
            String conta = scanner.nextLine();

            System.out.print("Experiência: ");
            int experiencia = scanner.nextInt();
            scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            if (!Validador.validarCpf(cpf)) {
                throw new IllegalArgumentException("CPF inválido.");
            }

            if (Validador.cpfJaExiste(cpf, repositorio.getAlunos(), repositorio.getProfessores(), repositorio.getRecepcionistas())) {
                throw new IllegalArgumentException("CPF já cadastrado.");
            }

            System.out.print("Nascimento: ");
            String nascimento = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Graduação: ");
            String graduacao = scanner.nextLine();

            System.out.print("Especialidade: ");
            String especialidade = scanner.nextLine();

            System.out.print("Carga horária: ");
            int cargaHoraria = scanner.nextInt();
            scanner.nextLine();

            repositorio.getProfessores().add(new Professor(matricula, nome, agencia, conta, experiencia, cpf, nascimento, email, graduacao, especialidade, cargaHoraria));

            System.out.println("Professor cadastrado com sucesso.");

        } catch (InputMismatchException erro) {
            System.out.println("Erro de entrada.");
            scanner.nextLine();
        }
        catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public static void cadastrarRecepcionista( Scanner scanner,
    		RepositorioAcademia repositorio) {

        try {
            String matricula = GeradorMatricula.gerarMatricula("RE", repositorio.getAlunos(), repositorio.getProfessores(), repositorio.getRecepcionistas());

            System.out.println("Matrícula gerada: " + matricula);

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Agência: ");
            String agencia = scanner.nextLine();

            System.out.print("Conta: ");
            String conta = scanner.nextLine();

            System.out.print("Experiência: ");
            int experiencia = scanner.nextInt();
            scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            if (!Validador.validarCpf(cpf)) {
                throw new IllegalArgumentException("CPF inválido.");
            }

            if (Validador.cpfJaExiste(cpf, repositorio.getAlunos(), repositorio.getProfessores(), repositorio.getRecepcionistas())) {
                throw new IllegalArgumentException("CPF já cadastrado.");
            }

            System.out.print("Nascimento: ");
            String nascimento = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Turno: ");
            String turno = scanner.nextLine();

            repositorio.getRecepcionistas().add(new Recepcionista(matricula, nome, agencia, conta, experiencia, cpf, nascimento, email, turno));

            System.out.println("Recepcionista cadastrada com sucesso.");

        } catch (InputMismatchException erro) {
            System.out.println("Erro de entrada.");
            scanner.nextLine();
        }
        catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }
    
    public static void excluirAluno(
            Scanner scanner,
            RepositorioAcademia repositorio) {

        System.out.print("CPF do aluno: ");
        String cpf = scanner.nextLine();

        Aluno aluno = (Aluno) Login.buscarPorCpf(
                cpf,
                repositorio.getAlunos());

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
        if (aluno.getTurma() != null) {

            System.out.println(
                "Aluno está matriculado em uma turma."
            );

            return;
        }

        repositorio.getAlunos().remove(aluno);

        System.out.println("Aluno removido com sucesso.");
    }
    
    public static void excluirProfessor(
            Scanner scanner,
            RepositorioAcademia repositorio) {

        System.out.print("CPF do professor: ");
        String cpf = scanner.nextLine();

        Professor professor = (Professor) Login.buscarPorCpf(
                cpf,
                repositorio.getProfessores());

        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return;
        }
        if (!professor.getTurmas().isEmpty()) {

            System.out.println(
                "Professor possui turmas vinculadas."
            );

            return;
        }

        repositorio.getProfessores().remove(professor);

        System.out.println("Professor removido com sucesso.");
    }
    
    public static void excluirRecepcionista(
            Scanner scanner,
            RepositorioAcademia repositorio) {

        System.out.print("CPF da recepcionista: ");
        String cpf = scanner.nextLine();

        Recepcionista recepcionista =
                (Recepcionista) Login.buscarPorCpf(
                        cpf,
                        repositorio.getRecepcionistas());

        if (recepcionista == null) {
            System.out.println("Recepcionista não encontrada.");
            return;
        }
        if (repositorio.getRecepcionistas().size() == 1) {

            System.out.println(
                "O sistema precisa de pelo menos uma recepcionista."
            );

            return;
        }

        repositorio.getRecepcionistas().remove(recepcionista);

        System.out.println(
                "Recepcionista removida com sucesso."
        );
    }

}
