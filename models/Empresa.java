package models;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Empresa)) {
            return false;
        }
        Empresa empresa = (Empresa) o;
        return Objects.equals(ramo, empresa.ramo);
    }

    @Override
    public String toString() {
        return super.toString() +
            " ramo='" + getRamo() + "'" +
            "}";
    }
    
    
}
