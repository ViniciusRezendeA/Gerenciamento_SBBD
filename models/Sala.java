package models;
import java.util.Objects;

public class Sala {
    private Long id;
    private int codigo;
    private int idPredio;


    public Sala() {
    }

    public Sala(Long id, int codigo, int idPredio) {
        this.id = id;
        this.codigo = codigo;
        this.idPredio = idPredio;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdPredio() {
        return this.idPredio;
    }

    public void setIdPredio(int idPredio) {
        this.idPredio = idPredio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Sala)) {
            return false;
        }
        Sala sala = (Sala) o;
        return Objects.equals(id, sala.id) && codigo == sala.codigo && idPredio == sala.idPredio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, idPredio);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", codigo='" + getCodigo() + "'" +
            ", idPredio='" + getIdPredio() + "'" +
            "}";
    }
}