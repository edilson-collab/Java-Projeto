package lpoo;

public class Aluno extends Pessoa {
	private String matricula;
    private double peso;
    private String dataNascimento;
    private String modalidade; 
    private Mensalidade mensalidade;

    public Aluno(String cpf, String nome, String telefone, String email, 
                 String matricula, double peso, String dataNascimento, String modalidade) {
        super(cpf, nome, telefone, email);
        this.matricula = matricula;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
        this.modalidade = modalidade;
    }

   
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getModalidade() { return modalidade; }
    public void setModalidade(String modalidade) { this.modalidade = modalidade; }

    public Mensalidade getMensalidade() { return mensalidade; }
    public void setMensalidade(Mensalidade mensalidade) { this.mensalidade = mensalidade; }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + " | Nome: " + getNome() + " | Modalidade: " + modalidade;
    }
}
