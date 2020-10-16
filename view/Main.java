package view;

import util.Inicializador;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static Inicializador inicializador = new Inicializador();

    public static void main(String[] args) {
        inicializador.iniciarPrograma();
        telaInicial();
    }

    private static void telaInicial() {
        System.out.println("\n------------ RAPPI ------------");
        Menus menus = new Menus();
        menus.telaPrincipal();
    }
}
