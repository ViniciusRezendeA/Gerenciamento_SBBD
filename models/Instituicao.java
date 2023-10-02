package models;

import java.util.List;
import java.util.Objects;

public abstract class Instituicao {
    protected Long id;
    protected String cnpj;
    protected String nome;
    protected List<String> cargos;

    public Instituicao() {
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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Instituicao)) {
            return false;
        }
        Instituicao instituicao = (Instituicao) o;
        return Objects.equals(id, instituicao.id) && Objects.equals(cnpj, instituicao.cnpj) && Objects.equals(nome, instituicao.nome) && Objects.equals(cargos, instituicao.cargos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnpj, nome, cargos);
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
