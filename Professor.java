package lpoo;
import java.util.ArrayList;
public class Professor extends Funcionario implements Matriculavel {
	private String matricula;
	private String graduacao;
	private Modalidade modalidade;
	private int cargaHoraria;
	private ArrayList<Turma> turmas;
	
	public Professor(String matricula, String nome, String agencia,	String numeroConta,
		int experiencia, String cpf, String dataNascimento, String email, 
		String graduacao, Modalidade modalidade, int cargaHoraria) {
	
	super(nome, cpf, dataNascimento, email, agencia, numeroConta, experiencia);
	
	this.matricula = matricula;
	this.graduacao = graduacao;
	this.modalidade = modalidade;
	this.cargaHoraria = cargaHoraria;
	this.turmas = new ArrayList<>();
	
    }
	
	
	public String getMatricula() {
	    return matricula;
	}

	public String getGraduacao() {
	    return graduacao;
	}

	public Modalidade getModalidade() {
	    return modalidade;
	}

	public int getCargaHoraria() {
	    return cargaHoraria;
	}
	
	public boolean adicionarTurma(Turma turma) {

	    if (turma == null) {
	        System.out.println("Turma inválida.");
	        return false;
	    }

	    for (Turma turmaExistente : turmas) {

	        if (turmaExistente.getHorario().equals(turma.getHorario())) {

	            System.out.println(
	                "O professor já possui uma turma nesse horário."
	            );

	            return false;
	        }
	    }

	    turmas.add(turma);

	    return true;
	}
	
	public void removerTurma(Turma turma) {
		turmas.remove(turma);
	}
	
	public ArrayList<Turma> getTurmas(){
		return turmas;
	}
	
	public String listarTurmas() {

	    if (turmas.isEmpty()) {
	        return "Nenhuma turma cadastrada.";
	    }

	    String resultado = "";

	    for (Turma turma : turmas) {
	    	 resultado += "Turma: " + turma.getIdTurma()
             + "\nModalidade: " + turma.getModalidade().getNome()
             + "\nHorário: " + turma.getHorario()
             + "\n\n";
	    }

	    return resultado;
	}

	@Override
	public String toString() {
		return "Professor: " + nome +
		           "\nCPF: " + cpf +
		           "\nGraduação: " + graduacao +
		           "\nModalidade: " + modalidade.getNome() +
		           "\nCarga Horária: " + cargaHoraria +
		           "\nQuantidade de Turmas: " + turmas.size();
	}

	}