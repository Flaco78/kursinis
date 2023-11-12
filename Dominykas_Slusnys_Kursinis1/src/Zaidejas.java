import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;
@Getter
@Setter
public class Zaidejas extends zaidejuLogika {
    public double statymas;
    public double turimiPinigai;
    public Zaidejas(){
        turimiPinigai = 100;
    }
    public void zaidejasTuriBlackjack() {
        turimiPinigai += statymas * 1.5;
        statymas = 0;
    }
    public void pushas(){
        statymas = 0;
    }
    public void zaidejasPralaimi(){
        turimiPinigai -= statymas;
        statymas = 0;
    }
    public void zaidejasLaimi(){
        turimiPinigai += statymas * 2;
        statymas = 0;
    }
}
