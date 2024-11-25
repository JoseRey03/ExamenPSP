package ejercicioelegido;

import java.util.Scanner;

public class SumaConHilos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Con este codigo solicitas al usuario el rango de números
        System.out.print("Introduce el inicio del rango a sumar: ");
        int inicio = scanner.nextInt();

        System.out.print("Introduce el fin del rango a sumar: ");
        int fin = scanner.nextInt();

        //Aqui calculas la división del rango entre los 3 hilos
        int totalNumeros = fin - inicio + 1;
        int tamañoRango = totalNumeros / 3;

        //Con este codigo creas objetos para almacenar resultados parciales
        ResultadoParcial[] resultados = new ResultadoParcial[3];
        for (int i = 0; i < 3; i++) {
            resultados[i] = new ResultadoParcial();
        }

        //Con esto se crea y se lanza los hilos
        Thread hilo1 = new HiloSuma(inicio, inicio + tamañoRango - 1, resultados[0], 1);
        Thread hilo2 = new HiloSuma(inicio + tamañoRango, inicio + 2 * tamañoRango - 1, resultados[1], 2);
        Thread hilo3 = new HiloSuma(inicio + 2 * tamañoRango, fin, resultados[2], 3);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        // Con esto esperas a que los hilos terminen
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Con sout imprimes la suma total
        int sumaTotal = resultados[0].getSuma() + resultados[1].getSuma() + resultados[2].getSuma();
        System.out.println("Suma total = " + sumaTotal);
    }
}

//Esta es la clase para almacenar el resultado de la suma parcial
class ResultadoParcial {
    private int suma;

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }
}


