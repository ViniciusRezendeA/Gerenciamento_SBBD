package models;
import java.util.List;

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
    public String toString() {
        return super.toString() + 
            " reitor='" + getReitor() + "'" +
            ", cursos='" + getCursos() + "'" +
            "}";
    }

}
