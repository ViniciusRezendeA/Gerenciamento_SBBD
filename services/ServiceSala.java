package services;

import java.util.List;
import java.util.Scanner;

import models.Sala;
import repositories.RepositorySala;
import util.Utils;

public class ServiceSala implements IService {

    private Scanner scan = new Scanner(System.in);;

    @Override
    public void menuInicial() {
        int optionInt = 0;

        do {
            if (scan.nextLine() == "\n" || optionInt == 0) {
                Utils.clearTerminal();
                Utils.printMenuTitle("Menu da Sala");
                System.out.println("1 - cadastrar Sala");
                System.out.println("2 - Deletar Sala");
                System.out.println("3 - atualizar Sala");
                System.out.println("4 - Buscar Sala");
                System.out.println("5 - Mostrar todas as salas");
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
        RepositorySala.getInstance().addElement(getSalaInfo());
    }

    @Override
    public void update() {
        Utils.clearTerminal();
        System.out.println("Informe o id do Sala");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Sala sala = RepositorySala.getInstance().findElementById(optionLong);
            if (sala == null) {
                System.out.println("Sala não encontrado");
            } else {
                Sala newSala = getSalaInfo();
                newSala.setId(sala.getId());

                Boolean result = RepositorySala.getInstance().updateElement(optionLong, newSala);
                if (result) {
                    System.out.println("Sala Atualizado com sucesso");
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
        System.out.println("Informe o id da Sala");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Sala sala = RepositorySala.getInstance().findElementById(optionLong);
            if (sala == null) {
                System.out.println("Sala não encontrada");
            } else {
                Boolean result = RepositorySala.getInstance().deleteElement(sala);
                if (result) {
                    System.out.println("Sala Deletado com sucesso");
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
        List<Sala> salas = RepositorySala.getInstance().findAllElements();
        if (salas.isEmpty()) {
            System.out.println("Nenhum sala cadastrado!");
        } else {
            salas.forEach(sala -> {
                System.out.println(sala.toString());
            });
        }
    }

    @Override
    public void querryById() {
        Utils.clearTerminal();
        System.out.println("Informe o id da Sala");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Sala sala = RepositorySala.getInstance().findElementById(optionLong);
            if (sala == null) {
                System.out.println("Sala não encontrado");
            } else {
                System.out.println(sala.toString());
            }

        } catch (Exception e) {
            System.out.println("Opção inválida!");
            scan.nextLine();
            querryById();
        }
    }

    private Sala getSalaInfo() {
        Sala newSala = new Sala();
        Utils.clearTerminal();
        newSala.setId(Long.valueOf(RepositorySala.getInstance().getLastIndex() + 1));

        System.out.println("Informe o codigo da sala: ");
        int codigo = scan.nextInt();
        System.out.println("Informe o id do predio da sala: ");
        int idPredio = scan.nextInt();

        newSala.setCodigo(codigo);
        newSala.setIdPredio(idPredio);

        return newSala;
    }
}
