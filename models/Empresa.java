package models;

public class Empresa extends Instituicao{
    private String ramo;

    public Empresa() {
    }

    public Empresa(String ramo) {
        this.ramo = ramo;
    }

    public String getRamo() {
        return this.ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public Empresa ramo(String ramo) {
        setRamo(ramo);
        return this;
    }

    @Override
    public String toString() {
        return super.toString() +
            " ramo='" + getRamo() + "'" +
            "}";
    }
    
    
}
