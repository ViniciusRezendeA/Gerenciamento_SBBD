package models;
import java.util.Objects;

public class Profissional extends Pessoa {
    private Double salario;

    public void ministrar(){

    }

    public Profissional() {
    }

    public Profissional(Double salario) {
        this.salario = salario;
    }

    public Double getSalario() {
        return this.salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Profissional salario(Double salario) {
        setSalario(salario);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Profissional)) {
            return false;
        }
        Profissional profissional = (Profissional) o;
        return Objects.equals(salario, profissional.salario);
    }


    @Override
    public String toString() {
        return super.toString() +
            " salario='" + getSalario() + "'" +
            "}";
    }
    
}
