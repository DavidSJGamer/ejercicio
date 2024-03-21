/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Jugador;
import modelo.ListaSillas;
import modelo.Silla;
import vista.Vista;

/**
 *
 * @author DavidSJ
 */
public class Controlador {

    private ListaSillas listaSillas;
    private Vista vista;
    private List<Jugador> jugadores;

    public Controlador() {
        vista = new Vista();
    }

    public void iniciarJuego() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        vista.mostrarMensaje("Bienvenido al juego de la silla musical.");
        vista.mostrarMensaje("Por favor, ingrese los nombres de los jugadores (ingrese 'iniciar' para iniciar el juego):");

        jugadores = new ArrayList<>();
        String nombre;
        do
        {
            vista.mostrarMensaje("Nombre del jugador:");
            nombre = scanner.nextLine();
            if (!nombre.equalsIgnoreCase("iniciar"))
            {
                jugadores.add(new Jugador(nombre));
            }
        } while (!nombre.equalsIgnoreCase("iniciar"));

        int numSillas = jugadores.size() - 1; 
        listaSillas = new ListaSillas(numSillas);

        while (!jugadores.isEmpty() && listaSillas.getCola() > 0)
        {
            vista.mostrarMensaje("Comienza una ronda del juego de la silla musical con " + jugadores.size() + " jugadores y " + numSillas + " sillas:");

            while (listaSillas.getCola() > 0)
            { 
                vista.mostrarEstadoJuego(listaSillas.getCola(), jugadores);
                vista.mostrarMensaje("La musica suena! Los jugadores estan caminando...");

                simularMovimientoJugadores();

                vista.mostrarMensaje("La musica se detiene!");
                eliminarJugador();
            }

            if (!jugadores.isEmpty())
            {
                Jugador ganadorRonda = jugadores.remove(0);
                vista.mostrarMensaje("El ganador de esta ronda es: " + ganadorRonda.getNombre());
            }

            numSillas = jugadores.size() - 1;
            listaSillas = new ListaSillas(numSillas);
        }

        if (jugadores.isEmpty())
        {
            vista.mostrarFinJuego("No hay ganador. Todos los jugadores han sido eliminados.");
        } else
        {
            vista.mostrarFinJuego("No quedan sillas disponibles. El juego ha terminado.");
        }
    }

    private void simularMovimientoJugadores() throws InterruptedException {
        Thread.sleep(3000);
    }

    private void eliminarJugador() {
        int indiceJugador = (int) (Math.random() * jugadores.size());
        Jugador jugadorEliminado = jugadores.remove(indiceJugador);
        Silla sillaEliminada = listaSillas.ocuparSillaAleatoria();

        vista.mostrarJugadorEliminado(jugadorEliminado.getNombre());
    }
}
