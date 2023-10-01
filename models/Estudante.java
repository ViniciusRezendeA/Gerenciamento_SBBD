package models;
import java.util.Objects;

public class Estudante extends Pessoa {
    private String curso;

    public Estudante() {
    }

    public Estudante(String curso) {
        this.curso = curso;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Estudante)) {
            return false;
        }
        Estudante estudante = (Estudante) o;
        return Objects.equals(curso, estudante.curso);
    }

    @Override
    public String toString() {
        return  super.toString()  +
            " curso='" + getCurso() + "'" +
            "}";
    }

    
}
