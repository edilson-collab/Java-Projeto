package lpoo;

import java.util.ArrayList;

public class Turma {

    private int idTurma;
    private String nivel;
    private String horario;
    private Professor professor;
    private ArrayList<Aluno> alunos;

    public Turma(int idTurma, String nivel, String horario, Professor professor) {

        this.idTurma = idTurma;
        this.nivel = nivel;
        this.horario = horario;
        this.professor = professor;
        this.alunos = new ArrayList<>();
        
        professor.adicionarTurma(this);
    }

    public void adicionarAluno(Aluno aluno) {
    	if (!alunos.contains(aluno)) {

            alunos.add(aluno);
            aluno.setTurma(this);
            }
    }

    public int getIdTurma() {
        return idTurma;
    }

    public String getNivel() {
        return nivel;
    }

    public String getHorario() {
        return horario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
    
    
    public String listarAlunos() {

        if (alunos.isEmpty()) {
            return "Nenhum aluno matriculado.";
        }

        String resultado = "";

        for (Aluno aluno : alunos) {

            resultado += aluno.getNome()
                    + " - Matrícula: "
                    + aluno.getMatricula()
                    + "\n";
        }

        return resultado;
    }

    @Override
    public String toString() {
        return "Turma: " + idTurma +
               "\nNível: " + nivel +
               "\nHorário: " + horario +
               "\nProfessor: " + professor.getNome();
    }
}
