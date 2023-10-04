package models;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Pessoa {
    protected Long id;
    protected Long codigoDePesoa;
    protected String nome;
    protected LocalDate dataNascimento;
    protected Instituicao instituicao;
    public void inscreverSessaoTecnica(SessaoTecnica sessao) {

    }
     public void desinscreverSessaoTecnica(SessaoTecnica sessao) {

    }

    public Pessoa() {
    }

    public Pessoa(Long id, Long codigoDePesoa, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.codigoDePesoa = codigoDePesoa;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigoDePesoa() {
        return this.codigoDePesoa;
    }

    public void setCodigoDePesoa(Long codigoDePesoa) {
        this.codigoDePesoa = codigoDePesoa;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setInstituicao(Instituicao instituicao){
        this.instituicao = instituicao;
    }
    public Instituicao getInstituicao(){
        return this.instituicao;
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
        Pessoa other = (Pessoa) obj;
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
                ", codigoDePesoa='" + getCodigoDePesoa() + "'" +
                ", nome='" + getNome() + "'" +
                ", dataNascimento='" + getDataNascimento() + "'";
    }
}