package services;

import java.util.List;
import java.util.Scanner;

import models.Trabalho;
import repositories.RepositoryTr
import repositories.RepositoryTrabalho;aRepositoryTrabalho;
import util.Utils;

public class ServiceTrabalho implements IService {

    private Scanner scan = new Scanner(System.in);;

    @Override
    public void menuInicial() {
        int optionInt = 0;

        do {
            if (scan.nextLine() == "\n" || optionInt == 0) {
                Utils.clearTerminal();
                Utils.printMenuTitle("Menu do Trabalho");
                System.out.println("1 - cadastrar Trabalho");
                System.out.println("2 - Deletar Trabalho");
                System.out.println("3 - atualizar Trabalho");
                System.out.println("4 - Buscar Trabalho");
                System.out.println("5 - Mostrar todos os trabalhos");
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

    @Override
    public void register() {
        RepositoryTrabalho.getInstance().addElement(getSalaInfo());
    }

    @Override
    public void update() {
        Utils.clearTerminal();
        System.out.println("Informe o id do Trabalho");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Trabalho trabalho = RepositoryTrabalho.getInstance().findElementById(optionLong);
            if (trabalho == null) {
                System.out.println("Trabalho não encontrado");
            } else {
                Trabalho newTrabalho = getSalaInfo();
                newTrabalho.setId(trabalho.getId());

                Boolean result = RepositoryTrabalho.getInstance().updateElement(optionLong, newTrabalho);
                if (result) {
                    System.out.println("Trabalho Atualizado com sucesso");
                } else {
                    System.out.println("Problema no Sistema, tente novamente mais tarde!");
                }

            }
        } catch (Exception e) {
            System.out.println("Opção inválida!");
            update();
        }
    }

    @Override
    public void delete() {
        Utils.clearTerminal();
        System.out.println("Informe o id da Trabalho");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Trabalho trabalho = RepositoryTrabalho.getInstance().findElementById(optionLong);
            if (trabalho == null) {
                System.out.println("Trabalho não encontrada");
            } else {
                Boolean result = RepositoryTrabalho.getInstance().deleteElement(trabalho);
                if (result) {
                    System.out.println("Trabalho Deletado com sucesso");
                } else {
                    System.out.println("Problema no Sistema, tente novamente mais tarde!");
                }

            }

        } catch (Exception e) {
            System.out.println("Opção inválida!");
            delete();
        }
    }

    @Override
    public void querryAll() {
        List<Trabalho> trabalhos = RepositoryTrabalho.getInstance().findAllElements();
        if (trabalhos.isEmpty()) {
            System.out.println("Nenhum trabalho cadastrado!");
        } else {
            trabalhos.forEach(trabalho -> {
                System.out.println(trabalho.toString());
            });
        }
    }

    @Override
    public void querryById() {
        Utils.clearTerminal();
        System.out.println("Informe o id da Trabalho");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Trabalho trabalho = RepositoryTrabalho.getInstance().findElementById(optionLong);
            if (trabalho == null) {
                System.out.println("Trabalho não encontrado");
            } else {
                System.out.println(trabalho.toString());
            }

        } catch (Exception e) {
            System.out.println("Opção inválida!");
            scan.nextLine();
            querryById();
        }
    }

    private Trabalho getTrabalhoInfo() {
        Trabalho newTrabalho = new Trabalho();
        Utils.clearTerminal();
        newTrabalho.setId(Long.valueOf(RepositoryTrabalho.getInstance().getAmountOfElements() + 1));

        System.out.println("Informe o titulo do trabalho: ");
        String titulo = scan.nextLine();
        System.out.println("Informe o resumo do trabalho: ");
        String resumo = scan.nextLine();

        newTrabalho.setTituto(titulo);
        newTrabalho.setResumo(resumo);

        return newTrabalho;
    }
}
