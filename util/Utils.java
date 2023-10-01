package util;


import java.io.IOException;

public class Utils {

    public static void printDynamicLine() {
        int width = 80;
        System.out.println(new String(new char[width]).replace('\0', '-'));
    }

    public static void clearTerminal() {
        String os = System.getProperty("os.name").toLowerCase();

        try {
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pauseTerminal() {
        printDynamicLine();
        System.out.println('\n');
        System.out.println("Pressione enter para continuar...");
        try {
            while (System.in.read() != '\n') {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void invalidOption() {
        clearTerminal();
        System.out.println("Opção inválida!");
        System.out.println("Pressione enter para continuar...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param title title string to be displayed
     */
    public static void printMenuTitle(String title) {
        clearTerminal();
        printDynamicLine();
        int totalWidth = 80;
        int paddingSize = (totalWidth - title.length()) / 2;

        int paddingLeft = paddingSize;
        int paddingRight = totalWidth - title.length() - paddingLeft;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paddingLeft; i++) {
            sb.append(' ');
        }
        sb.append(title);
        for (int i = 0; i < paddingRight; i++) {
            sb.append(' ');
        }
        System.out.println(sb.toString());
        printDynamicLine();
    }

}
