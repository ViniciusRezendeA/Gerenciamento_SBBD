package services;

import java.util.Scanner;

import util.Utils;

public class ServiceSBBD {
    public Scanner scan = new Scanner(System.in);

    public void menuInicial() {
        int optionInt = 0;

        ServiceApresentacao serviceApresentacao = new ServiceApresentacao();
        ServiceEmpresa serviceEmpresa = new ServiceEmpresa();
        ServiceEstudante serviceEstudante = new ServiceEstudante();
        ServiceMiniCurso serviceMiniCurso = new ServiceMiniCurso();
        ServiceProfessor serviceProfessor = new ServiceProfessor();
        ServiceProfissional serviceProfissional = new ServiceProfissional();
        ServiceSala serviceSala = new ServiceSala();
        ServiceSessaoTecnica serviceSessaoTecnica = new ServiceSessaoTecnica();
        ServiceTrabalho serviceTrabalho = new ServiceTrabalho();
        ServiceUniversidade serviceUniversidade = new ServiceUniversidade();

        do {
            if (scan.nextLine() == "\n" || optionInt == 0) {
                Utils.clearTerminal();
                Utils.printMenuTitle("Menu do SBBD");
                System.out.println(" 1 - Menu Apresentação");
                System.out.println(" 2 - Menu Empresa");
                System.out.println(" 3 - Menu Estudante");
                System.out.println(" 4 - Menu Mini Curso");
                System.out.println(" 5 - Menu Professor");
                System.out.println(" 6 - Menu Profissional");
                System.out.println(" 7 - Menu Sala");
                System.out.println(" 8 - Menu Sessão Tecnica");
                System.out.println(" 9 - Menu Trabalho");
                System.out.println("10 - Menu Universiade");

                System.out.println("11 - Sair ");
            }

            String option = scan.nextLine();
            try {
                optionInt = Integer.parseInt(option);
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                System.out.println("Pressione enter para continuar...");
            }
            if (optionInt > 11) {
                System.out.println("Opção inválida!");
                System.out.println("Pressione enter para continuar...");
            }

            switch (optionInt) {
                case 1:
                    serviceApresentacao.menuInicial();
                    break;

                case 2:
                    serviceEmpresa.menuInicial();
                    break;

                case 3:
                    serviceEstudante.menuInicial();
                    break;

                case 4:
                    serviceMiniCurso.menuInicial();
                    break;

                case 5:
                    serviceProfessor.menuInicial();
                    break;

                case 6:
                    serviceProfissional.menuInicial();
                    break;

                case 7:
                    serviceSala.menuInicial();
                    break;

                case 8:
                    serviceSessaoTecnica.menuInicial();
                    break;

                case 9:
                    serviceTrabalho.menuInicial();
                    break;

                case 10:
                    serviceUniversidade.menuInicial();
                    break;

                default:
                    break;
            }
            if (optionInt != 11) {
                optionInt = 0;
            }
        } while (optionInt != 11);
        scan.close();
    }
}