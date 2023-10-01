package models;
import java.util.Objects;

public class Professor extends Pessoa{
    private String departamento;
    private Double salario;

    public void mediar(SessaoTecnica sessaoTecnica){
        sessaoTecnica.setMediador(this);
    }

    public Professor() {
    }

    public Professor(String departamento, Double salario) {
        this.departamento = departamento;
        this.salario = salario;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Double getSalario() {
        return this.salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Professor)) {
            return false;
        }
        Professor professor = (Professor) o;
        return Objects.equals(departamento, professor.departamento) && Objects.equals(salario, professor.salario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departamento, salario);
    }

    @Override
    public String toString() {
        return "{" +
            " departamento='" + getDepartamento() + "'" +
            ", salario='" + getSalario() + "'" +
            "}";
    }
    
}
