package tabica;

public class Mensalidade {

    private String id;
    private double valor;
    private String dataPagamento;
    private String status;

    private Aluno aluno;
    private Modalidade modalidade;

    public Mensalidade(String id, double valor, String dataPagamento,
                       String status, Aluno aluno, Modalidade modalidade) {

        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.status = status;
        this.aluno = aluno;
        this.modalidade = modalidade;
    }

    public String getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
}
