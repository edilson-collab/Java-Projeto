package lpoo;

public abstract class Funcionario extends Pessoa {

	protected String agencia;
	protected String numeroConta;
	protected int experiencia;
	
	public Funcionario(String nome, String cpf, String dataNascimento, String email, String agencia, String numeroConta, int experiencia) {
		super(nome, cpf, dataNascimento, email);
		
		 this.agencia = agencia;
	     this.numeroConta = numeroConta;
	     this.experiencia = experiencia;
	}
}
