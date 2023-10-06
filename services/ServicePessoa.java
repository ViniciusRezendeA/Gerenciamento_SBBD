package services;

import java.time.LocalDate;
import java.util.Scanner;

import models.Pessoa;
import repositories.RepositoryEmpresa;
import repositories.RepositoryUniversidade;

public class ServicePessoa {
    protected RepositoryEmpresa repositoryEmpresa = RepositoryEmpresa.getInstance();
    protected RepositoryUniversidade repositoryUniversidade = RepositoryUniversidade.getInstance();
    protected Scanner scan = new Scanner(System.in);

    public void getPessoaInfo(Pessoa pessoa) {
        pessoa.setCodigoDePesoa(pessoa.getId());
        System.out.println("Informe o nome do Estudante");
        pessoa.setNome(scan.nextLine());
        System.out.println("Informe a data de nascimento do " + pessoa.getNome() + ", no formato de AAAA-MM-DD");
        pessoa.setDataNascimento(LocalDate.parse(scan.nextLine()));

    }

}
