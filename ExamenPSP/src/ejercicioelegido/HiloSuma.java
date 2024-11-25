package ejercicioelegido;

//Esta es la clase para realizar la suma en un rango
class HiloSuma extends Thread {
    private int inicio;
    private int fin;
    private ResultadoParcial resultado;
    private int numeroHilo; //Basicamente para poder nombrar los hilos

    public HiloSuma(int inicio, int fin, ResultadoParcial resultado, int numeroHilo) {
        this.inicio = inicio;
        this.fin = fin;
        this.resultado = resultado;
        this.numeroHilo = numeroHilo;
    }
//Para poder imprimir el numero del hilo y la suma parcial
    @Override
    public void run() {
        int suma = 0;
        for (int i = inicio; i <= fin; i++) {
            suma += i;
        }
        resultado.setSuma(suma);
        System.out.println("Hilo " + numeroHilo + ": Suma parcial = " + suma);
    }
}
