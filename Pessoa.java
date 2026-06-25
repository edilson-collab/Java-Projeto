package lpoo;

import java.util.ArrayList;

public abstract class Pessoa implements Autenticavel{
	 protected String nome;
	 protected String cpf;
	 protected String dataNascimento;
	 protected String email;
	 protected String senha;
	 protected boolean primeiroAcesso;
	 protected ArrayList<String> telefones;

	    public Pessoa(String nome, String cpf,
	                  String dataNascimento,
	                  String email) {

	        this.nome = nome;
	        this.cpf = cpf;
	        this.dataNascimento = dataNascimento;
	        this.email = email;
	        this.senha = cpf;
	        this.primeiroAcesso = true;
	        this.telefones = new ArrayList<>();
	    }
	    public boolean isPrimeiroAcesso() {
	        return primeiroAcesso;
	    }

	    public void setPrimeiroAcesso(boolean primeiroAcesso) {
	        this.primeiroAcesso = primeiroAcesso;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public String getCpf() {
	        return cpf;
	    }

	    public String getDataNascimento() {
	        return dataNascimento;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getSenha() {
	        return senha;
	    }

	    public ArrayList<String> getTelefones() {
	        return telefones;
	    }

	    public void adicionarTelefone(String telefone) {
	        telefones.add(telefone);
	    }

	    public void setSenha(String senha) {
	        this.senha = senha;
	    }
}
