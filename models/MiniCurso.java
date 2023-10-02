package models;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MiniCurso)) {
            return false;
        }
        MiniCurso miniCurso = (MiniCurso) o;
        return Objects.equals(id, miniCurso.id) && Objects.equals(data, miniCurso.data) && Objects.equals(horaInicio, miniCurso.horaInicio) && Objects.equals(horaFim, miniCurso.horaFim) && Objects.equals(sala, miniCurso.sala);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, horaInicio, horaFim, sala);
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