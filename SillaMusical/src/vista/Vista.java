/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Jugador;
import modelo.ListaSillas;
import modelo.Silla;

/**
 *
 * @author DavidSJ
 */
public class Vista {
    private Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int obtenerNumeroJugadores() {
        System.out.print("Ingrese el numero de jugadores: ");
        return scanner.nextInt();
    }

    public void mostrarEstadoJuego(int numSillas, List<Jugador> jugadores) {
        mostrarMensaje("Quedan " + numSillas + " sillas.");
        mostrarMensaje("Jugadores restantes:");
        for (Jugador jugador : jugadores) {
            mostrarMensaje("- " + jugador.getNombre());
        }
    }

    public void mostrarFinJuego(String nombreGanador) {
        mostrarMensaje("Fin del juego! El ganador es: " + nombreGanador);
    }

    public void mostrarJugadorEliminado(String nombreJugador) {
        mostrarMensaje("El jugador " + nombreJugador + " se ha quedado sin silla.");
    }
    
    public String obtenerNombre() {
        System.out.print("Ingrese su nombre: ");
        return scanner.nextLine().trim();
    } 
    
}
