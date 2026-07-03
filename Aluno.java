package lpoo;

import java.util.ArrayList;

public class Aluno extends Pessoa implements Cadastravel, Matriculavel {

	private String matricula;
	private double peso;
	private String graduacao;
	private Turma turma;

	private ArrayList<Modalidade> modalidades;
	
    public Aluno(String matricula, String nome, double peso, String email, String dataNascimento, String graduacao, String cpf) {
    	super(nome, cpf, dataNascimento, email);

    	this.matricula = matricula;
        this.peso = peso;
        this.graduacao = graduacao;
        this.modalidades = new ArrayList<>();
    }
   
    @Override
    public void cadastrar() {
        System.out.println("Aluno cadastrado.");
    }

    @Override
    public void excluir() {
        System.out.println("Aluno removido.");
    }


    public void adicionarModalidade(Modalidade modalidade) {
        modalidades.add(modalidade);
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPeso() {
        return peso;
    }  

    public String getGraduacao() {
        return graduacao;
    }
     
    public Turma getTurma() {
    	return turma;
    }
    
    public void setTurma(Turma turma) {
    	this.turma = turma;
    }   

    public ArrayList<Modalidade> getModalidades() {
        return modalidades;
    }

    @Override
    public String toString() {

        String listaModalidades = "";

        for (Modalidade m : modalidades) {
            listaModalidades += m.getNome() + ", ";
        }

        if (!listaModalidades.isEmpty()) {
            listaModalidades =
                listaModalidades.substring(0, listaModalidades.length() - 2);
        }

        return "Aluno" +
               "\nMatrícula: " + matricula +
               "\nNome: " + getNome() +
               "\nPeso: " + peso +
               "\nE-mail: " + getEmail() +
               "\nData de Nascimento: " + getDataNascimento() +
               "\nGraduação: " + graduacao +
               "\nTelefones: " + getTelefones() +
               "\nModalidades: " + listaModalidades;
    }
}