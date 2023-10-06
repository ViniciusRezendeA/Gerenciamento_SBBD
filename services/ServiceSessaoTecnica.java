package services;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import models.Pessoa;
import models.SessaoTecnica;
import repositories.RepositoryApresentacao;
import repositories.RepositoryEstudante;
import repositories.RepositoryProfessor;
import repositories.RepositoryProfissional;
import repositories.RepositorySala;
import repositories.RepositorySessaoTecnica;
import util.Utils;

public class ServiceSessaoTecnica implements IService {

    private Scanner scan = new Scanner(System.in);;

    @Override
    public void menuInicial() {
        int optionInt = 0;

        do {
            if (scan.nextLine() == "\n" || optionInt == 0) {
                Utils.clearTerminal();
                Utils.printMenuTitle("Menu da SessaoTecnica");
                System.out.println("1 - cadastrar SessaoTecnica");
                System.out.println("2 - Deletar SessaoTecnica");
                System.out.println("3 - atualizar SessaoTecnica");
                System.out.println("4 - Buscar SessaoTecnica");
                System.out.println("5 - Mostrar todas as sessoesTecnicas");
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
                    if (RepositoryProfessor.getInstance().findAllElements().isEmpty() || 
                        RepositoryApresentacao.getInstance().findAllElements().isEmpty() ||
                        RepositorySala.getInstance().findAllElements().isEmpty()) {
                        System.out.println("Para cadastrar uma Sessão Tecnica é preciso antes cadastrar ao menos um professor, uma sala e uma apresentação!");

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

    @Override
    public void register() {
        RepositorySessaoTecnica.getInstance().addElement(getSessaoTecnicaInfo());
    }

    @Override
    public void update() {
        Utils.clearTerminal();
        System.out.println("Informe o id do SessaoTecnica");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            SessaoTecnica sessaoTecnica = RepositorySessaoTecnica.getInstance().findElementById(optionLong);
            if (sessaoTecnica == null) {
                System.out.println("SessaoTecnica não encontrado");
            } else {
                SessaoTecnica newSessoesTecnicas = getSessaoTecnicaInfo();
                newSessoesTecnicas.setId(sessaoTecnica.getId());

                Boolean result = RepositorySessaoTecnica.getInstance().updateElement(optionLong, newSessoesTecnicas);
                if (result) {
                    System.out.println("SessaoTecnica Atualizado com sucesso");
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
        System.out.println("Informe o id da SessaoTecnica");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            SessaoTecnica sessaoTecnica = RepositorySessaoTecnica.getInstance().findElementById(optionLong);
            if (sessaoTecnica == null) {
                System.out.println("SessaoTecnica não encontrada");
            } else {
                Boolean result = RepositorySessaoTecnica.getInstance().deleteElement(sessaoTecnica);
                if (result) {
                    System.out.println("SessaoTecnica Deletado com sucesso");
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
        List<SessaoTecnica> sessoesTecnicas = RepositorySessaoTecnica.getInstance().findAllElements();
        if (sessoesTecnicas.isEmpty()) {
            System.out.println("Nenhum sessaoTecnica cadastrado!");
        } else {
            sessoesTecnicas.forEach(sessaoTecnica -> {
                System.out.println(sessaoTecnica.toString());
            });
        }
    }

    @Override
    public void querryById() {
        Utils.clearTerminal();
        System.out.println("Informe o id da SessaoTecnica");
        String option = scan.nextLine();
        Long optionLong = Long.parseLong("0");
        try {
            optionLong = Long.parseLong(option);
            SessaoTecnica sessaoTecnica = RepositorySessaoTecnica.getInstance().findElementById(optionLong);
            if (sessaoTecnica == null) {
                System.out.println("SessaoTecnica não encontrado");
            } else {
                System.out.println(sessaoTecnica.toString());
            }

        } catch (Exception e) {
            System.out.println("Opção inválida!");
            scan.nextLine();
            querryById();
        }
    }

    private SessaoTecnica getSessaoTecnicaInfo() {
        SessaoTecnica newSessoesTecnicas = new SessaoTecnica();
        Utils.clearTerminal();
        newSessoesTecnicas.setId(Long.valueOf(RepositorySessaoTecnica.getInstance().getLastIndex() + 1));

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
            Date aux = sdfTime.parse(scan.nextLine());
            horarioInicio = new Time(aux.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Informe o horario de termino no formato (HH:mm): ");
        Time horarioFim = null;
        try {
            Date aux = sdfTime.parse(scan.nextLine());
            horarioFim = new Time(aux.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Informe o local da Sessao: ");
        String local = scan.nextLine();

        System.out.println("Informe o id do professor mediador: ");
        Long mediadorId = scan.nextLong();
        System.out.println("Informe os ids dos participantes (informe todos em uma mesma linha): ");
        String[] participantesIds = scan.nextLine().split(" ");
        System.out.println("Informe o id da apresentação: ");
        Long apresentacaoId = scan.nextLong();
        System.out.println("Informe o id da sala: ");
        Long salaId = scan.nextLong();

        newSessoesTecnicas.setData(data);
        newSessoesTecnicas.setHoraFim(horarioFim);
        newSessoesTecnicas.setHoraInicio(horarioInicio);
        newSessoesTecnicas.setLocal(local);

        newSessoesTecnicas.setMediador(RepositoryProfessor.getInstance().findElementById(mediadorId));
        newSessoesTecnicas.setApresentacao(RepositoryApresentacao.getInstance().findElementById(apresentacaoId));
        newSessoesTecnicas.setSala(RepositorySala.getInstance().findElementById(salaId));

        List<Pessoa> participantesList = new ArrayList<>();

        for (int i = 0; i < participantesIds.length; i++) {
            Pessoa buffer = null;

            buffer = RepositoryProfessor.getInstance().findElementById(Long.parseLong(participantesIds[i]));

            if (buffer == null)
                buffer = RepositoryEstudante.getInstance().findElementById(Long.parseLong(participantesIds[i]));

            if (buffer == null)
                buffer = RepositoryProfissional.getInstance().findElementById(Long.parseLong(participantesIds[i]));

            participantesList.add(buffer);

        }

        newSessoesTecnicas.setParticipantes(participantesList);

        return newSessoesTecnicas;
    }
}
