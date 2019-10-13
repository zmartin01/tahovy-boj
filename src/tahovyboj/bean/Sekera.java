package tahovyboj.bean;

public class Sekera implements Zbran {

    private int utok;

    public Sekera(int utok) {
        this.utok = utok;
    }

    public int getUtok(){
        return this.utok;
    }

    @Override
    public String toString(){
        return "Sekera";
    }
}
