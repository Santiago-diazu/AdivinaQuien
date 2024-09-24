import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

class Personaje {
    String nombre;
    String[] caracteristicas;

    Personaje(String nombre, String[] caracteristicas) {
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
    }
}

public class QuienSoy {
    public static void main(String[] args) {
        Random random = new Random();

        // Lista de personajes
        List<Personaje> personajes = new ArrayList<>();
        personajes.add(new Personaje("Santiago", new String[]{"alto", "rubio", "lleva gafas", "blanco", "pelo largo", "lleva piercings", "tiene tatuajes", "sexo masculino", "va al gimnasio", "pelo liso"}));
        personajes.add(new Personaje("Leandro", new String[]{"estatura promedio", "pelo negro", "no lleva gafas", "blanco", "pelo corto", "no lleva piercings", "no lleva tatuajes", "lleva barba", "sexo masculino", "no practica deporte", "aparentemente es de pelo liso"}));
        personajes.add(new Personaje("Camilo", new String[]{"alto", "pelo oscuro", "no lleva gafas", "es de piel clara", "largo de pelo promedio", "no lleva piercings", "no lleva tatuajes", "es hombre", "no practica algún deporte", "tiene pelo liso", "no lleva barba", "es uno de los más jóvenes del aula"}));
        personajes.add(new Personaje("Esteban", new String[]{"alto", "pelo oscuro", "no lleva gafas", "moreno", "pelo promedio", "no lleva piercings", "lleva tatuajes", "sexo masculino", "le gusta el deporte", "trabaja en temas de mecánica", "casi simepre está con gorra", "lleva barba"}));
        personajes.add(new Personaje("Gustavo", new String[]{"alto", "pelo oscuro", "lleva gafass", "blanco", "lleva pelo corto", "no lleva piercings", "no lleva tatuajes", "sexo masculino", "probablemente es el mayor de todos", "no lleva barba", "aparentemente pelo liso"}));
        personajes.add(new Personaje("Alejandro", new String[]{"bajo", "pelo oscuro", "no lleva gafas", "moreno", "pelo largo", "no lleva piercings", "aparentemente no lleva tatuajes", "masculino", "juega futbol", "pelo liso", "lleva barba"}));


        // Selecciona un personaje aleatorio
        Personaje personajeSeleccionado = personajes.get(random.nextInt(personajes.size()));
        int puntos = 10;
        boolean adivinado = false;

        JOptionPane.showMessageDialog(null, "¡Bienvenido a Adivina Quién!\nInicias con " + puntos + " puntos.");

        // Selecciona las características aleatorias (tres incialmente) para comenzar a adivinar
        StringBuilder pistas = new StringBuilder("Pistas iniciales:\n");
        for (int i = 0; i < 3; i++) {
            int indiceCaracteristica = random.nextInt(personajeSeleccionado.caracteristicas.length);
            pistas.append("- ").append(personajeSeleccionado.caracteristicas[indiceCaracteristica]).append("\n");
        }
        JOptionPane.showMessageDialog(null, pistas.toString());

        while (puntos > 0 && !adivinado) {
            String opcion = JOptionPane.showInputDialog("¿Quieres adivinar el personaje o pedir otra pista? (adivinar/pista)");

            if (opcion.equalsIgnoreCase("pista")) {
                if (puntos > 1) {
                    int indiceCaracteristica = random.nextInt(personajeSeleccionado.caracteristicas.length);
                    JOptionPane.showMessageDialog(null, "Pista adicional: " + personajeSeleccionado.caracteristicas[indiceCaracteristica]);
                    puntos--;
                } else {
                    JOptionPane.showMessageDialog(null, "No puedes pedir más pistas, te quedan " + puntos + " puntos.");
                }
            } else if (opcion.equalsIgnoreCase("adivinar")) {
                String respuesta = JOptionPane.showInputDialog("Introduce el nombre del personaje:");

                if (respuesta.equalsIgnoreCase(personajeSeleccionado.nombre)) {
                    JOptionPane.showMessageDialog(null, "¡Correcto! El personaje es " + personajeSeleccionado.nombre + ". Quedaste con " + puntos + " puntos.");
                    adivinado = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrecto. El personaje era " + personajeSeleccionado.nombre + ". El puntaje son 0 puntos.");
                    puntos = 0;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elige 'adivinar' o 'pista'.");
            }
        }

        if (!adivinado) {
            JOptionPane.showMessageDialog(null, "Fin del juego. El personaje era " + personajeSeleccionado.nombre + ".");
        }
    }
}