package tabica;

public class Turma {
	private String horarios;
	private String niveis;
	private int  id;
	
	public Turma(String horarios, String niveis, int id) {
		this.horarios = horarios;
		this.niveis = niveis;
		this.id = id;
	}
	
	public String getHorarios() {
		return horarios;
	}
	
	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}
	
	public  String getNiveis() {
		return niveis;
	}
	
	public void setNiveis(String niveis) {
		this.niveis = niveis;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
