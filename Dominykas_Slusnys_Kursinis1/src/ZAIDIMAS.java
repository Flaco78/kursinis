import java.util.Scanner;

public class ZAIDIMAS{
    private Scanner sc = new Scanner(System.in);
    private int naudotojai;
    private Zaidejas[] zaidejai;
    private Kalade kalade;
    private Dileris dileris;
    private String mygtukas;
    private char in;
    private int zaidejoStatomaSuma;
    public void Zaidimas() {

        String vardas;
        do {
            System.out.print("Kiek žaidėjų žais? (galimas skaičius nuo 1 iki 6)");
            naudotojai = sc.nextInt();
        } while (naudotojai > 6 || naudotojai < 0);

        zaidejai = new Zaidejas[naudotojai];
        dileris = new Dileris();

        for (int i = 0; i < naudotojai; i++) {
            System.out.print("Koks žaidėjo " + (i + 1) + " vardas? ");
            vardas = sc.next();
            zaidejai[i] = new Zaidejas();
            zaidejai[i].setPavadinimas(vardas);
        }
        kalade = new Kalade();
        kalade.maisyk();
        raundas();
    }

    public void raundas() {

        for (int i = 0; i < naudotojai; i++) {
            zaidejai[i].getRanka().tustintiRanka();
        }
        dileris.getRanka().tustintiRanka();
        if(kalade.kaladejeLikusiosKortos() <= 14){
            kalade.perkurtiKalade();
            kalade.maisyk();
        }

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < naudotojai; i++) {
                zaidejai[i].getRanka().paimkKortaKaladej(kalade);
            }
            dileris.getRanka().paimkKortaKaladej(kalade);
        }

        for (int i = 0; i < naudotojai; i++) {
            if (zaidejai[i].getTurimiPinigai() > 0) {
                do {
                    System.out.println();
                    System.out.println(zaidejai[i].getPavadinimas() + " kiek norite statyti? ");
                    System.out.println(" Jūs turite - " + zaidejai[i].getTurimiPinigai());
                    System.out.print(" Pasirinkta suma: ");
                    zaidejoStatomaSuma = sc.nextInt();
                    zaidejai[i].setStatymas(zaidejoStatomaSuma);
                } while (!(zaidejoStatomaSuma > 0 && zaidejoStatomaSuma <= zaidejai[i].getTurimiPinigai()));
            }
        }

        System.out.println();
        dileris.dilerioPirmaRanka();
        for (int i = 0; i < naudotojai; i++) {
            System.out.println();
            zaidejai[i].spausdinkRanka();
        }

        if (dileris.dilerisTuriBlackJack()) {
            System.out.print("Dileris turi blackjacką - ");
            dileris.spausdinkRanka();
            for (int i = 0; i < naudotojai; i++) {
                if (zaidejai[i].getRanka().rankosVerte() == 21) {
                    zaidejai[i].pushas();
                } else {
                    System.out.println(zaidejai[i].getPavadinimas() + " pralaimėjo");
                    zaidejai[i].zaidejasPralaimi();
                }
            }
        } else {
            for (int i = 0; i < naudotojai; i++) {
                if (zaidejai[i].getRanka().rankosVerte() == 21) {
                    System.out.println(zaidejai[i].getPavadinimas() + " turi blackjacką ir laimi");
                    zaidejai[i].zaidejasTuriBlackjack();
                }
            }
        }

        for (int i = 0; i < naudotojai; i++) {
            if (zaidejai[i].getStatymas() > 0) {
                System.out.println();
                System.out.println(zaidejai[i].getPavadinimas() + " turi šias kortas - " + zaidejai[i].getRanka());
                do {
                    do {
                        System.out.print(zaidejai[i].getPavadinimas() + " ar norite IMTI ar STOTI? (naudokite I arba S raides)");
                        mygtukas = sc.next();
                        in = mygtukas.toUpperCase().charAt(0);
                    } while ( ! ( in == 'I' || in == 'S' ) );
                    if ( in == 'I' ) {
                        if(kalade.kaladejeLikusiosKortos() <= 14){
                            kalade.perkurtiKalade();
                            kalade.maisyk();
                        }
                        zaidejai[i].getRanka().paimkKortaKaladej(kalade);
                        zaidejai[i].spausdinkRanka();
                        System.out.println();
                    }
                } while (in != 'S' && zaidejai[i].getRanka().rankosVerte() <= 21 );
            }
            if(zaidejai[i].getRanka().rankosVerte() > 21) {
                System.out.println(zaidejai[i].getPavadinimas() + " pralaimėjo");
                zaidejai[i].zaidejasPralaimi();
            }
        }

        System.out.println();
        System.out.println("-------------");
        System.out.println("Dylerio eilė");
        System.out.println("-------------");
        dileris.spausdinkRanka();

        if (dileris.getRanka().rankosVerte() <= 17) {
            while (dileris.getRanka().rankosVerte() <= 17) {

                System.out.println();
                System.out.println("----------------------");
                System.out.println("Dileris traukia kortą ");
                System.out.println("----------------------");
                dileris.getRanka().paimkKortaKaladej(kalade);
                dileris.spausdinkRanka();

            }
        } else {
            System.out.println();
            System.out.println("[Dileris stoja]");
        }

        if (dileris.getRanka().rankosVerte() > 21){

            System.out.println();
            System.out.println("Dileris pralaimėjo visi žaidėjai padvigubina savo statymą");

            for (int i = 0; i < naudotojai; i++) {
                if(zaidejai[i].getStatymas() > 0){

                    zaidejai[i].zaidejasLaimi();

                }
            }
        } else {
            for (int i = 0; i < naudotojai; i++) {
                if (dileris.getRanka().rankosVerte() > zaidejai[i].getRanka().rankosVerte() && zaidejai[i].getStatymas() > 0){

                    System.out.println();
                    System.out.println(zaidejai[i].getPavadinimas() + " pralaimi prieš dilerį");
                    zaidejai[i].zaidejasPralaimi();

                } else if (dileris.getRanka().rankosVerte() < zaidejai[i].getRanka().rankosVerte() && zaidejai[i].getStatymas() > 0) {

                    System.out.println();
                    System.out.println(zaidejai[i].getPavadinimas() + " laimi prieš dilerį ir padvigubina savo statymą kuris tampa - " + zaidejai[i].getStatymas() * 2);
                    zaidejai[i].zaidejasLaimi();

                } else if (dileris.getRanka().rankosVerte() == zaidejai[i].getRanka().rankosVerte() && zaidejai[i].getStatymas() > 0) {

                    System.out.println();
                    zaidejai[i].pushas();
                    System.out.println(zaidejai[i].getPavadinimas() + " turi lygias kortų vertes kaip ir dileris (PUSH)");
                    System.out.println();

                }
            }
        }
        raundas();
    }
}
