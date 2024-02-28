/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nuevo;

import java.util.Scanner;

/**
 *
 * @author DavidSJ
 */
public class Nuevo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        System.out.println("Ingrese los numeros separados por espacios:");
        String input = scanner.nextLine();
        String[] numeros = input.split(" ");

        for (String numero : numeros) {
            lista.agregarAlFinal(Integer.parseInt(numero));
        }

        System.out.println("Lista Original:");
        lista.imprimirLista();
        lista.removerLista();
        System.out.println("Lista Removida:");
        lista.imprimirLista();
    }
    
}
