package lpoo;

import java.util.ArrayList;

public class Mensalidade {

    private int idMensalidade;
    private ArrayList<String> planos;

    public Mensalidade(int idMensalidade) {
        this.idMensalidade = idMensalidade;
        this.planos = new ArrayList<>();
    }

    public int getIdMensalidade() {
        return idMensalidade;
    }

    public ArrayList<String> getPlanos() {
        return planos;
    }

    public void adicionarPlano(String plano) {
        planos.add(plano);
    }

    public void removerPlano(String plano) {
        planos.remove(plano);
    }

    @Override
    public String toString() {

        String listaPlanos = "";

        for (String plano : planos) {
            listaPlanos += plano + ", ";
        }

        if (!listaPlanos.isEmpty()) {
            listaPlanos =
                listaPlanos.substring(0, listaPlanos.length() - 2);
        }

        return "Mensalidade: " + idMensalidade +
               "\nPlanos: " + listaPlanos;
    }
}