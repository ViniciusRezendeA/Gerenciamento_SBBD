package models;
import java.util.Objects;

public class Trabalho {
 private int id;
 private String tituto;
 private String resumo;
 private Apresentacao apresentacao;

    public Trabalho() {
    }

    public Trabalho(int id, String tituto, String resumo, Apresentacao apresentacao) {
        this.id = id;
        this.tituto = tituto;
        this.resumo = resumo;
        this.apresentacao = apresentacao;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituto() {
        return this.tituto;
    }

    public void setTituto(String tituto) {
        this.tituto = tituto;
    }

    public String getResumo() {
        return this.resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Apresentacao getApresentacao() {
        return this.apresentacao;
    }

    public void setApresentacao(Apresentacao apresentacao) {
        this.apresentacao = apresentacao;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Trabalho)) {
            return false;
        }
        Trabalho trabalho = (Trabalho) o;
        return id == trabalho.id && Objects.equals(tituto, trabalho.tituto) && Objects.equals(resumo, trabalho.resumo) && Objects.equals(apresentacao, trabalho.apresentacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tituto, resumo, apresentacao);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", tituto='" + getTituto() + "'" +
            ", resumo='" + getResumo() + "'" +
            ", apresentacao='" + getApresentacao() + "'" +
            "}";
    }
 
}
