package models;

import java.sql.Time;
import java.util.List;

public class Apresentacao {
    private Long id;
    private Time horaApresentacao;
    private Time duracaoApresentacao;
    private List<SessaoTecnica> sessoesTecnicas;
    public void definirSessaoTecnica(){

    }


    public Apresentacao() {
    }

    public Apresentacao(Long id, Time horaApresentacao, Time duracaoApresentacao, List<SessaoTecnica> sessoesTecnicas) {
        this.id = id;
        this.horaApresentacao = horaApresentacao;
        this.duracaoApresentacao = duracaoApresentacao;
        this.sessoesTecnicas = sessoesTecnicas;
    }

    public List<SessaoTecnica> getSessoesTecnicas() {
        return this.sessoesTecnicas;
    }
   public void addSessoesTecnicas(SessaoTecnica sessoesTecnics) {
        this.sessoesTecnicas.add(sessoesTecnics);
   }
    public void setSessoesTecnicas(List<SessaoTecnica> sessoesTecnicas) {
        this.sessoesTecnicas = sessoesTecnicas;
    }

    public Apresentacao(Long id, Time horaApresentacao, Time duracaoApresentacao) {
        this.id = id;
        this.horaApresentacao = horaApresentacao;
        this.duracaoApresentacao = duracaoApresentacao;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getHoraApresentacao() {
        return this.horaApresentacao;
    }

    public void setHoraApresentacao(Time horaApresentacao) {
        this.horaApresentacao = horaApresentacao;
    }

    public Time getDuracaoApresentacao() {
        return this.duracaoApresentacao;
    }

    public void setDuracaoApresentacao(Time duracaoApresentacao) {
        this.duracaoApresentacao = duracaoApresentacao;
    }
    


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Apresentacao other = (Apresentacao) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", horaApresentacao='" + getHoraApresentacao() + "'" +
            ", duracaoApresentacao='" + getDuracaoApresentacao() + "'" +
            "}";
    }
    
}
