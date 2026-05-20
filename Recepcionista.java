package tabica;

import java.util.List;
import java.util.ArrayList;

public class Recepcionista extends Funcionarios{
    protected float id;
    protected String turno;
    
    private List<Aluno> alunos = new ArrayList<>();

    public Recepcionista(String matricula, String cpf, String nome, String dataNascimento,Banco banco,
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

    public void cadastrarAluno(String cpf, String matricula, String nome, double peso, String email, String telefone, Modalidade modalidade, String dataNascimento, Mensalidade mensalidade) {
        Aluno aluno = new Aluno(cpf, matricula, nome, peso, email, telefone, modalidade, dataNascimento, mensalidade);
        alunos.add(aluno);
    }
    
    public List<Aluno> getAlunos(){
    	return alunos;
    }

    }
