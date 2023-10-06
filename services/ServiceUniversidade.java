package services;

import java.util.List;

import models.Universidade;
import repositories.RepositoryUniversidade;
import util.Utils;

public class ServiceUniversidade extends ServiceInstituicao implements IService {
    private RepositoryUniversidade repositoryUniversidade = RepositoryUniversidade.getInstance();

    public void menuInicial() {
        int optionInt = 0;

        do {
            if (scan.nextLine() == "\n" || optionInt == 0) {
                Utils.clearTerminal();
                Utils.printMenuTitle("Menu do Universidade");
                System.out.println("1 - cadastrar Universidade");
                System.out.println("2 - Deletar Universidade");
                System.out.println("3 - atualizar Universidade");
                System.out.println("4- Buscar Universidade");
                System.out.println("5 - Mostrar todos os Universidades");
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
        scan.close();
    }

    public void register() {
        repositoryUniversidade.addElement(getUniversidadeInfo());
    }

    private Universidade getUniversidadeInfo() {
        Universidade newUniversidade = new Universidade();
        newUniversidade.setId(Long.valueOf((repositoryUniversidade.getAmountOfElements() + 1)));
        getInstituicaoInfo(newUniversidade);
        System.out.println("Informe o Reitor");
        newUniversidade.setReitor(scan.nextLine());
        registerCursos(newUniversidade);
        return newUniversidade;
    }

    public void registerCursos(Universidade universidade) {
        String cargo;
        do {
            Utils.clearTerminal();
            System.out.println("Informe o curso desejado(para sair escrava finalizar)");
            cargo = scan.nextLine();
            if (cargo.toLowerCase() != "finalizar") {
                universidade.addCargos(cargo);
            }
        } while (cargo.toLowerCase() != "finalizar");
    }

    public void delete() {
        Utils.clearTerminal();
        System.out.println("Informe o id do Universidade");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Universidade Universidade = getUniversidade(optionLong);
            if (Universidade == null) {
                System.out.println("Universidade não encontrado");
            } else {
                Boolean result = repositoryUniversidade.deleteElement(Universidade);
                if (result) {
                    System.out.println("Universidade Deletado com sucesso");
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
        System.out.println("Informe o id do Universidade");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Universidade Universidade = getUniversidade(optionLong);
            if (Universidade == null) {
                System.out.println("Universidade não encontrado");
            } else {
                Universidade newUniversidade = getUniversidadeInfo();
                newUniversidade.setId(Universidade.getId());
                Boolean result = repositoryUniversidade.updateElement(optionLong, newUniversidade);
                if (result) {
                    System.out.println("Universidade Atualizado com sucesso");
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
        System.out.println("Informe o id do Universidade");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Universidade Universidade = getUniversidade(optionLong);
            if (Universidade == null) {
                System.out.println("Universidade não encontrado");
            } else {
                System.out.println(Universidade.toString());
            }

        } catch (Exception e) {
            System.out.println("Opção inválida!");
            querryById();
        }

    }

    private Universidade getUniversidade(Long id) {
        return repositoryUniversidade.findElementById(id);
    }

    public void querryAll() {
        List<Universidade> Universidades = repositoryUniversidade.findAllElements();
        if (Universidades.isEmpty()) {
            System.out.println("Nenhum Universidade cadastrado!");
        } else {
            Universidades.forEach(Universidade -> {
                System.out.println(Universidade.toString());
            });
        }

    }
}
