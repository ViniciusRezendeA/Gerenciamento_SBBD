package services;

import util.Utils;

import java.util.List;

import models.Estudante;
import models.Instituicao;
import repositories.RepositoryEstudante;

public class ServiceEstudante extends ServicePessoa implements IService {


    public void menuInicial() {
        int optionInt = 0;

        do {
            if (scan.nextLine() == "\n" || optionInt == 0) {
                Utils.clearTerminal();
                Utils.printMenuTitle("Menu do Estudante");
                System.out.println("1 - cadastrar Estudante");
                System.out.println("2 - Deletar Estudante");
                System.out.println("3 - atualizar Estudante");
                System.out.println("4 - Buscar Estudante");
                System.out.println("5 - Mostrar todos os estudantes");
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
        scan.close();
    }

    public void register() {
        RepositoryEstudante.getInstance().addElement(getEstudanteInfo());
    }

    private Estudante getEstudanteInfo() {

        Estudante newEstudante = new Estudante();
        Utils.clearTerminal();
        getPessoaInfo(newEstudante);
        newEstudante.setId(Long.valueOf(RepositoryEstudante.getInstance().getLastIndex() + 1));
        System.out.println("Informe o curso do " + newEstudante.getNome());
        newEstudante.setCurso(scan.nextLine());
        setInstituicao(newEstudante);

        return newEstudante;
    }

    private void setInstituicao(Estudante estudante) {
        Instituicao instituicao = null;
        System.out.println("Informe a Instituição do " + estudante.getNome());
        Long idInstituicaLong = Long.getLong(scan.nextLine());
        if (repositoryEmpresa.findElementById(idInstituicaLong) != null) {
            instituicao = repositoryEmpresa.findElementById(idInstituicaLong);
        } else if (repositoryUniversidade.findElementById(idInstituicaLong) != null) {
            instituicao = repositoryUniversidade.findElementById(idInstituicaLong);
        } else {
            System.out.println("instituição não encontrada!");
            setInstituicao(estudante);
        }
        if (instituicao != null) {
            estudante.setInstituicao(instituicao);
        }
    }

    public void delete() {
        Utils.clearTerminal();
        System.out.println("Informe o id do Estudante");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Estudante estudante = getEstudante(optionLong);
            if (estudante == null) {
                System.out.println("Estudante não encontrado");
            } else {
                Boolean result = RepositoryEstudante.getInstance().deleteElement(estudante);
                if (result) {
                    System.out.println("Estudante Deletado com sucesso");
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
        System.out.println("Informe o id do Estudante");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Estudante estudante = getEstudante(optionLong);
            if (estudante == null) {
                System.out.println("Estudante não encontrado");
            } else {
                Estudante newEstudante = getEstudanteInfo();
                newEstudante.setId(estudante.getId());
                newEstudante.setCodigoDePesoa(estudante.getCodigoDePesoa());

                Boolean result = RepositoryEstudante.getInstance().updateElement(optionLong, newEstudante);
                if (result) {
                    System.out.println("Estudante Atualizado com sucesso");
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
        System.out.println("Informe o id do Estudante");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Estudante estudante = getEstudante(optionLong);
            if (estudante == null) {
                System.out.println("Estudante não encontrado");
            } else {
                System.out.println(estudante.toString());
            }

        } catch (Exception e) {
            System.out.println("Opção inválida!");
            querryById();
        }

    }

    private Estudante getEstudante(Long id) {
        return RepositoryEstudante.getInstance().findElementById(id);
    }

    public void querryAll() {
        List<Estudante> estudantes = RepositoryEstudante.getInstance().findAllElements();
        if (estudantes.isEmpty()) {
            System.out.println("Nenhum estudante cadastrado!");
        } else {
            estudantes.forEach(estudante -> {
                System.out.println(estudante.toString());
            });
        }

    }
}
