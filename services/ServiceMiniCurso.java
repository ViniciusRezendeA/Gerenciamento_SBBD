package services;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import models.MiniCurso;
import repositories.RepositoryMiniCurso;
import util.Utils;

public class ServiceMiniCurso implements IService {

    private Scanner scan = new Scanner(System.in);;

    @Override
    public void menuInicial() {
        int optionInt = 0;

        do {
            if (scan.nextLine() == "\n" || optionInt == 0) {
                Utils.clearTerminal();
                Utils.printMenuTitle("Menu da MiniCurso");
                System.out.println("1 - cadastrar MiniCurso");
                System.out.println("2 - Deletar MiniCurso");
                System.out.println("3 - atualizar MiniCurso");
                System.out.println("4 - Buscar MiniCurso");
                System.out.println("5 - Mostrar todas as miniCursos");
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
        RepositoryMiniCurso.getInstance().addElement(getMiniCursoInfo());
    }

    @Override
    public void update() {
        Utils.clearTerminal();
        System.out.println("Informe o id do MiniCurso");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            MiniCurso miniCurso = RepositoryMiniCurso.getInstance().findElementById(optionLong);
            if (miniCurso == null) {
                System.out.println("MiniCurso não encontrado");
            } else {
                MiniCurso newMiniCursos = getMiniCursoInfo();
                newMiniCursos.setId(miniCurso.getId());

                Boolean result = RepositoryMiniCurso.getInstance().updateElement(optionLong, newMiniCursos);
                if (result) {
                    System.out.println("MiniCurso Atualizado com sucesso");
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
        System.out.println("Informe o id da MiniCurso");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            MiniCurso miniCurso = RepositoryMiniCurso.getInstance().findElementById(optionLong);
            if (miniCurso == null) {
                System.out.println("MiniCurso não encontrada");
            } else {
                Boolean result = RepositoryMiniCurso.getInstance().deleteElement(miniCurso);
                if (result) {
                    System.out.println("MiniCurso Deletado com sucesso");
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
        List<MiniCurso> miniCursos = RepositoryMiniCurso.getInstance().findAllElements();
        if (miniCursos.isEmpty()) {
            System.out.println("Nenhum miniCurso cadastrado!");
        } else {
            miniCursos.forEach(miniCurso -> {
                System.out.println(miniCurso.toString());
            });
        }
    }

    @Override
    public void querryById() {
        Utils.clearTerminal();
        System.out.println("Informe o id da MiniCurso");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            MiniCurso miniCurso = RepositoryMiniCurso.getInstance().findElementById(optionLong);
            if (miniCurso == null) {
                System.out.println("MiniCurso não encontrado");
            } else {
                System.out.println(miniCurso.toString());
            }

        } catch (Exception e) {
            System.out.println("Opção inválida!");
            scan.nextLine();
            querryById();
        }
    }

    private MiniCurso getMiniCursoInfo() {
        MiniCurso newMiniCursos = new MiniCurso();
        Utils.clearTerminal();
        newMiniCursos.setId(Long.valueOf(RepositoryMiniCurso.getInstance().getLastIndex() + 1));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");

        System.out.println("Informe a data no formato (yyyy-MM-dd): ");
        Date data = null;
        try {
            data = (Date) sdf.parse(scan.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Informe o horario de inicio no formato (HH:mm): ");
        Time horarioInicio = null;
        try {
            horarioInicio = (Time) sdf.parse(scan.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Informe o horario de termino no formato (HH:mm): ");
        Time horarioFim = null;
        try {
            horarioFim = (Time) sdfTime.parse(scan.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        newMiniCursos.setData(data);
        newMiniCursos.setHoraFim(horarioFim);       
        newMiniCursos.setHoraInicio(horarioInicio);



        return newMiniCursos;
    }
}
