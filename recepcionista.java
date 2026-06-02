public class Recepcionista extends Funcionario {

    private int idRecepcionista;
    private String turno;

    // Construtor
    public Recepcionista(int idRecepcionista, String turno,
                         String numeroConta, int experiencia, String agencia,
                         String nome, String cpf, String email,
                         String dataNascimento, String telefone) {

        super(numeroConta, experiencia, agencia, nome, cpf, email,
              dataNascimento, telefone);

        this.idRecepcionista = idRecepcionista;
        this.turno = turno;
    }

    // Getters e Setters
    public int getIdRecepcionista() {
        return idRecepcionista;
    }

    public void setIdRecepcionista(int idRecepcionista) {
        this.idRecepcionista = idRecepcionista;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
