package lpoo;

public class Professor extends Funcionario{
	 private String idProfessor;
	 private String graduacao;
	 private String especialidade;
	 private double cargaHoraria;

	    public Professor(String cpf, String nome, String telefone, String email, String idFuncionario, 
	                     double experienciaAnos, String idProfessor, String graduacao, String especialidade, double cargaHoraria) {
	        super(cpf, nome, telefone, email, idFuncionario, "Professor", experienciaAnos);
	        this.idProfessor = idProfessor;
	        this.graduacao = graduacao;
	        this.especialidade = especialidade;
	        this.cargaHoraria = cargaHoraria;
	    }

	    public String getIdProfessor() { return idProfessor; }
	    public double getCargaHoraria() { return cargaHoraria; } 
	    public String getGraduacao() { return graduacao; }
	    public String getEspecialidade() { return especialidade; }
}
