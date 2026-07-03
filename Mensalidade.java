package lpoo;

public class Mensalidade {
	private static final String PENDENTE = "PENDENTE";
	private static final String PAGA = "PAGA";
	private String plano;
    private int idMensalidade;
    private Aluno aluno;
    private double valor;
    private String dataVencimento;
    private String dataPagamento;
    private String status;
    

    public Mensalidade(int idMensalidade, Aluno aluno, String dataVencimento) {
        this.idMensalidade = idMensalidade;
        this.aluno = aluno;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = "";
        this.status = PENDENTE;
    }
    
    public static void mostrarPlanos() {

        System.out.println("\n===== PLANOS DISPONÍVEIS =====");

        System.out.println("1 - Mensal       R$ 120,00");
        System.out.println("2 - Trimestral   R$ 330,00");
        System.out.println("3 - Semestral    R$ 600,00");
        System.out.println("4 - Anual        R$1100,00");
    }
    
    public boolean estaPaga() {
        return status.equals(PAGA);
    }
    
    public boolean estaPendente() {
        return status.equals(PENDENTE);
    }
    public boolean definirPlano(int opcao) {

        switch (opcao) {

        case 1:
            plano = "Mensal";
            valor = 120.00;
            return true;

        case 2:
            plano = "Trimestral";
            valor = 330.00;
            return true;

        case 3:
            plano = "Semestral";
            valor = 600.00;
            return true;

        case 4:
            plano = "Anual";
            valor = 1100.00;
            return true;

        default:
            System.out.println("Plano inválido.");
            return false;
        }
    }

    public int getIdMensalidade() {
        return idMensalidade;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public String getPlano() {
        return plano;
    }

    public double getValor() {
        return valor;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public String getStatus() {
        return status;
    }
    public void registrarPagamento(String dataPagamento) {

        this.dataPagamento = dataPagamento;

        this.status = PAGA;
    }
    public String gerarRecibo() {

        return "========== RECIBO ==========\n"
             + "Aluno: " + aluno.getNome()
             + "\nPlano: " + plano
             + "\nValor: R$ " + String.format("%.2f", valor)
             + "\nPagamento: " + dataPagamento
             + "\nStatus: " + status
             + "\n============================";
    }

    @Override
    public String toString() {

        return "Mensalidade: " + idMensalidade +
               "\nAluno: " + aluno.getNome() +
               "\nPlano: " + plano +
               "\nValor: R$ " + String.format("%.2f", valor) +
               "\nVencimento: " + dataVencimento +
               "\nPagamento: " +
               (dataPagamento.isEmpty() ? "Não realizado" : dataPagamento) +
               "\nStatus: " + status;
    }
}