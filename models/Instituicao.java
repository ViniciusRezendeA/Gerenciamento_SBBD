package models;

import java.util.ArrayList;
import java.util.List;

public abstract class Instituicao {
    protected Long id;
    protected String cnpj;
    protected String nome;
    protected List<String> cargos;

    public Instituicao() {
        cargos = new ArrayList<>();
    }
    

    public Instituicao(Long id, String cnpj, String nome, List<String> cargos) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.cargos = cargos;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getCargos() {
        return this.cargos;
    }
    public void addCargos(String cargos){
        this.cargos.add(cargos);
    }

    public void setCargos(List<String> cargos) {
        this.cargos = cargos;
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
        Instituicao other = (Instituicao) obj;
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
            ", cnpj='" + getCnpj() + "'" +
            ", nome='" + getNome() + "'" +
            ", cargos='" + getCargos() + "'";

    }
    
}
