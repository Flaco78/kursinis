import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Kalade {
    private ArrayList<Kortos> kalade;

    public String toString() {
        String out ="";
        for(Kortos korta: kalade){
            out += korta;
            out += "\n";
        }
        return out;
    }
    public Kalade(){
        kalade = new ArrayList<>();
        for (KortuTipai kt: KortuTipai.values()){
            for(KortuVertes kv: KortuVertes.values()){
                    kalade.add(new Kortos(kt, kv));
            }
        }
    }
    public void maisyk(){
        Collections.shuffle(kalade, new Random());
    }
    public Kortos paimkKorta(){
        Kortos paimtaKorta = new Kortos(kalade.get(0));
        kalade.remove(0);
        return paimtaKorta;
    }
    public void perkurtiKalade(){
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Kaladė pasibaigė ir yra maišoma iš naujo");
        System.out.println("----------------------------------------");
        kalade.clear();
        kalade = new ArrayList<>();
        for (KortuTipai kt: KortuTipai.values()){
            for(KortuVertes kv: KortuVertes.values()){
                kalade.add(new Kortos(kt, kv));
            }
        }
    }
    public int kaladejeLikusiosKortos(){
        return kalade.size();
    }
}

