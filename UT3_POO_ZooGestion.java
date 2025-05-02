import java.util.ArrayList;
import java.util.Scanner;

/**
 * ! TEORÍA: PROGRAMACIÓN ORIENTADA A OBJETOS EN JAVA
 *
 * ? 1. CLASES Y OBJETOS:
 *    - Una clase es un modelo que define atributos y métodos.
 *    - Un objeto es una instancia de una clase.
 *
 * ? 2. HERENCIA:
 *    - Permite que una clase hija herede atributos y métodos de una clase padre.
 *    - Se usa la palabra clave `extends`.
 *
 * ? 3. INTERFACES:
 *    - Define métodos que las clases deben implementar.
 *    - Se usa la palabra clave `implements`.
 *
 * ? 4. POLIMORFISMO:
 *    - Permite que una clase sobreescriba métodos de su superclase (`@Override`).
 *    - Se usa para hacer el código más flexible y reutilizable.
 *
 * ? 5. ESTRUCTURAS DE CONTROL:
 *    - `if-else`, `switch`, `for`, `while`, `do-while` permiten tomar decisiones o repetir acciones.
 *
 * ******************************************************
 * ! EJERCICIO: GESTIÓN DE UN ZOOLÓGICO
 * ******************************************************
 * Creamos un sistema para gestionar los animales en un zoológico.
 * - Cada animal tiene un nombre, edad y tipo de alimentación.
 * - Hay distintos tipos de animales (Mamíferos, Aves y Reptiles).
 * - Los cuidadores pueden alimentar y revisar el estado de los animales.
 * - Se utilizan estructuras de control en los métodos.
 */

// * INTERFAZ PARA DEFINIR COMPORTAMIENTOS DE LOS ANIMALES
interface AnimalComportamiento {
    void hacerSonido();
    void mostrarInformacion();
}

// * CLASE ABSTRACTA ANIMAL (Superclase)
abstract class Animal implements AnimalComportamiento {
    protected String nombre;
    protected int edad;
    protected String tipoAlimentacion;

    public Animal(String nombre, int edad, String tipoAlimentacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoAlimentacion = tipoAlimentacion;
    }

    // * Método abstracto a ser implementado en subclases
    public abstract void moverse();

    @Override
    public void mostrarInformacion() {
        System.out.println("🐾 Nombre: " + nombre + " | Edad: " + edad + " años | Alimentación: " + tipoAlimentacion);
    }
}

// * SUBCLASE MAMÍFERO
class Mamifero extends Animal {
    private boolean tienePelaje;

    public Mamifero(String nombre, int edad, String tipoAlimentacion, boolean tienePelaje) {
        super(nombre, edad, tipoAlimentacion);
        this.tienePelaje = tienePelaje;
    }

    @Override
    public void moverse() {
        System.out.println("🐕 " + nombre + " camina sobre sus patas.");
    }

    @Override
    public void hacerSonido() {
        System.out.println("🔊 " + nombre + " emite sonidos característicos de un mamífero.");
    }
}

// * SUBCLASE AVE
class Ave extends Animal {
    private boolean puedeVolar;

    public Ave(String nombre, int edad, String tipoAlimentacion, boolean puedeVolar) {
        super(nombre, edad, tipoAlimentacion);
        this.puedeVolar = puedeVolar;
    }

    @Override
    public void moverse() {
        if (puedeVolar) {
            System.out.println("🦅 " + nombre + " está volando.");
        } else {
            System.out.println("🐦 " + nombre + " camina o salta.");
        }
    }

    @Override
    public void hacerSonido() {
        System.out.println("🎶 " + nombre + " está cantando.");
    }
}

// SUBCLASE: REPTILES
class Reptil extends Animal{
    private boolean tienePatas;
    
    public Reptil(String nombre, int edad, String tipoAlimentacion, boolean tienePatas) {
        super(nombre, edad, tipoAlimentacion);
    }

    @Override
    public void hacerSonido() {
        System.out.println("El reptil " + nombre + " está gruniendo");
    }

    @Override
    public void moverse() {
        if(tienePatas){
            System.out.println("El reptil " + nombre + " puede andar");
        }else{
            System.out.println("El reptil " + nombre + " se arrastra por el suelo");
        }
    }
    
}

// * CLASE PRINCIPAL: GESTIÓN DEL ZOOLÓGICO
public class UT3_POO_ZooGestion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ! LISTA PARA GUARDAR LOS ANIMALES DEL ZOOLÓGICO
        ArrayList<Animal> animales = new ArrayList<>();

        // ! AGREGAMOS ANIMALES AL ZOOLÓGICO
        animales.add(new Mamifero("León", 5, "Carnívoro", true));
        animales.add(new Ave("Águila", 3, "Carnívoro", true));
        animales.add(new Mamifero("Elefante", 10, "Herbívoro", false));
        animales.add(new Ave("Pingüino", 2, "Omnívoro", false));
        animales.add(new Reptil("Serpiente", 7, "Carnívoro", false));
        animales.add(new Reptil("Tortuga", 15, "Hervíbora", true));


        // ! MOSTRAMOS INFORMACIÓN DE LOS ANIMALES
        System.out.println("\n🌿 🦁 Animales en el zoológico:");
        for (Animal animal : animales) {
            animal.mostrarInformacion();
            animal.moverse();
            animal.hacerSonido();
            System.out.println("----------------------");
        }

        // ! MENÚ INTERACTIVO PARA EL ALUMNO
        String opcion;
        do {
            System.out.println("\n🔹 MENÚ DEL ZOOLÓGICO 🔹");
            System.out.println("1. Agregar un nuevo animal");
            System.out.println("2. Mostrar todos los animales");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.next();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre del animal: ");
                    String nombre = scanner.next();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    System.out.print("Tipo de alimentación: ");
                    String alimentacion = scanner.next();
                    System.out.print("¿Es un mamífero? (si/no): ");
                    String tipo = scanner.next();

                    if (tipo.equalsIgnoreCase("si")) {
                        System.out.print("¿Tiene pelaje? (si/no): ");
                        boolean pelaje = scanner.next().equalsIgnoreCase("si");
                        animales.add(new Mamifero(nombre, edad, alimentacion, pelaje));
                    } else {
                        System.out.print("¿Puede volar? (si/no): ");
                        boolean volar = scanner.next().equalsIgnoreCase("si");
                        animales.add(new Ave(nombre, edad, alimentacion, volar));
                    }
                    System.out.println("✅ Animal agregado correctamente.");
                    break;

                case "2":
                    System.out.println("\n📜 Lista de Animales:");
                    for (Animal a : animales) {
                        a.mostrarInformacion();
                        a.moverse();
                        a.hacerSonido();
                    }
                    break;
            }
        } while (!opcion.equals("3"));

        System.out.println("🚪 Saliendo del zoológico...");
        scanner.close();
    }
}
