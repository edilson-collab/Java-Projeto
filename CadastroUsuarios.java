package lpoo;

import java.util.Scanner;
import java.util.InputMismatchException;

public class CadastroUsuarios {

    public static void cadastrarAluno( Scanner scanner, RepositorioAcademia repositorio) {  
    	 
        try {
            String matricula = GeradorMatricula.gerarMatricula("AL", repositorio.getAlunos(), repositorio.getProfessores(), repositorio.getRecepcionistas());

            System.out.println("Matrícula gerada: " + matricula);

            String nome = EntradaDados.lerNome(scanner);

            double peso = EntradaDados.lerPeso(scanner);

            String email = EntradaDados.lerEmail(scanner);

            String nascimento = EntradaDados.lerDataNascimento(scanner);

            String graduacao = EntradaDados.lerGraduacao(scanner);

            String cpf = EntradaDados.lerCpf(scanner, repositorio);

            repositorio.getAlunos().add(new Aluno(matricula, nome, peso, email, nascimento, graduacao, cpf));

            System.out.println("Aluno cadastrado com sucesso.");
            System.out.println("Senha padrão inicial, CPF.");

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

            String nome = EntradaDados.lerNome(scanner);
            
            String agencia = EntradaDados.lerAgencia(scanner);
            
            String conta = EntradaDados.lerConta(scanner);
          
            int experiencia = EntradaDados.lerExperiencia(scanner);

            String cpf = EntradaDados.lerCpf(scanner, repositorio);
            
            String nascimento = EntradaDados.lerDataNascimento(scanner);

            String email = EntradaDados.lerEmail(scanner);

            String graduacao = EntradaDados.lerGraduacao(scanner);
           
            Modalidade modalidade = EntradaDados.lerModalidade(scanner);
            
            int cargaHoraria = EntradaDados.lerCargaHoraria(scanner);

            repositorio.getProfessores().add(new Professor(matricula, nome, agencia, conta, experiencia, cpf, nascimento, email, graduacao, modalidade, cargaHoraria));

            System.out.println("Professor cadastrado com sucesso.");
            System.out.println("Senha padrão inicial, CPF.");

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

            String nome = EntradaDados.lerNome(scanner);
            
            String agencia = EntradaDados.lerAgencia(scanner);

            String conta = EntradaDados.lerConta(scanner);

            String nascimento = EntradaDados.lerDataNascimento(scanner);
            
            int experiencia = EntradaDados.lerExperiencia(scanner);

            String cpf = EntradaDados.lerCpf(scanner, repositorio);

            String email = EntradaDados.lerEmail(scanner);

            String turno = EntradaDados.lerTurno(scanner);

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
