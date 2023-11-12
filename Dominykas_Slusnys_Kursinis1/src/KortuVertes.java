import lombok.Getter;
import lombok.Setter;

@Getter
public enum KortuVertes {
    TUZAS("TŪZAS", 11),
    DU("DVEJETAS",2),
    TRYS("TREJETAS", 3),
    KETURI("KETVERTAS", 4),
    PENKI("PENKETAS", 5),
    SESI("ŠEŠIATAS", 6),
    SEPTYNI("SEPTYNETAS", 7),
    ASTUONI("AŠTUONETAS", 8),
    DEVYNI("DEVYNETAS", 9),
    DESIMT("DEŠIMTUKAS", 10),
    BARTUKAS("BARTUKAS", 10),
    KARALIENE("KARALIENĖ", 10),
    KARALIUS("KARALIUS", 10);

    String vertesPav;
    int verte;

    KortuVertes(String vertesPav, int verte){
        this.vertesPav = vertesPav;
        this.verte = verte;
    }

    public String toString(){
        return vertesPav;
    }

}
