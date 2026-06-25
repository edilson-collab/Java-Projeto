package lpoo;

import java.util.ArrayList;

public class RepositorioAcademia {
	 private ArrayList<Aluno> alunos;
	 private ArrayList<Professor> professores;
	 private ArrayList<Recepcionista> recepcionistas;
	 private ArrayList<Turma> turmas;

	 public RepositorioAcademia() {

	        alunos = new ArrayList<>();
	        professores = new ArrayList<>();
	        recepcionistas = new ArrayList<>();
	        turmas = new ArrayList<>();
	    }

	    public ArrayList<Aluno> getAlunos() {
	        return alunos;
	    }

	    public ArrayList<Professor> getProfessores() {
	        return professores;
	    }

	    public ArrayList<Recepcionista> getRecepcionistas() {
	        return recepcionistas;
	    }

	    public ArrayList<Turma> getTurmas() {
	        return turmas;
	    }
}
