package lpoo;

import java.util.ArrayList;

public class Aluno implements Cadastravel {

    private String matricula;
    private String nome;
    private double peso;
    private String email;
    private String dataNascimento;
    private String graduacao;
    private String cpf;
    private String senha;
    private boolean primeiroAcesso;
    private Turma turma;
    
    private ArrayList<String> telefones;
    private ArrayList<Modalidade> modalidades;

    public Aluno(String matricula, String nome, double peso, String email, String dataNascimento,
                 String graduacao, String cpf) {

        this.matricula = matricula;
        this.nome = nome;
        this.peso = peso;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.graduacao = graduacao;
        this.cpf = cpf;
        this.senha = cpf;
        this.primeiroAcesso = true;

        this.telefones = new ArrayList<>();
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

    public void adicionarTelefone(String telefone) {
        telefones.add(telefone);
    }

    public void adicionarModalidade(Modalidade modalidade) {
        modalidades.add(modalidade);
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public String getEmail() {
        return email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getGraduacao() {
        return graduacao;
    }
    
    public String getCpf() {
    	return cpf;
    }
    
    public String getSenha() {
    	return senha;
    }
    
    public Turma getTurma() {
    	return turma;
    }
    
    public void setTurma(Turma turma) {
    	this.turma = turma;
    }
    
    public void setSenha(String senha) {
    	this.senha = senha;
    }    
    
    public boolean isPrimeiroAcesso() {
    	return primeiroAcesso;
    }
    
    public void setPrimeiroAcesso(boolean primeiroAcesso) {
    	this.primeiroAcesso = primeiroAcesso;
    }

    public ArrayList<String> getTelefones() {
        return telefones;
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
               "\nNome: " + nome +
               "\nPeso: " + peso +
               "\nE-mail: " + email +
               "\nData de Nascimento: " + dataNascimento +
               "\nGraduação: " + graduacao +
               "\nTelefones: " + telefones +
               "\nModalidades: " + listaModalidades;
    }
}