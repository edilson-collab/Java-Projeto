package lpoo;

public class Mensalidade {
	 private String idMensalidade;
	 private String plano; 
	 private double valor;
	 private String statusPagamento;

	    public Mensalidade(String idMensalidade, String plano, double valor, String statusPagamento) {
	        this.idMensalidade = idMensalidade;
	        this.plano = plano;
	        this.valor = valor;
	        this.statusPagamento = statusPagamento;
	    }

	   
	    public String getIdMensalidade() { return idMensalidade; }
	    public String getPlano() { return plano; }
	    public double getValor() { return valor; }
	    public String getStatusPagamento() { return statusPagamento; }
	    public void setStatusPagamento(String statusPagamento) { this.statusPagamento = statusPagamento; }
}
