package models;

import java.sql.Date;
import java.sql.Time;

public class MiniCurso{
    private Long id;
    private Date data;
    private Time horaInicio;
    private Time horaFim;
    private Sala sala;

    public MiniCurso() {
    }

    public MiniCurso(Long id, Date data, Time horaInicio, Time horaFim, Sala sala) {
        this.id = id;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
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
        MiniCurso other = (MiniCurso) obj;
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
            ", sala='" + getSala() + "'" +
            "}";
    }
}