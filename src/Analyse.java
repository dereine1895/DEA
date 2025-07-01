import utils.*;

public class Analyse {
    private String eingabe;

    public Analyse(String pEingabe) {
        this.eingabe = pEingabe;
    }

    public void analysieren() {
        List<Token> tokenliste = new List<>();

        // Scanner mit Eingabe und Liste erzeugen
        Scanner scanner = new Scanner(eingabe, tokenliste);
        scanner.Scanner();

        // Fehler beim Scannen prüfen
        if (scanner.hatFehler()) {
            System.out.println("Fehler beim Scannen!");
            return;
        }

        // Parser mit Tokenliste erzeugen
        Parser parser = new Parser(tokenliste);
        boolean parsingErfolg = parser.parse();

        // Parser-Fehler prüfen
        if (!parsingErfolg || parser.hatFehler()) {
            System.out.println("Fehler beim Parsen!");
        } else {
            System.out.println("Analyse erfolgreich!");
        }
    }

    }
}