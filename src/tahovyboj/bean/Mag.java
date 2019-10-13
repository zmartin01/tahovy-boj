package tahovyboj.bean;

public class Mag extends Bojovnik {

    private int mana; // Mana
    private int maxMana; // Maximální mana, tedy hodnota, kdy je mana plná a lze ji použít
    private int magickyUtok; // Magický útok v HP

    /**
     * Vytvoří novou instanci mága
     *
     * @param jmeno       Jméno bojovníka
     * @param zivot       Život v HP
     * @param utok        Útok v HP
     * @param obrana      Obrana v HP
     * @param kostka      Instance hrací kostky
     * @param mana        Mana
     * @param magickyUtok Magický útok v HP
     */
    public Mag(String jmeno, int zivot, int utok, int obrana, Kostka kostka, Zbran zbran, int mana, int magickyUtok) {
        super(jmeno, zivot, utok, obrana, kostka, zbran);
        this.mana = mana;
        this.maxMana = mana;
        this.magickyUtok = magickyUtok;
    }

    /**
     * Provede útok na soupeře
     *
     * @param souper Soupeř bojovník
     */
    @Override
    public void utoc(Bojovnik souper) {
        // Mana není naplněna
        if (mana < maxMana) {
            mana += 10;
            if (mana > maxMana)
                mana = maxMana;
            super.utoc(souper);
        } else {
            // Magický útok
            int uder = magickyUtok + kostka.hod();
            setZprava(String.format("%s použil magii za %s hp", jmeno, uder));
            souper.branSe(uder);
            mana = 0;
        }
    }

    /**
     * Vrátí grafickou reprezentaci many
     *
     * @return Řetězec s grafickou reprezentací many
     */
    public String grafickaMana() {
        return grafickyUkazatel(mana, maxMana);
    }
}
