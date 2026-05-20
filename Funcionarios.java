package tabica;

import java.util.ArrayList;
import java.util.List;

public abstract class Funcionarios {
	protected String matricula;
	protected String cpf;
	protected String nome;
	protected String dataNascimento;
	protected Banco banco;
	protected String email;
	protected List<String> telefones;
	
	public Funcionarios (String matricula, String cpf, String nome, String dataNascimento,
			Banco banco, String email, 
			List<String> telefones) {
		this.matricula = matricula;
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.banco = banco;
		this.email = email;
		this.telefones = (telefones != null) ? telefones : new ArrayList<>();
	}
	public String getMatricula(){
		return matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public Banco getBanco() {
		return banco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getTelefones() {
		return telefones;
	}
	public void setTelefone(List<String> telefone) {
		this.telefones = telefone;
	}
	public void adicionarTelefone(String telefone) {
		if (telefone != null && !telefone.isEmpty()) {
		this.telefones.add(telefone);
		}
	}
	public void removerTelefone(String telefone) {
		this.telefones.remove(telefone);
	}

}

