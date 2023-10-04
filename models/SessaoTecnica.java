package models;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class SessaoTecnica {
    private Long id;
    private Date data;
    private Time horaInicio;
    private Time horaFim;
    private String local;
    private Professor mediador;
    private List<Pessoa> participantes;
    private Apresentacao apresentacao;
    private Sala sala;

    public void definirSala() {
    }

    public SessaoTecnica() {
    }

    public SessaoTecnica(Long id, Date data, Time horaInicio, Time horaFim, String local, Professor mediador,
            List<Pessoa> participantes, Apresentacao apresentacao, Sala sala) {
        this.id = id;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.local = local;
        this.mediador = mediador;
        this.participantes = participantes;
        this.apresentacao = apresentacao;
        this.sala = sala;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHoraInicio() {
        return this.horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFim() {
        return this.horaFim;
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Professor getMediador() {
        return this.mediador;
    }

    public void setMediador(Professor mediador) {
        this.mediador = mediador;
    }

    public List<Pessoa> getParticipantes() {
        return this.participantes;
    }

    public void setParticipantes(List<Pessoa> participantes) {
        this.participantes = participantes;
    }

    public Apresentacao getApresentacao() {
        return this.apresentacao;
    }

    public void setApresentacao(Apresentacao apresentacao) {
        this.apresentacao = apresentacao;
    }

    public Sala getSala() {
        return this.sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
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
        SessaoTecnica other = (SessaoTecnica) obj;
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
                ", data='" + getData() + "'" +
                ", horaInicio='" + getHoraInicio() + "'" +
                ", horaFim='" + getHoraFim() + "'" +
                ", local='" + getLocal() + "'" +
                ", mediador='" + getMediador() + "'" +
                ", participantes='" + getParticipantes() + "'" +
                ", apresentacao='" + getApresentacao() + "'" +
                ", sala='" + getSala() + "'" +
                "}";
    }

}
