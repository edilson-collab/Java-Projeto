package lpoo;

public abstract class Funcionario extends Pessoa {
	 private String idFuncionario;
	 private String cargo;
	 private double experienciaAnos;

	   
	    public Funcionario(String cpf, String nome, String telefone, String email, 
	                       String idFuncionario, String cargo, double experienciaAnos) {
	        super(cpf, nome, telefone, email);
	        this.idFuncionario = idFuncionario;
	        this.cargo = cargo;
	        this.experienciaAnos = experienciaAnos;
	    }

	   
	    public String getIdFuncionario() {
	        return idFuncionario;
	    }

	    public void setIdFuncionario(String idFuncionario) {
	        this.idFuncionario = idFuncionario;
	    }

	    public String getCargo() {
	        return cargo;
	    }

	    public void setCargo(String cargo) {
	        this.cargo = cargo;
	    }

	    public double getExperienciaAnos() {
	        return experienciaAnos;
	    }

	    public void setExperienciaAnos(double experienciaAnos) {
	        this.experienciaAnos = experienciaAnos;
	    }

	    @Override
	    public String toString() {
	        return "ID: " + idFuncionario + " | Nome: " + getNome() + " | Cargo: " + cargo;
	    }
}
