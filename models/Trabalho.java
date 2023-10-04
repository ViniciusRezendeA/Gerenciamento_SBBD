package models;

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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Trabalho other = (Trabalho) obj;
        if (id != other.id)
            return false;
        return true;
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
