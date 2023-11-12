import lombok.Getter;
import lombok.Setter;
@Getter
//@Setter

public enum KortuTipai {
       BUGNAI("BŪGNŲ"), //Raudonas rombas

       CIRVAI("ČIRVŲ"), //Raudona sirdute

       VYNAI("VYNŲ"), //Juodas lapas

       KRYZIAI("KRYŽIŲ"); //Juodas trilapis dobiliukas


       String kortosTipas;


       KortuTipai(String kortosTipas) {
           this.kortosTipas = kortosTipas;
       }


    public String toString(){
        return kortosTipas;
    }
}
