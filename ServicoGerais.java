package tabica;

import java.util.List;

public class ServicoGerais extends Funcionarios{
    protected float id;
    protected String turno;

    public ServicoGerais(String matricula, String cpf, String nome, String dataNascimento, Banco banco,
			String agencia, String numeroConta, int experiencia, String email, 
			List<String> telefones, float id, String turno) {
			super(matricula, cpf, nome, dataNascimento, banco, email, telefones);

            this.id=id;
            this.turno=turno;	
        
    }

    public float getId(){
        return id;
    }
    public String getTurno(){
        return turno;
    }
    public void setId(float id){
        this.id=id;
    }
    public void setTurno(String turno){
        this.turno=turno;
    }

}
