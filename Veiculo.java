package lpoo;

public class Veiculo {
	private String placa;
    private String modelo;
    private String cor;
    private Pessoa proprietario;

    
    public Veiculo(String placa, String modelo, String cor, Pessoa proprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.proprietario = proprietario;
    }

   
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + " | " + modelo + " (" + cor + ") - Proprietário: " + proprietario.getNome();
    }
}
