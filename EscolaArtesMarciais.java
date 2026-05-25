package lpoo;

import java.util.ArrayList;
import java.util.List;

public class EscolaArtesMarciais {
	 private String nome;
	 private String endereco;
	 private String cnpj;
	 private String contato;
	 private String telefone;
	 private String email;
	 private List<Funcionario> funcionarios;

	    public EscolaArtesMarciais(String nome, String endereco, String cnpj, String contato, String telefone, String email) {
	        this.nome = nome;
	        this.endereco = endereco;
	        this.cnpj = cnpj;
	        this.contato = contato;
	        this.telefone = telefone;
	        this.email = email;
	        this.funcionarios = new ArrayList<>();
	    }

	    // Getters e Setters
	    public String getNome() { return nome; }
	    public String getEndereco() { return endereco; }
	    public String getCnpj() {return cnpj; }
	    public String getContato() { return contato; }
	    public String getTelefone() { return telefone; }
	    public String getEmail() { return email; }
	    public List<Funcionario> getFuncionarios() { return funcionarios; }
	    public void adicionarFuncionario(Funcionario f) { this.funcionarios.add(f); }	

}
