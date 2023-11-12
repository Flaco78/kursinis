import java.util.ArrayList;

public class Ranka {
    private ArrayList<Kortos> ranka;
    public Ranka() {
        ranka = new ArrayList<>();
    }
    public void paimkKortaKaladej(Kalade kalade){
        ranka.add(kalade.paimkKorta());
    }
    public String toString(){
        String out = "";
        for(Kortos korta: ranka){
            out += korta + " ";
        }
        return out;
    }
    public int rankosVerte(){
        int verte = 0;
        int tuzai = 0;
        for (Kortos korta: ranka){
            verte += korta.getKv().getVerte();
            if(korta.getKv().getVerte() == 11){
                tuzai ++;
            }
        }
        if(verte > 21 && tuzai > 0){
            while(tuzai > 0 && verte > 21){
                tuzai --;
                verte -= 10;
            }
        }
        return verte;
    }
    public Kortos kortosNumeris(int kortosEileKaladeje){
        return ranka.get(kortosEileKaladeje);
    }
    public void tustintiRanka(){
        ranka.clear();
    }
}
