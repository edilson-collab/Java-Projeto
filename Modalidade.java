package lpoo;

import java.util.ArrayList;

public class Modalidade {

    private int idModalidade;
    private String nome;

    public Modalidade(int idModalidade, String nome) {
        this.idModalidade = idModalidade;
        this.nome = nome;
    }

    public int getIdModalidade() {
        return idModalidade;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public static ArrayList<Modalidade> criarModalidadesPadrao() {

        ArrayList<Modalidade> modalidades = new ArrayList<>();

        modalidades.add(new Modalidade(1, "Judô"));
        modalidades.add(new Modalidade(2, "Jiu-Jitsu"));
        modalidades.add(new Modalidade(3, "Taekwondo"));
        modalidades.add(new Modalidade(4, "Karatê"));
        modalidades.add(new Modalidade(5, "Capoeira"));
        modalidades.add(new Modalidade(6, "Boxe"));
        modalidades.add(new Modalidade(7, "Muay Thai"));

        return modalidades;
    }
    
}