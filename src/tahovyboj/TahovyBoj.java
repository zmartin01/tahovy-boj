/* www.devbook.cz :-) */
package tahovyboj;

import tahovyboj.bean.*;

public class TahovyBoj {

    public static void main(String[] args) {
        // vytvoření objektů
        Kostka kostka = new Kostka(10);
        Bojovnik zalgoren = new Bojovnik("Zalgoren", 100, 20, 10, kostka, new Sekera(3));
        // Mag gandalf = new Mag("Gandalf", 60, 15, 12, kostka, 30, 45);
        Lucisnik lucisnik = new Lucisnik("Pepa", 80, 25, 11, kostka, new Luk(5), 20);

        Arena arena = new Arena(zalgoren, lucisnik, kostka);
        // zápas
        arena.zapas();
        System.out.println(kostka.toString());
    }
}
