/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Random;

/**
 *
 * @author DavidSJ
 */
public class ListaSillas {
    private Nodo actual;
    private int cola;

    private class Nodo {
        Silla silla;
        Nodo siguiente;

        Nodo(Silla silla) {
            this.silla = silla;
            this.siguiente = null;
        }
    }

    public ListaSillas(int numSillas) {
        if (numSillas < 2) {
            System.out.print("El numero de sillas debe ser al menos 2.");
            System.exit(0);
        }

        this.cola = numSillas;
        this.actual = null;

        Nodo anterior = null;
        for (int i = 0; i < numSillas; i++) {
            Nodo nuevoNodo = new Nodo(new Silla());
            if (actual == null) {
                actual = nuevoNodo;
            } else {
                anterior.siguiente = nuevoNodo;
            }
            anterior = nuevoNodo;
        }
        anterior.siguiente = actual;
    }

    public int getCola() {
        return cola;
    }

    public void avanzar() {
        if (actual != null) {
            actual = actual.siguiente;
        }
    }

    public Silla ocuparSillaAleatoria() {
    if (cola > 0) {
        Random random = new Random();
        int pasos = random.nextInt(cola);
        for (int i = 0; i < pasos; i++) {
            avanzar();
        }
        Silla sillaEliminada = actual.silla;
        actual.silla.desocupar();
        eliminarNodo(actual);
        cola--;
        avanzar();
        return sillaEliminada;
    } else {
        System.out.println("No quedan sillas disponibles.");
    }
        return null;
}

    private void eliminarNodo(Nodo nodo) {
        if (actual == nodo) {
            actual = actual.siguiente;
        }
        Nodo temp = actual;
        while (temp.siguiente != nodo) {
            temp = temp.siguiente;
        }
        temp.siguiente = nodo.siguiente;
        nodo = null;
    }
}

