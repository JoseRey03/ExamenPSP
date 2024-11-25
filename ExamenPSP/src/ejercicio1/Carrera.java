package ejercicio1;

public class Carrera {
    public static void main(String[] args) throws InterruptedException {
        int distancia = 10; // Distancia de la carrera en metros
        int posicionConejo = 0; //Esta es la posicion del conejo
        int posicionTortuga = 0; //Esta es la posicion de la tortuga

        // Usamos dos hilos para simular que ambos avanzan de forma independiente
        Thread conejo = new Thread(() -> {
            try {
                for (int i = 1; i <= distancia; i++) {
                    System.out.println("Conejo: Metro " + i);
                    Thread.sleep(1000); // Avanza 1 metro por segundo
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread tortuga = new Thread(() -> {
            try {
                for (int i = 1; i <= distancia; i++) {
                    System.out.println("Tortuga: Metro " + i);
                    Thread.sleep(5000); // Avanza 1 metro cada 5 segundos
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //Con este codigo se inicia los hilos
        conejo.start();
        tortuga.start();

        //Y con este se espera a que ambos terminen
        conejo.join();
        tortuga.join();
    }
}


//Apartado B:
//Tendrias que utilizar tortuga.join() porque obliga al programa a esperar a que el hilo de la tortuga acabe.
//Debe colocarse después de iniciar el hilo de la tortuga con tortuga.start() y antes de iniciar el hilo del conejo con conejo.start().
