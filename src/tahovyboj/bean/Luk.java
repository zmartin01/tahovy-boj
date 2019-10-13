package tahovyboj.bean;

public class Luk implements Zbran {

    private int utok;

    public Luk(int utok) {
        this.utok = utok;
    }

    public int getUtok(){
        return this.utok;
    }

    @Override
    public String toString(){
        return "Luk";
    }
}
