package lpoo;

public class ServicosGerais extends Funcionario{
	 private String idServicosGerais;
	 private String turno;

	  public ServicosGerais(String cpf, String nome, String telefone, String email, String idFuncionario, 
	                        double experienciaAnos, String idServicosGerais, String turno) {
	       super(cpf, nome, telefone, email, idFuncionario, "Serviços Gerais", experienciaAnos);
	       this.idServicosGerais = idServicosGerais;
	       this.turno = turno;
	    }

	    public String getTurno() { return turno; }
	    public String getIdServicosGerais() {return idServicosGerais;}
}
