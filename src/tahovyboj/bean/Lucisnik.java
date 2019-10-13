package tahovyboj.bean;

public class Lucisnik extends Bojovnik{

    private int sipy; // pocet sipu

    public Lucisnik (String jmeno, int zivot, int utok, int obrana, Kostka kostka, Zbran zbran, int sipy){
        super(jmeno, zivot, utok, obrana, kostka, zbran);
        this.sipy = sipy;
    }

    @Override
    public void utoc(Bojovnik souper) {
        int uder = 0;
        if (sipy > 0) {
            uder = utok + kostka.hod();
            sipy--;
        }
        setZprava(String.format("%s útočí s úderem za %s hp, pocet sipu: %s", jmeno, uder, sipy));
        souper.branSe(uder);
    }
}
