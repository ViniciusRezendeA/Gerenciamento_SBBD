package models;

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
    public String toString() {
        return super.toString() + " Professor [departamento=" + departamento + ", salario=" + salario + "]";
    }


    
}
