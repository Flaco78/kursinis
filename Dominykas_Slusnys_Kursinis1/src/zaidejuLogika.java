import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public abstract class zaidejuLogika {
    private Ranka ranka;
    private String pavadinimas;
    private Kalade kalade;
    public zaidejuLogika(){
        this.ranka = new Ranka();
        this.pavadinimas = "";
    }
    public void spausdinkRanka(){
        if(Objects.equals(this.pavadinimas, "Dileris")){
            System.out.println("Dilerio kortos - " + this.ranka);
            System.out.println("    Kortų vertė - " + "(" +this.ranka.rankosVerte() + ")");
        }
        else {
            System.out.println(this.pavadinimas + " kortos - " + this.ranka);
            System.out.println("    Kortų vertė - " + "(" +this.ranka.rankosVerte() + ")");
        }
    }
}
