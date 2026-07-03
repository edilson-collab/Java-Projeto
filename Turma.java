package lpoo;

import java.util.ArrayList;

public class Turma {
	private static final int LIMITE_ALUNOS = 30;
    private String idTurma;
    private String horario;
    private Professor professor;
    private ArrayList<Aluno> alunos;
    

    public Turma(String idTurma, String horario, Professor professor) {

        this.idTurma = idTurma;
        this.horario = horario;
        this.professor = professor;
        this.alunos = new ArrayList<>();
        
        
        if (!professor.adicionarTurma(this)) {
            throw new IllegalArgumentException(
                    "O professor já possui uma turma nesse horário.");
        }
    }

    public void adicionarAluno(Aluno aluno) {

        if (aluno == null) {
            System.out.println("Aluno inválido.");
            return;
        }

        if (aluno.getTurma() != null) {
            System.out.println("O aluno já está matriculado em uma turma.");
            return;
        }

        if (turmaCheia()) {
            System.out.println("A turma está lotada.");
            return;
        }

        if (alunos.contains(aluno)) {
            System.out.println("Aluno já pertence à turma.");
            return;
        }

        alunos.add(aluno);
        aluno.setTurma(this);
    }
    
    public int getQuantidadeAlunos() {
        return alunos.size();
    }
    
    public int getVagasDisponiveis() {
        return LIMITE_ALUNOS - alunos.size();
    }
    
    public boolean possuiVaga() {
        return alunos.size() < LIMITE_ALUNOS;
    }
    
    public boolean turmaCheia() {
        return alunos.size() >= LIMITE_ALUNOS;
    }
    
    public void removerAluno(Aluno aluno) {

        if (alunos.remove(aluno)) {
            aluno.setTurma(null);
        }
    }

    public String getIdTurma() {
        return idTurma;
    }

    public Modalidade getModalidade() {
        return professor.getModalidade();
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
    	           "\nModalidade: " + professor.getModalidade().getNome() +
    	           "\nProfessor: " + professor.getNome() +
    	           "\nHorário: " + horario +
    	           "\nAlunos: " + getQuantidadeAlunos() + "/" + LIMITE_ALUNOS +
    	           "\nVagas: " + getVagasDisponiveis() +
    	           "\nStatus: " + (turmaCheia() ? "Lotada" : "Aberta");
    }
}
