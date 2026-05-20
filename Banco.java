package tabica;

public class Banco{

    protected String agencia;
    protected String numeroConta;

    public Banco( String agencia, String numeroConta){
            this.agencia = agencia;
            this.numeroConta = numeroConta;
    }
   public String getAgencia(){
      return agencia;
   }
  public String getNumeroConta(){
      return numeroConta;
   }
  }
