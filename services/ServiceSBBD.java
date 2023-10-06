package services;

import java.util.Scanner;

import util.Utils;

public class ServiceSBBD {

    public Scanner scan = new Scanner(System.in);

    public void menuInicial() {
        int optionInt = 0;

        do {
            if (scan.nextLine() == "\n" || optionInt == 0) {
                Utils.clearTerminal();
                Utils.printMenuTitle("Menu do SBBD");
                System.out.println("1 - Menu Universidade");
                System.out.println("2 - Menu Empresa");
                System.out.println("3 - Menu Estudante");
                System.out.println("4- Menu Profissional");
                System.out.println("5 - Menu Professor");
                System.out.println("6 - Sair ");
            }

            String option = scan.nextLine();
            try {
                optionInt = Integer.parseInt(option);
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                System.out.println("Pressione enter para continuar...");
            }
            if (optionInt > 6) {
                System.out.println("Opção inválida!");
                System.out.println("Pressione enter para continuar...");
            }

            switch (optionInt) {
                case 1:
                    ServiceUniversidade serviceUniversidade = new ServiceUniversidade();
                    serviceUniversidade.menuInicial();
                    break;

                case 2:
                    ServiceEmpresa serviceEmpresa = new ServiceEmpresa();
                    serviceEmpresa.menuInicial();
                    break;

                case 3:
                    ServiceEstudante serviceEstudante = new ServiceEstudante();
                    serviceEstudante.menuInicial();
                    break;

                case 4:
                    ServiceProfissional serviceProfissional = new ServiceProfissional();
                    serviceProfissional.menuInicial();
                    break;
                case 5:
                    ServiceProfessor serviceProfessor = new ServiceProfessor();
                    serviceProfessor.menuInicial();
                    break;

                default:
                    break;
            }
            if (optionInt != 6) {
                optionInt = 0;
            }
        } while (optionInt != 6);
        scan.close();
    }
}