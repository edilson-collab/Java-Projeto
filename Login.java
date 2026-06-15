package lpoo;

import java.util.ArrayList;

public class Login {
	 public static Recepcionista autenticarRecepcionista(
	            String cpf,
	            String senha,
	            ArrayList<Recepcionista> recepcionistas) {

	        for (Recepcionista recepcionista : recepcionistas) {
	            if (recepcionista.getCpf().equals(cpf)
	                    && recepcionista.getSenha().equals(senha)) {
	                return recepcionista;
	            }
	        }

	        return null;
	    }

	    public static Professor autenticarProfessor(
	            String cpf,
	            String senha,
	            ArrayList<Professor> professores) {

	        for (Professor professor : professores) {
	            if (professor.getCpf().equals(cpf)
	                    && professor.getSenha().equals(senha)) {
	                return professor;
	            }
	        }

	        return null;
	    }

	    public static Aluno autenticarAluno(
	            String cpf,
	            String senha,
	            ArrayList<Aluno> alunos) {

	        for (Aluno aluno : alunos) {
	            if (aluno.getCpf().equals(cpf)
	                    && aluno.getSenha().equals(senha)) {
	                return aluno;
	            }
	        }

	        return null;
	    }
	    
	    public static Recepcionista buscarRecepcionistaPorCpf(
	            String cpf,
	            ArrayList<Recepcionista> recepcionistas) {

	        for (Recepcionista recepcionista : recepcionistas) {
	            if (recepcionista.getCpf().equals(cpf)) {
	                return recepcionista;
	            }
	        }
	        return null;
	    }
	    
	    public static Professor buscarProfessorPorCpf(
	            String cpf,
	            ArrayList<Professor> professores) {

	        for (Professor professor : professores) {
	            if (professor.getCpf().equals(cpf)) {
	                return professor;
	            }
	        }
	        return null;
	    }
	    
	    public static Aluno buscarAlunoPorCpf(
	            String cpf,
	            ArrayList<Aluno> alunos) {

	        for (Aluno aluno : alunos) {
	            if (aluno.getCpf().equals(cpf)) {
	                return aluno;
	            }
	        }
	        return null;
	    }
}
