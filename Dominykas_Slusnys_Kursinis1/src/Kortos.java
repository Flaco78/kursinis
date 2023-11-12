import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Kortos {
    private KortuTipai kt;
    private KortuVertes kv;

    public Kortos(KortuTipai kt, KortuVertes kv) {
        this.kt = kt;
        this.kv = kv;
    }

    public Kortos(Kortos kortuVerteTipas) {
        this.kt = kortuVerteTipas.getKt();
        this.kv = kortuVerteTipas.getKv();
    }

    public String toString(){
        return (kt + " " +  kv + " (" + kv.verte + ")");
    }
}
