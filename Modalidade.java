package tabica;


public class Modalidade {

    private String id;
    private String nome;
    private String nivel;
    private String graduacao;
    private String especialidade;

    public Modalidade(String id, String nome, String nivel, String graduacao, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.graduacao = graduacao;
        this.especialidade = especialidade;
    }

    public String getId() {
        return id;
    }
     public String getEspecialidade() {
        return especialidade;
    }

    public String getNome() {
        return nome;
    }
    public String getGraduacao() {
        return graduacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

}
