package lpoo;

import java.util.ArrayList;

public abstract class Funcionario implements Cadastravel {

	protected String nome;
	protected String agencia;
	protected String numeroConta;
	protected int experiencia;
	protected String cpf;
	protected String dataNascimento;
	protected String email;
	protected String senha;
	protected boolean primeiroAcesso;
	protected ArrayList<String> telefones;

	public Funcionario(String nome, String agencia, String numeroConta, int experiencia, String cpf,
                   String dataNascimento, String email) {

		this.nome = nome;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.experiencia = experiencia;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = "1234";
		this.primeiroAcesso = true;
		this.telefones = new ArrayList<>();
}

	public String getNome() {
		return nome;
}
	public String getCpf() {
	    return cpf;
	}

	public String getSenha() {
	    return senha;
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

	public void adicionarTelefone(String telefone) {
		telefones.add(telefone);
}

}
