package services;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import models.Apresentacao;
import repositories.RepositoryApresentacao;
import util.Utils;

public class ServiceApresentacao implements IService {

    private Scanner scan = new Scanner(System.in);;

    @Override
    public void menuInicial() {
        int optionInt = 0;

        do {
            if (scan.nextLine() == "\n" || optionInt == 0) {
                Utils.clearTerminal();
                Utils.printMenuTitle("Menu da Apresentacao");
                System.out.println("1 - cadastrar Apresentacao");
                System.out.println("2 - Deletar Apresentacao");
                System.out.println("3 - atualizar Apresentacao");
                System.out.println("4 - Buscar Apresentacao");
                System.out.println("5 - Mostrar todas as apresentacoes");
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
        RepositoryApresentacao.getInstance().addElement(getApresentacaoInfo());
    }

    @Override
    public void update() {
        Utils.clearTerminal();
        System.out.println("Informe o id do Apresentacao");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Apresentacao sala = RepositoryApresentacao.getInstance().findElementById(optionLong);
            if (sala == null) {
                System.out.println("Apresentacao não encontrado");
            } else {
                Apresentacao newApresentacao = getApresentacaoInfo();
                newApresentacao.setId(sala.getId());

                Boolean result = RepositoryApresentacao.getInstance().updateElement(optionLong, newApresentacao);
                if (result) {
                    System.out.println("Apresentacao Atualizado com sucesso");
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
        System.out.println("Informe o id da Apresentacao");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Apresentacao sala = RepositoryApresentacao.getInstance().findElementById(optionLong);
            if (sala == null) {
                System.out.println("Apresentacao não encontrada");
            } else {
                Boolean result = RepositoryApresentacao.getInstance().deleteElement(sala);
                if (result) {
                    System.out.println("Apresentacao Deletado com sucesso");
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
        List<Apresentacao> apresentacoes = RepositoryApresentacao.getInstance().findAllElements();
        if (apresentacoes.isEmpty()) {
            System.out.println("Nenhum sala cadastrado!");
        } else {
            apresentacoes.forEach(sala -> {
                System.out.println(sala.toString());
            });
        }
    }

    @Override
    public void querryById() {
        Utils.clearTerminal();
        System.out.println("Informe o id da Apresentacao");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            Apresentacao sala = RepositoryApresentacao.getInstance().findElementById(optionLong);
            if (sala == null) {
                System.out.println("Apresentacao não encontrado");
            } else {
                System.out.println(sala.toString());
            }

        } catch (Exception e) {
            System.out.println("Opção inválida!");
            scan.nextLine();
            querryById();
        }
    }

    private Apresentacao getApresentacaoInfo() {
        Apresentacao newApresentacao = new Apresentacao();
        Utils.clearTerminal();
        newApresentacao.setId(Long.valueOf(RepositoryApresentacao.getInstance().getLastIndex() + 1));

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        System.out.println("Informe a hora da apresentacao no fomato (HH:mm): ");
        Time horaApresentacao = null;
        try {
            Date aux = sdf.parse(scan.nextLine());
            horaApresentacao = new Time(aux.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }


        System.out.println("Informe a duração da apresentação no fomato (HH:mm): ");
        Time duracaoApresentacao = null;
        try {
            Date aux = sdf.parse(scan.nextLine());
            duracaoApresentacao = new Time(aux.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        newApresentacao.setHoraApresentacao(horaApresentacao);
        newApresentacao.setDuracaoApresentacao(duracaoApresentacao);

        return newApresentacao;
    }
}
