package services;

import java.util.List;

import models.Empresa;
import repositories.RepositoryEmpresa;
import util.Utils;

public class ServiceEmpresa extends ServiceInstituicao implements IService {

    public void menuInicial() {
        int optionInt = 0;

        do {
            if (scan.nextLine() == "\n" || optionInt == 0) {
                Utils.clearTerminal();
                Utils.printMenuTitle("Menu do Empresa");
                System.out.println("1 - cadastrar Empresa");
                System.out.println("2 - Deletar Empresa");
                System.out.println("3 - atualizar Empresa");
                System.out.println("4 - Buscar Empresa");
                System.out.println("5 - Mostrar todos os Empresas");
                System.out.println("6 - Voltar para o menu principal");
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
                    register();

                    break;

                case 2:
                    delete();
                    break;

                case 3:
                    update();
                    break;

                case 4:
                    querryById();
                    break;
                case 5:
                    querryAll();
                    break;

                default:
                    break;
            }
            if (optionInt != 6) {
                optionInt = 0;
            }
        } while (optionInt != 6);
    }

    public void register() {
        RepositoryEmpresa.getInstance().addElement(getEmpresaInfo());
    }

    private Empresa getEmpresaInfo() {
        Empresa newEmpresa = new Empresa();
        newEmpresa.setId(Long.valueOf((RepositoryEmpresa.getInstance().getLastIndex() + 1)));
        getInstituicaoInfo(newEmpresa);
        System.out.println("Informe o ramo");
        newEmpresa.setRamo(scan.nextLine());
        return newEmpresa;
    }

    public void delete() {
        Utils.clearTerminal();
        System.out.println("Informe o id do Empresa");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Empresa Empresa = getEmpresa(optionLong);
            if (Empresa == null) {
                System.out.println("Empresa não encontrado");
            } else {
                Boolean result = RepositoryEmpresa.getInstance().deleteElement(Empresa);
                if (result) {
                    System.out.println("Empresa Deletado com sucesso");
                } else {
                    System.out.println("Problema no Sistema, tente novamente mais tarde!");
                }

            }

        } catch (Exception e) {
            System.out.println("Opção inválida!");
            delete();
        }

    }

    public void update() {
        Utils.clearTerminal();
        System.out.println("Informe o id do Empresa");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Empresa Empresa = getEmpresa(optionLong);
            if (Empresa == null) {
                System.out.println("Empresa não encontrado");
            } else {
                Empresa newEmpresa = getEmpresaInfo();
                newEmpresa.setId(Empresa.getId());
                Boolean result = RepositoryEmpresa.getInstance().updateElement(optionLong, newEmpresa);
                if (result) {
                    System.out.println("Empresa Atualizado com sucesso");
                } else {
                    System.out.println("Problema no Sistema, tente novamente mais tarde!");
                }

            }
        } catch (Exception e) {
            System.out.println("Opção inválida!");
            update();
        }

    }

    public void querryById() {
        Utils.clearTerminal();
        System.out.println("Informe o id do Empresa");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Empresa Empresa = getEmpresa(optionLong);
            if (Empresa == null) {
                System.out.println("Empresa não encontrado");
            } else {
                System.out.println(Empresa.toString());
            }

        } catch (Exception e) {
            System.out.println("Opção inválida!");
            querryById();
        }

    }

    private Empresa getEmpresa(Long id) {
        return RepositoryEmpresa.getInstance().findElementById(id);
    }

    public void querryAll() {
        List<Empresa> Empresas = RepositoryEmpresa.getInstance().findAllElements();
        if (Empresas.isEmpty()) {
            System.out.println("Nenhum Empresa cadastrado!");
        } else {
            Empresas.forEach(Empresa -> {
                System.out.println(Empresa.toString());
            });
        }

    }
}
