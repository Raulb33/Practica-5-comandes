package Practica5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Comandesrestaurant {

       static String ticketActual = "";
       static double totalSenseIVAActual = 0;
       static String nomClientActual = "";
    public static void main (String[] args) {
         boolean sortir =false;
         Scanner p5 = new Scanner(System.in);
          while (!sortir) {
         System.out.println("------------------------------------");
         System.out.println("\n=== GESTIÓ COMANDES RESTAURANT ===");
         System.out.println("\n------------------------------------");
         System.out.println("\n1. Crear nova comanda");
         System.out.println("2. Actualitzar comanda anterior");
         System.out.println("3. Visualitzar últim tiquet");
         System.out.println("4. Sortir");
         System.out.print("\nTria una opció: ");
        try {
            int opcio = p5.nextInt();
            switch (opcio) {
                case 1 -> NovaComanda (p5);
                case 2 -> ActualitzaTiquet (p5);
                case 3 -> UltimTiquet (p5);
                case 4 -> {
                    System.out.println("------------------------------------");
                    System.out.println("\n==========FINS LA PROPERA!==========");
                    System.out.println("\n------------------------------------");
                    sortir = true;
                }
                default -> System.out.println("OPCIÓ NO VALIDA");
            }   
            } catch (InputMismatchException e) {
        System.out.println("Error Format no valid utilitza numero valid");
        p5.nextLine();
        }
    }
        p5.close();
}
          

    public static void NovaComanda (Scanner p5) {
        System.out.println("______________________________________");
        System.out.println("\n============ NOVA COMANDA ============");
        System.out.println("______________________________________");

        String ticket = "";
        double totalSenseIVA = 0;
        String resposta;
        p5.nextLine();
            System.out.print("\nIntrodueix el nom del client: ");
            String nomClient = p5.nextLine();

        do {
            System.out.println("Introdueix el producte: ");
            String producte = p5.nextLine();

            System.out.println("Preu unitari (€): ");
            double preu = p5.nextDouble();

            System.out.println("Quantitat: ");
            int quantitat = p5.nextInt();

            p5.nextLine();

            double subtotal = preu * quantitat;
            totalSenseIVA += subtotal;
            
        ticket += String.format("%-15s %-11d %-12.2f € %.2f€\n",
        producte, quantitat, preu, subtotal);


            System.out.println("Vols afegir un altre producte? (s/n): ");
            resposta = p5.nextLine().trim().toLowerCase();
        
    } while (resposta.equals("s"));

    double iva = totalSenseIVA * 0.10;
    double totalAmbIVA = totalSenseIVA + iva;

    System.out.println("\nS'està generant el tiquet…");
        System.out.println("______________________________________");
        System.out.println("=============== TIQUET ===============");
        System.out.println("______________________________________");
        System.out.println("Client: " + nomClient + "\n");

        System.out.println("Producte        Quantitat   Preu unit.   Subtotal");
        System.out.println("--------------------------------------------------");
        System.out.print(ticket);
        System.out.println("--------------------------------------------------");
        System.out.printf("%-43s %10.2f €\n", "Total sense IVA:", totalSenseIVA);
        System.out.printf("%-43s %10.2f €\n", "IVA (10%):", iva);
        System.out.printf("%-43s %10.2f €\n", "TOTAL A PAGAR:", totalAmbIVA);
        System.out.println("==================================================");
        boolean correcte = false;

        while (!correcte) {
        System.out.println("És correcte?");
        System.out.println("1. Sí");
        System.out.println("2. No");

        try {
            int opcio = p5.nextInt();
            p5.nextLine();
            if (opcio == 1) {
                correcte = true; 
            } else if (opcio == 2) {
                ticket = "";
                totalSenseIVA = 0;
                p5.nextLine();
                NovaComanda(p5);
                return; 
            } else {
                System.out.println("OPCIÓ NO VÀLIDA. Torna a intentar:");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: format no vàlid. Introdueix un número:");
            p5.nextLine();
        }
    }
    ticketActual = ticket;
    totalSenseIVAActual = totalSenseIVA;
    nomClientActual = nomClient;

}
     public static void ActualitzaTiquet (Scanner p5) {
     
     if (ticketActual.isEmpty()) {
        System.out.println("No hi ha cap ticket per actualitzar");
        return;
     }
     p5.nextLine();
     String resposta;

     do {
        System.out.println("Introdueix el producte: ");
        String producte = p5.nextLine();

        System.out.println("Preu unitari (€): ");
        double preu = p5.nextDouble();

        System.out.println("Quantitat: ");
        int quantitat = p5.nextInt();
        p5.nextLine();

        double subtotal = preu * quantitat;
        totalSenseIVAActual += subtotal;

        ticketActual += String.format(
            "%-15s %-11d %-12.2f € %.2f€\n",
            producte, quantitat, preu, subtotal
        );

        System.out.println("Vols afegir un altre producte? (s/n): ");
        resposta = p5.nextLine().trim().toLowerCase();

    } while (resposta.equals("s"));

        System.out.println("Tiquet actualitzat correctament!");
    }
      public static void UltimTiquet (Scanner p5) {
    if (ticketActual.isEmpty()) {
        System.out.println("No hi ha cap tiquet guardat.");
        return;
    }

    double iva = totalSenseIVAActual * 0.10;
    double totalAmbIVA = totalSenseIVAActual + iva;

    System.out.println("______________________________________");
    System.out.println("=============== TIQUET ===============");
    System.out.println("______________________________________");
    System.out.println("Client: " + nomClientActual + "\n");

    System.out.println("Producte        Quantitat   Preu unit.   Subtotal");
    System.out.println("--------------------------------------------------");
    System.out.print(ticketActual);
    System.out.println("--------------------------------------------------");
    System.out.printf("%-43s %10.2f €\n", "Total sense IVA:", totalSenseIVAActual);
    System.out.printf("%-43s %10.2f €\n", "IVA (10%):", iva);
    System.out.printf("%-43s %10.2f €\n", "TOTAL A PAGAR:", totalAmbIVA);
    System.out.println("==================================================");
}
}
