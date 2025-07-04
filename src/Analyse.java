import utils.*;

public class Analyse {
    private String eingabe;
    private Scanner scanner;
    private Parser parser;
    private List<Token> tokenliste;

    public Analyse(String pEingabe) {
        this.eingabe = pEingabe;
        tokenliste = new List<Token>();
        scanner = new Scanner(eingabe, tokenliste);
    }

    public void analysieren() {
        scanner.scanne();
        if (scanner.getTokenliste() != null) {
            parser = new Parser(scanner.getTokenliste());
            if(parser.parse()){
            System.out.println("Fehler beim Parsen!");
        } else {
            System.out.println("Analyse erfolgreich!");
        }
    }
    }


    }
