// Author Mateusz Korolczuk
// Author Mateusz Korolczuk

package org.example;

public class DiningPhilosophers {
    public static void main(String[] args) throws InterruptedException {
        // Initiation des Philosophe ( class Philosophe)
        Philosophe[] philosophes = new Philosophe[5];

        // Initiation des Fourchettes par rapport a la nombre des Philophe (philosophes.length pour avoir la nombre des philosophes)
        // Chacun 1 fourchette
        Object[] fourchettes = new Object[philosophes.length];

        for (int i = 0; i < fourchettes.length; i++) {
            fourchettes[i] = new Object();
        }
        //


        //
        for (int i = 0; i < philosophes.length; i++) {
            Object fourchetteGauche = fourchettes[i];
            Object fourchetteDroite = fourchettes[(i + 1) % fourchettes.length];

            if (i == philosophes.length - 1) {
                philosophes[i] = new Philosophe(fourchetteDroite, fourchetteGauche);
            } else {
                philosophes[i] = new Philosophe(fourchetteGauche, fourchetteDroite);
            }

            Thread t = new Thread(philosophes[i], "Philosophe " + (i + 1));
            System.out.println("------------------------------");
            t.start();


        }

        //finition du programme apres 600 seconds //le script va dure 5min
        // la dure peut etre change en changant la variable TempsExec
        int TempsExec = 600;
        Thread.sleep((TempsExec) * 1000);
        System.exit(0);
    }
}
