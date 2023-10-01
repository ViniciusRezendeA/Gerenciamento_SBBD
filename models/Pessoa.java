package models;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Pessoa {
    protected Long id;
    protected Long codigoDePesoa;
    protected String nome;
    protected LocalDate dataNascimento;

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


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pessoa)) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) && Objects.equals(codigoDePesoa, pessoa.codigoDePesoa)
                && Objects.equals(nome, pessoa.nome) && Objects.equals(dataNascimento, pessoa.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoDePesoa, nome, dataNascimento);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", codigoDePesoa='" + getCodigoDePesoa() + "'" +
                ", nome='" + getNome() + "'" +
                ", dataNascimento='" + getDataNascimento() + "'" +
                "}";
    }
}