package lpoo;

public class Recepcionista extends Funcionario implements Matriculavel{

	private String matricula;
	private String turno;

	public Recepcionista(String matricula, String nome, String agencia, String numeroConta,
                     int experiencia, String cpf, String dataNascimento, String email, String turno) {

		super(nome, cpf, dataNascimento, email,
	      agencia, numeroConta, experiencia);

		this.matricula = matricula;
		this.turno = turno;
}

	public String getMatricula() {
		return matricula;
}

	public String getTurno() {
		return turno;
}

	@Override
	public void cadastrar() {
		System.out.println("Recepcionista cadastrada.");
}

	@Override
	public void excluir() {
		System.out.println("Recepcionista removida.");
}

	@Override
	public String toString() {
		return "Recepcionista: " + nome +
				"\nTurno: " + turno;
}

}
