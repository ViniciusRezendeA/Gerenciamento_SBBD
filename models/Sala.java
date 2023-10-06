package models;

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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sala other = (Sala) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
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