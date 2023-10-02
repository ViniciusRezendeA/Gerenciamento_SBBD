package models;
import java.util.List;
import java.util.Objects;

public class Universidade extends Instituicao{
    private String reitor;
    private List<String> cursos;


    public Universidade() {
    }

    public Universidade(String reitor, List<String> cursos) {
        this.reitor = reitor;
        this.cursos = cursos;
    }

    public String getReitor() {
        return this.reitor;
    }

    public void setReitor(String reitor) {
        this.reitor = reitor;
    }

    public List<String> getCursos() {
        return this.cursos;
    }

    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }
    public void addcurso(String curso){
        this.cursos.add(curso);
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Universidade)) {
            return false;
        }
        Universidade universidade = (Universidade) o;
        return Objects.equals(reitor, universidade.reitor) && Objects.equals(cursos, universidade.cursos);
    }

    @Override
    public String toString() {
        return super.toString() + 
            " reitor='" + getReitor() + "'" +
            ", cursos='" + getCursos() + "'" +
            "}";
    }

}
