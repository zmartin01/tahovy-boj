package tahovyboj.bean;

public class Bojovnik {

    protected String jmeno; // Jméno bojovníka
    protected int zivot; // Život v HP
    protected int maxZivot; // Maximální zdraví
    protected int utok; // Útok v HP
    protected int obrana; // Obrana v HP
    protected Kostka kostka; // Instance hrací kostky
    protected String zprava; // Poslední zpráva
    protected Zbran zbran;

    /**
     * Vytvoří novou instanci bojovníka
     *
     * @param jmeno  Jméno bojovníka
     * @param zivot  Život v HP
     * @param utok   Útok v HP
     * @param obrana Obrana v HP
     * @param kostka Instance hrací kostky
     */
    public Bojovnik(String jmeno, int zivot, int utok, int obrana, Kostka kostka, Zbran zbran) {
        this.jmeno = jmeno;
        this.zivot = zivot;
        this.maxZivot = zivot;
        this.utok = utok;
        this.obrana = obrana;
        this.kostka = kostka;
        this.zbran = zbran;
    }

    /**
     * Provede útok na soupeře
     *
     * @param souper Soupeř bojovník
     */
    public void utoc(Bojovnik souper) {
        int uder = utok + zbran.getUtok() + kostka.hod();
        setZprava(String.format("%s útočí s úderem za %s hp", jmeno, uder));
        souper.branSe(uder);
    }

    /**
     * Brání se proti úderu soupeře
     *
     * @param uder Úder soupeře v HP
     */
    public void branSe(int uder) {
        int zraneni = uder - (obrana + kostka.hod());
        if (zraneni > 0) {
            zivot -= zraneni;
            zprava = String.format("%s utrpěl poškození %s hp", jmeno, zraneni);
            if (zivot <= 0) {
                zivot = 0;
                zprava += " a zemřel";
            }

        } else
            zprava = String.format("%s odrazil útok", jmeno);
        setZprava(zprava);
    }

    /**
     * Zjistí, zda je bojovník naživu
     *
     * @return True, pokud je naživu, jinak false
     */
    public boolean nazivu() {
        return (zivot > 0);
    }

    /**
     * Nastaví zprávu o útoku nebo obraně
     *
     * @param zprava Zpráva o útoku nebo obraně
     */
    protected void setZprava(String zprava) {
        this.zprava = zprava;
    }

    /**
     * Vrátí poslední zprávu o útoku nebo obraně
     *
     * @return Poslední zpráva o útoku nebo obraně
     */
    public String getZprava() {
        return zprava;
    }

    protected String grafickyUkazatel(int aktualni, int maximalni) {
        String s = "";
        int celkem = 20;
        double pocet = Math.round(((double) aktualni / maximalni) * celkem);
        if ((pocet == 0) && (nazivu()))
            pocet = 1;
        for (int i = 0; i < pocet; i++)
            s += "█";
        for (int i = 0; i < celkem - pocet; i++)
            s += " ";
        return s;
    }

    /**
     * Vrátí grafickou reprezentaci života
     *
     * @return Řetězec s grafickou reprezentací života
     */
    public String grafickyZivot() {
        return grafickyUkazatel(zivot, maxZivot);
    }

    /**
     * Vrací textovou reprezentaci bojovníka
     *
     * @return Textová reprezentace bojovníka
     */
    @Override
    public String toString() {
        return jmeno;
    }
}
