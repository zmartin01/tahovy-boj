/* www.devbook.cz :-) */
package tahovyboj;

import tahovyboj.bean.Arena;
import tahovyboj.bean.Bojovnik;
import tahovyboj.bean.Kostka;
import tahovyboj.bean.Mag;

public class TahovyBoj {

    public static void main(String[] args) {
        // vytvoření objektů
        Kostka kostka = new Kostka(10);
        Bojovnik zalgoren = new Bojovnik("Zalgoren", 100, 20, 10, kostka);
        Mag gandalf = new Mag("Gandalf", 60, 15, 12, kostka, 30, 45);
        Arena arena = new Arena(zalgoren, gandalf, kostka);
        // zápas
        arena.zapas();
        System.out.println(kostka.toString());
    }
}
