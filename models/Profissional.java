package models;

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
    public String toString() {
        return super.toString() +
            " salario='" + getSalario() + "'" +
            "}";
    }
    
}
