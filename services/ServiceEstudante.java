package services;

import util.Utils;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import models.Estudante;
import repositories.RepositoryEstudante;

public class ServiceEstudante {
    private RepositoryEstudante repositoryEstudante = new RepositoryEstudante(null);
    private Scanner scan = new Scanner(System.in);

    public void menuInicial() {

        Utils.printMenuTitle("Menu do Estudante");
        System.out.println("1 - cadastrar Estudante");
        System.out.println("2 - Deletar Estudante");
        System.out.println("3 - atualizar Estudante");
        System.out.println("4- Buscar Estudante");
        System.out.println("5 - Mostrar todos os estudantes");
        System.out.println("6 - Voltar para o menu principal");

        String option = scan.nextLine();
        int optionInt = 6;
        try {
            optionInt = Integer.parseInt(option);
        } catch (Exception e) {
            Utils.invalidOption();
            menuInicial();
        }
        if (optionInt > 5) {
            Utils.invalidOption();
            menuInicial();
        }
        switch (optionInt) {
            case 1:
                cadastrarEstudande();
                break;

            case 2:
                deletarEstudante();
                break;

            case 3:

                break;

            case 4:
                buscarEstudante();
                break;
            case 5:

                break;

            default:
                break;
        }
    }

    private void cadastrarEstudande() {
        Estudante newEstudante = new Estudante();
        Utils.clearTerminal();

        newEstudante.setId(Long.valueOf(repositoryEstudante.getAmountOfElements() + 1));
        newEstudante.setCodigoDePesoa(newEstudante.getId());
        System.out.println("Informe o nome do Estudante");
        newEstudante.setNome(scan.nextLine());
        System.out.println("Informe a data de nascimento do " + newEstudante.getNome());
        newEstudante.setDataNascimento(LocalDate.parse(scan.nextLine()));
         System.out.println("Informe o curso do " + newEstudante.getNome());
        newEstudante.setCurso(scan.nextLine());
        repositoryEstudante.addElement(newEstudante);
    }

    private void deletarEstudante() {
        Utils.clearTerminal();
        System.out.println("Informe o id do Estudante");
        String option = scan.nextLine();
        Long optionLong = 0L;
        try {
            optionLong = Long.parseLong(option);
        } catch (Exception e) {
            Utils.invalidOption();
            deletarEstudante();
        }
        Estudante estudante = getEstudante(optionLong);
        repositoryEstudante.deleteElement(estudante);
    }

    private void buscarEstudante() {
        Utils.clearTerminal();
        System.out.println("Informe o id do Estudante");
        String option = scan.nextLine();
        Long optionInt = 0L;
        try {
            optionInt = Long.parseLong(option);
        } catch (Exception e) {
            Utils.invalidOption();
            buscarEstudante();
        }
        Estudante estudante = getEstudante(optionInt);
        estudante.toString();
    }

    private Estudante getEstudante(Long id) {
        return repositoryEstudante.findElementById(id);
    }

    private void mostrarTodosEstudantes() {
        List<Estudante> estudantes = repositoryEstudante.findAllElements();
        estudantes.forEach(estudante -> {
            estudante.toString();
        });
    }
}
