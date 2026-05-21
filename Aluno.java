package tabica;

public class Aluno {
	private String cpf;
	private String matricula;
	private String nome;
	private double peso;
	private String email;
	private String telefone;
	private Modalidade modalidade;
	private String dataDeNascimento;
	private Mensalidade mensalidade;
	
	public Aluno(String cpf, String matricula, String nome, double peso, String email, String telefone, Modalidade modalidade, String dataDeNascimento, Mensalidade mensalidade) {
		this.cpf = cpf;
		this.matricula = matricula;
		this.nome = nome;
		this.peso = peso;
		this.email = email;
		this.telefone = telefone;
		this.dataDeNascimento = dataDeNascimento;
		this.mensalidade = mensalidade;
		this.modalidade = modalidade;
	}

	public String getCpf() {
		return cpf;
	}
	public Modalidade getModalidade(){
		return modalidade;
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
	
	public String getTelefone() {
		return telefone;
	}
	
	
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Mensalidade getMensalidade(){
		return mensalidade;
	}
	
	public void exibirInformacoes() {
		System.out.println("-- Informações do Aluno --");
		System.out.println("Nome: " + this.nome);
		System.out.println("Matrícula: " + this.matricula);
		System.out.println("CPF: " + this.cpf);
		System.out.println("E-mail: " + this.email);
		System.out.println("Telefone: " + this.telefone);
		System.out.println("Mensalidade: " + this.mensalidade);
		System.out.println("Data de Nascimento: " + this.dataDeNascimento);
		System.out.println("Peso: " + this.peso);
		System.out.println("-------THE END-------");
	}
	
	}




