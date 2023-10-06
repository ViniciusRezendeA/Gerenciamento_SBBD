package services;

import java.util.List;

import models.Professor;
import repositories.RepositoryProfessor;
import util.Utils;

public class ServiceProfessor extends ServicePessoa implements IService {
    private RepositoryProfessor repositoryProfessor = RepositoryProfessor.getInstance();


    public void menuInicial() {
        int optionInt = 0;

        do {
            if (scan.nextLine() == "\n" || optionInt == 0) {
                Utils.clearTerminal();
                Utils.printMenuTitle("Menu do Professor");
                System.out.println("1 - cadastrar Professor");
                System.out.println("2 - Deletar Professor");
                System.out.println("3 - atualizar Professor");
                System.out.println("4- Buscar Professor");
                System.out.println("5 - Mostrar todos os Professors");
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
        repositoryProfessor.addElement(getProfessorInfo());
    }

    private Professor getProfessorInfo() {
        Professor newProfessor = new Professor();
        newProfessor.setId(Long.valueOf((repositoryProfessor.getAmountOfElements() + 1)));
        getPessoaInfo(newProfessor);
        System.out.println("Informe o nome do Departamento");
        newProfessor.setDepartamento(scan.nextLine());
        newProfessor.setSalario(getSalario(newProfessor));
        return newProfessor;
    }

    private Double getSalario(Professor newProfessor) {
        System.out.println("Informe o salario do " + newProfessor.getNome());
        try {
            return Double.parseDouble(scan.nextLine());
        } catch (Exception e) {
            System.out.println("Opção inválida!");
            getSalario(newProfessor);
            return null;
        }
    }

    public void delete() {
        Utils.clearTerminal();
        System.out.println("Informe o id do Professor");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Professor Professor = getProfessor(optionLong);
            if (Professor == null) {
                System.out.println("Professor não encontrado");
            } else {
                Boolean result = repositoryProfessor.deleteElement(Professor);
                if (result) {
                    System.out.println("Professor Deletado com sucesso");
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
        System.out.println("Informe o id do Professor");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Professor Professor = getProfessor(optionLong);
            if (Professor == null) {
                System.out.println("Professor não encontrado");
            } else {
                Professor newProfessor = getProfessorInfo();
                newProfessor.setId(Professor.getId());
                newProfessor.setCodigoDePesoa(Professor.getCodigoDePesoa());

                Boolean result = repositoryProfessor.updateElement(optionLong, newProfessor);
                if (result) {
                    System.out.println("Professor Atualizado com sucesso");
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
        System.out.println("Informe o id do Professor");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Professor Professor = getProfessor(optionLong);
            if (Professor == null) {
                System.out.println("Professor não encontrado");
            } else {
                System.out.println(Professor.toString());
            }

        } catch (Exception e) {
            System.out.println("Opção inválida!");
            querryById();
        }

    }

    private Professor getProfessor(Long id) {
        return repositoryProfessor.findElementById(id);
    }

    public void querryAll() {
        List<Professor> Professors = repositoryProfessor.findAllElements();
        if (Professors.isEmpty()) {
            System.out.println("Nenhum Professor cadastrado!");
        } else {
            Professors.forEach(Professor -> {
                System.out.println(Professor.toString());
            });
        }

    }
}
