package lpoo;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	    private String idTurma;
	    private String niveis;
	    private String horarios;
	    private Professor professor;
	    private List<Aluno> alunos;

	    public Turma(String idTurma, String niveis, String horarios, Professor professor) {
	        this.idTurma = idTurma;
	        this.niveis = niveis;
	        this.horarios = horarios;
	        this.professor = professor;
	        this.alunos = new ArrayList<>();
	    }

	    // Getters e Setters
	    public String getIdTurma() { return idTurma; }
	    public String getNiveis() {return niveis;}
	    public String getHorarios() { return horarios; }
	    public Professor getProfessor() { return professor; }
	    public List<Aluno> getAlunos() { return alunos; }
	    public void matricularAluno(Aluno aluno) { this.alunos.add(aluno); }
}
