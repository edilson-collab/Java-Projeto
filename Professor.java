package lpoo;
import java.util.ArrayList;
public class Professor extends Funcionario {
	private String matricula;
	private String graduacao;
	private String especialidade;
	private int cargaHoraria;
	private ArrayList<Turma> turmas;
	
	public Professor(String matricula, String nome, String agencia,	String numeroConta,
		int experiencia, String cpf, String dataNascimento, String email, 
		String graduacao, String especialidade, int cargaHoraria) {
	
	super(nome, agencia, numeroConta, experiencia, cpf, dataNascimento, email);
	
	this.matricula = matricula;
	this.graduacao = graduacao;
	this.especialidade = especialidade;
	this.cargaHoraria = cargaHoraria;
	this.turmas = new ArrayList<>();
	
    }
	public String getMatricula() {
	    return matricula;
	}

	public String getGraduacao() {
	    return graduacao;
	}

	public String getEspecialidade() {
	    return especialidade;
	}

	public int getCargaHoraria() {
	    return cargaHoraria;
	}
	
	public void adicionarTurma(Turma turma) {
		turmas.add(turma);
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
             + "\nNível: " + turma.getNivel()
             + "\nHorário: " + turma.getHorario()
             + "\n\n";
	    }

	    return resultado;
	}

	@Override
	public void cadastrar() {
	    System.out.println("Professor cadastrado.");
	}

	@Override
	public void excluir() {
	    System.out.println("Professor removido.");
	}

	@Override
	public String toString() {
		return "Professor: " + nome +
		           "\nCPF: " + cpf +
		           "\nGraduação: " + graduacao +
		           "\nEspecialidade: " + especialidade +
		           "\nCarga Horária: " + cargaHoraria +
		           "\nQuantidade de Turmas: " + turmas.size();
	}

	}