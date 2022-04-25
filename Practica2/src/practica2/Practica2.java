/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res = 0;
        String operacion;
        boolean comprobar = false;

        do {

            String numero1;
            do {
                System.out.println("\n Introdueix el primer numero. ");
                numero1 = sc.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume1 = Double.parseDouble(numero1);
            double n1 = new Double(numero1);

            do {
                printearMenu();
                operacion = sc.nextLine();
                if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x")
                        || operacion.equals("X") || operacion.equals("/") || operacion.equals("%")
                        || operacion.equals("*")) {
                    comprobar = true;
                } else {
                    comprobar = false;
                }
            } while (comprobar != true);

            String numero2;
            do {
                System.out.println("\n Introdueix el segon numero.");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume2 = Double.parseDouble(numero2);
            double n2 = new Double(numero2);

            do {
                comprobar = true;
                switch (operacion) {
                    case "+":
                        res = n2 + n1;
                        break;
                    case "-":
                        res = n1 - n2;
                        break;
                    case "x":
                    case "X":
                        res = n1 * n2;
                        break;
                    case "/":
                        n2 = validarDivisio(n2);
                        res = n1 / n2;
                        break;
                    case "*":
                        res = Math.pow(n1, n2);
                        break;
                    case "%":                        
                        n2 = validarDivisio(n2);
                        res = n1 % n2;
                        break;
                }
            } while (comprobar != true);

            System.out.println("\nResultat:");
            System.out.println("(" + n1 + ") " + operacion + " (" + n2 + ")" + " = " + res);
            System.out.println("\nVols continuar operant? (Ss/Nn)");
            do {
                comprobar = true;
                operacion = sc.nextLine();

                switch (operacion) {
                    case "s":
                    case "S":
                    case "n":
                    case "N":
                        break;
                    default:
                        System.err.println("\n Error, posa un valor vàlid. \n");
                        comprobar = false;
                }
            } while (comprobar != true);
        } while (operacion.equals("s") || operacion.equals("S"));
    }

    static double validarDivisio(double n2) {
        Scanner sc = new Scanner(System.in);
        String numero2;
        while (n2 == 0) {
            do {
                System.err.println("\nAl denominador hi ha un zero.\n"
                        + "Per a  evitar errors coloca un altre valor.");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            n2 = new Double(numero2);
        }
        return n2;
    }
    
    static void printearMenu(){
        System.out.println("\n Operació? (Indica el signe)");
                System.out.println("+ = sumar \n- = restar \n"
                        + "x = multiplicar \n/ = dividir \n* = elevar primer num al segon num."
                        + "\n% = residu");
    }
}
