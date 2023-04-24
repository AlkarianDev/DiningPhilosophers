// Author Mateusz Korolczuk

package org.example;

public class Philosophe implements Runnable {
    private Object fourchetteGauche;
    private Object fourchetteDroite;

    public Philosophe(Object fourchetteGauche, Object fourchetteDroite) {
        this.fourchetteGauche = fourchetteGauche;
        this.fourchetteDroite = fourchetteDroite;
    }

    private void DoAction(String action) throws InterruptedException {
        //Affiche le philosophe courant + action qui viens va se deroule pendant le temps qui est deffini par
        // variable temps
        System.out.println(Thread.currentThread().getName() + " " + action);
        int temps = ((int) (Math.random() * 1000));
        Thread.sleep(temps);
        // Check les temps randomise entre les actions
        //System.out.println(temps);
    }
    private void DoActionManger(String action) throws InterruptedException {
        //Affiche le philosophe courant + Le temps de Manger
        int temps = ((int) (Math.random() * 10000));
        System.out.println(Thread.currentThread().getName() + " " + action + " pendant: " + (temps/ 1000) + " Sec");
        Thread.sleep(temps);
    }

    @Override
    public void run() {
        try {
            while (true) {
                // le Philosophe Reflechi
                DoAction(": Entrain de Reflechir");

                //Synchronization sur la fourchette gauche
                synchronized (fourchetteGauche) {
                    DoAction(": A pris la fourchette gauche");
                    synchronized (fourchetteDroite) {
                        // Il prend la Fourchette droite et il mange puis depose la fourchette droite
                        DoActionManger(": A pris la fourchette droite - Manger");
                        //Separation visuelle entre Manger et deposer la fourchette
                        // (Il y a un temps randomise quand il mange)
                        //System.out.println("------------------------------");
                        //Deposer la fourchette Droite
                        DoAction(": A posé la fourchette droite");
                    }
                    // poser la fourchette gauche
                    DoAction(": A posé la fourchette gauche");
                }
            }
        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
            return;
        }
    }
}