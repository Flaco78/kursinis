import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dileris extends zaidejuLogika{
    public Dileris(){
        super.setPavadinimas("Dileris");
    }
    public boolean dilerisTuriBlackJack(){
        return this.getRanka().rankosVerte() == 21;
    }
    public void dilerioPirmaRanka() {
        System.out.println("Dilerio kortos - " + super.getRanka().kortosNumeris(0) + " Užversta korta (?)");
        System.out.println("    Kortų vertė - " + " ?");
    }
}
