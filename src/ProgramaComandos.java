/**
 * fabian silva de la torre
 * la clase permite leer la secuencia de un caracter
 */

import java.io.BufferedReader;
/**
 * lee el caracter de un archivo
 */
import java.io.FileReader;
/**
 * exsepcion de entrada y salida  , para herrores al abrir o leer archivos
 */
import java.io.IOException;
/**
 * La clase ProgramaComandos permite leer y ejecutar comandos desde un archivo de texto.
 */

public class ProgramaComandos {


    /**
     * El método principal que se ejecuta al iniciar el programa.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        String nombreArchivo = "comandos.txt"; // Nombre del archivo de comandos

        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) { // Verificar si la línea no está en blanco
                    ejecutarComando(linea);
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    /**
     * Ejecuta un comando específico.
     * @param comando El comando a ejecutar.
     */
    public static void ejecutarComando(String comando) {
        String[] partes = comando.split(":");

        if (partes.length != 2) {
            System.out.println("Comando inválido: " + comando);
            return;
        }

        String tipoComando = partes[0];
        String argumento = partes[1];

        switch (tipoComando) {
            case "C":
                imprimirCuadrado(Integer.parseInt(argumento));
                break;
            case "T":
                imprimirTriangulo(Integer.parseInt(argumento));
                break;
            case "P":
                imprimirPalindromo(argumento);
                break;
            case "S":
                imprimirFormatoEspecial(argumento);
                break;
            default:
                System.out.println("Comando desconocido: " + comando);
        }
    }
    /**
     * Imprime un cuadrado de asteriscos.
     * @param tamano El tamaño del cuadrado.
     */
    public static void imprimirCuadrado(int tamano) {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * Imprime un triángulo de asteriscos.
     * @param tamano El tamaño del triángulo.
     */
    public static void imprimirTriangulo(int tamano) {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * Imprime un palíndromo de la palabra especificada.
     * @param palabra La palabra para generar el palíndromo.
     */
    public static void imprimirPalindromo(String palabra) {
        StringBuilder palindromo = new StringBuilder(palabra).reverse();
        System.out.println(palindromo);
        System.out.println();
    }
    /**
     * Imprime un formato especial de la palabra especificada.
     * @param palabra La palabra para generar el formato especial.
     */
    public static void imprimirFormatoEspecial(String palabra) {
        StringBuilder formato = new StringBuilder();

        for (char c : palabra.toCharArray()) {
            if (esVocal(c)) {
                formato.append("*");
            } else {
                formato.append("#");
            }
        }

        System.out.println(formato);
        System.out.println();
    }
    /**
     * Verifica si un carácter es una vocal.
     * @param c El carácter a verificar.
     * @return true si el carácter es una vocal, false en caso contrario.
     */
    public static boolean esVocal(char c) {
        c = Character.toLowerCase(c);

        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
