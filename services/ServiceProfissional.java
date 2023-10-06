package services;

import java.util.List;

import models.Profissional;
import repositories.RepositoryProfissional;
import util.Utils;

public class ServiceProfissional extends ServicePessoa implements IService {

    public void menuInicial() {
        int optionInt = 0;

        do {
            if (scan.nextLine() == "\n" || optionInt == 0) {
                Utils.clearTerminal();
                Utils.printMenuTitle("Menu do Profissional");
                System.out.println("1 - cadastrar Profissional");
                System.out.println("2 - Deletar Profissional");
                System.out.println("3 - atualizar Profissional");
                System.out.println("4 - Buscar Profissional");
                System.out.println("5 - Mostrar todos os Profissionals");
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
                    if (repositoryEmpresa.findAllElements().isEmpty()
                            && repositoryUniversidade.findAllElements().isEmpty()) {
                        System.out.println("Cadastre uma Empresa ou Universidade!");
                        System.out.println("Pressione enter para continuar...");
                    } else {
                        register();
                    }
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
        RepositoryProfissional.getInstance().addElement(getProfissionalInfo());
    }

    private Profissional getProfissionalInfo() {
        Profissional newProfissional = new Profissional();
        newProfissional.setId(Long.valueOf((RepositoryProfissional.getInstance().getLastIndex() + 1)));
        getPessoaInfo(newProfissional);
        newProfissional.setSalario(getSalario(newProfissional));
        return newProfissional;
    }

    private Double getSalario(Profissional newProfissional) {
        System.out.println("Informe o salario do " + newProfissional.getNome());
        try {
            return Double.parseDouble(scan.nextLine());
        } catch (Exception e) {
            System.out.println("Opção inválida!");
            getSalario(newProfissional);
            return null;
        }
    }

    public void delete() {
        Utils.clearTerminal();
        System.out.println("Informe o id do Profissional");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Profissional Profissional = getProfissional(optionLong);
            if (Profissional == null) {
                System.out.println("Profissional não encontrado");
            } else {
                Boolean result = RepositoryProfissional.getInstance().deleteElement(Profissional);
                if (result) {
                    System.out.println("Profissional Deletado com sucesso");
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
        System.out.println("Informe o id do Profissional");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Profissional Profissional = getProfissional(optionLong);
            if (Profissional == null) {
                System.out.println("Profissional não encontrado");
            } else {
                Profissional newProfissional = getProfissionalInfo();
                newProfissional.setId(Profissional.getId());
                newProfissional.setCodigoDePesoa(Profissional.getCodigoDePesoa());

                Boolean result = RepositoryProfissional.getInstance().updateElement(optionLong, newProfissional);
                if (result) {
                    System.out.println("Profissional Atualizado com sucesso");
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
        System.out.println("Informe o id do Profissional");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Profissional Profissional = getProfissional(optionLong);
            if (Profissional == null) {
                System.out.println("Profissional não encontrado");
            } else {
                System.out.println(Profissional.toString());
            }

        } catch (Exception e) {
            System.out.println("Opção inválida!");
            querryById();
        }

    }

    private Profissional getProfissional(Long id) {
        return RepositoryProfissional.getInstance().findElementById(id);
    }

    public void querryAll() {
        List<Profissional> Profissionals = RepositoryProfissional.getInstance().findAllElements();
        if (Profissionals.isEmpty()) {
            System.out.println("Nenhum Profissional cadastrado!");
        } else {
            Profissionals.forEach(Profissional -> {
                System.out.println(Profissional.toString());
            });
        }

    }
}
