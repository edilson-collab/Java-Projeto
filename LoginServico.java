package lpoo;

import java.util.Scanner;

public class LoginServico {

    public static Recepcionista loginRecepcionista(Scanner scanner,  RepositorioAcademia repositorio) {

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        Recepcionista recepcionista = (Recepcionista) Login.buscarPorCpf(cpf, repositorio.getRecepcionistas());

        if (recepcionista == null) {
            System.out.println(
                    "Cadastro não encontrado."
            );
            return null;
        }

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        recepcionista = (Recepcionista) Login.autenticar(cpf, senha,  repositorio.getRecepcionistas());

        if (recepcionista == null) {
            System.out.println("Senha incorreta.");
            return null;
        }

        if (recepcionista.isPrimeiroAcesso()) {
            trocarSenhaRecepcionista(scanner, recepcionista);
        }

        return recepcionista;
    }

    public static Professor loginProfessor(Scanner scanner,  RepositorioAcademia repositorio) {

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        Professor professor = (Professor) Login.buscarPorCpf(cpf, repositorio.getProfessores());

        if (professor == null) {
            System.out.println(
                    "Cadastro não existe. Dirija-se à recepcionista."
            );
            return null;
        }

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        professor = (Professor) Login.autenticar(cpf, senha, repositorio.getProfessores());

        if (professor == null) {
            System.out.println("Senha incorreta.");
            return null;
        }

        if (professor.isPrimeiroAcesso()) {
            trocarSenhaProfessor(scanner,professor);
        }

        return professor;
    }

    public static Aluno loginAluno(Scanner scanner, RepositorioAcademia repositorio) {

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        Aluno aluno = (Aluno) Login.buscarPorCpf(cpf, repositorio.getAlunos());

        if (aluno == null) {
            System.out.println(
                    "Cadastro não existe. Dirija-se à recepcionista."
            );
            return null;
        }

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        aluno =
        	    (Aluno) Login.autenticar(cpf, senha, repositorio.getAlunos());

        if (aluno == null) {
            System.out.println("Senha incorreta.");
            return null;
        }

        if (aluno.isPrimeiroAcesso()) {
            trocarSenhaAluno(scanner, aluno);
        }

        return aluno;
    }

    public static void trocarSenhaAluno(Scanner scanner, Aluno aluno) {
    	String novaSenha;

    	do {
    	    System.out.print("Digite a nova senha: ");
    	    novaSenha = scanner.nextLine();

    	    if (novaSenha.isBlank()) {
    	        System.out.println("Senha não pode ficar vazia.");
    	    }

    	} while (novaSenha.isBlank());

    	aluno.setSenha(novaSenha);
        aluno.setPrimeiroAcesso(false);
    }

    public static void trocarSenhaProfessor(Scanner scanner, Professor professor) {
    	String novaSenha;

    	do {
    	    System.out.print("Digite a nova senha: ");
    	    novaSenha = scanner.nextLine();

    	    if (novaSenha.isBlank()) {
    	        System.out.println("Senha não pode ficar vazia.");
    	    }

    	} while (novaSenha.isBlank());

    	professor.setSenha(novaSenha);
        professor.setPrimeiroAcesso(false);
    }

    public static void trocarSenhaRecepcionista(Scanner scanner, Recepcionista recepcionista) {
    	String novaSenha;

    	do {
    	    System.out.print("Digite a nova senha: ");
    	    novaSenha = scanner.nextLine();

    	    if (novaSenha.isBlank()) {
    	        System.out.println("Senha não pode ficar vazia.");
    	    }

    	} while (novaSenha.isBlank());

    	recepcionista.setSenha(novaSenha);
        recepcionista.setPrimeiroAcesso(false);
    }
    public static void redefinirSenha(
            Scanner scanner,
            RepositorioAcademia repositorio) {

        System.out.print("CPF do usuário: ");
        String cpf = scanner.nextLine();

        Pessoa usuario = null;

        usuario = (Pessoa) Login.buscarPorCpf(
                cpf,
                repositorio.getAlunos());

        if (usuario == null) {
            usuario = (Pessoa) Login.buscarPorCpf(
                    cpf,
                    repositorio.getProfessores());
        }

        if (usuario == null) {
            usuario = (Pessoa) Login.buscarPorCpf(
                    cpf,
                    repositorio.getRecepcionistas());
        }

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        String novaSenha;

        do {

            System.out.print("Nova senha: ");
            novaSenha = scanner.nextLine();

            if (novaSenha.isBlank()) {
                System.out.println("Senha não pode ficar vazia.");
            }

        } while (novaSenha.isBlank());

        usuario.setSenha(novaSenha);
        usuario.setPrimeiroAcesso(false);

        System.out.println("Senha redefinida com sucesso." + usuario.getNome());
    }

}
