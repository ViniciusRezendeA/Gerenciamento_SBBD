package services;

import java.util.Scanner;

import models.Instituicao;
import util.Utils;

public class ServiceInstituicao {
    protected Scanner scan = new Scanner(System.in);

    public void getInstituicaoInfo(Instituicao instituicao) {
        System.out.println("Informe o nome da Instituição");
        instituicao.setNome(scan.nextLine());
        System.out.println("Informe o CNPJ da " + instituicao.getNome());
        instituicao.setCnpj(scan.nextLine());
        registerCargos(instituicao);
    }

    public void registerCargos(Instituicao instituicao) {
        String cargo;
        do {
            Utils.clearTerminal();
            System.out.println("Informe o cargo desejado(para sair escrava finalizar)");
            cargo = scan.nextLine();
            if (!cargo.toLowerCase().equals("finalizar")) {
                instituicao.addCargos(cargo);
            }
        } while (!cargo.toLowerCase().equals("finalizar"));
    }
}
