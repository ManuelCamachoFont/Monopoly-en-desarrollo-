package es.studium.main.java;

import java.util.ArrayList;
import java.util.List;

public class PruebaPlayer {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO PRUEBA UNITARIA DE PLAYER ---");

        // 1. ARRANGE (Organizar el escenario)
        // Creamos un mini-tablero simulado con 4 casillas
        List<Square> tableroSimulado = new ArrayList<>();
        tableroSimulado.add(new Square(1, "Salida", "SALIDA", "", 0, 0, 0));
        tableroSimulado.add(new Square(2, "Calle Med.", "PROPIEDAD", "#00F", 1, 60, 2));
        tableroSimulado.add(new Square(3, "Caja Comunidad", "COMUNIDAD", "", 0, 0, 0));
        tableroSimulado.add(new Square(4, "Avenida Baltic", "PROPIEDAD", "#00F", 1, 60, 4));

        // Creamos un jugador con ID = 2 (Importante para ver el efecto del bug)
        Player jugador = new Player("Jugador de Prueba", 1500);
        jugador.setId(2);

        // Le asignamos dos propiedades a su lista: la casilla 2 y la casilla 4
        Square casilla2 = tableroSimulado.get(1); // Índice 1 es ID 2
        Square casilla4 = tableroSimulado.get(3); // Índice 3 es ID 4
        
        jugador.getProperties().add(casilla2);
        jugador.getProperties().add(casilla4);

        // Modificamos el estado para simular que construimos casas/hoteles
        // Nota: Usamos buildHouse() simulando construcciones en la casilla 4
        casilla4.buildHouse(); 
        casilla4.buildHouse(); // Ahora la casilla 4 tiene 2 casas
        
        // Supongamos que tu clase Square tiene un método para activar el hotel (ej: buildHotel() o setHotel)
        // Si no lo tiene expuesto, puedes probar la lógica directamente con las casas:
        int casasEsperadas = 2;
        int hotelesEsperados = 0; 

        // 2. ACT (Actuar/Ejecutar el método)
        int casasObtenidas = jugador.getTotalHouses(tableroSimulado);
        int hotelesObtenidos = jugador.getTotalHotels(tableroSimulado);

        // 3. ASSERT (Verificar los resultados)
        System.out.println("\n> RESULTADOS CON EL CÓDIGO ACTUAL:");
        System.out.println("Casas esperadas: " + casasEsperadas + " | Casas obtenidas: " + casasObtenidas);
        System.out.println("Hoteles esperados: " + hotelesEsperados + " | Hoteles obtenidos: " + hotelesObtenidos);

        if (casasObtenidas == casasEsperadas) {
            System.out.println("\n✅ ¡ÉXITO! El método funciona correctamente.");
        } else {
            System.out.println("\n❌ ¡ERROR DETECTADO! El método no cuenta bien los elementos.");
            System.out.println("Motivo: El jugador miró la casilla con índice " + (jugador.getId() - 1) + 
                               " (" + tableroSimulado.get(jugador.getId() - 1).getName() + 
                               ") en lugar de recorrer sus propiedades reales.");
        }
    }
}