import utils.*;

public class Parser {
    private boolean fehler;
    private List<Token> tokenliste;
    private Token aktuellesToken;

    public Parser(List<Token> pTokenliste){
        this.tokenliste = pTokenliste;
        this.fehler = false;

    }
    public Token nextToken(){
        if (!tokenliste.hasAccess()) {
            tokenliste.toFirst();  // erstes Token als Start setzen
        } else {
            tokenliste.next();     // nächstes Token
        }

        if (tokenliste.hasAccess()) {
            return tokenliste.getContent();
        } else {
            return null;  // kein Token mehr
        }
    }

    public boolean parse(){
        tokenliste.toFirst();
        return pruefaS();

    }
    private boolean pruefaS() {
        // S → A B
        if (!pruefaA()) {
            return false;
        }
        if (!pruefaB()) {
            return false;
        }
        return true;
    }

    private boolean pruefaA() {
        // A → ("la" | "le")*
        Token token;
        while (true) {
            token = nextToken();
            if (token == null) {
                fehler = true; // Erwartet B (lu), aber Liste vorbei
                return false;
            }
            String wert = token.getWert();
            if (wert.equals("la") || wert.equals("le")) {
                // Token akzeptiert, weiter machen (schleife)
            } else {
                return true;
            }

        }
    }
    public boolean pruefaB(){
        Token token = nextToken();
        if (token == null) {
            fehler = true;
            return false;
        }
        if (token.getWert().equals("lu")) {
            return true;
        } else {
            fehler = true;
            return false;
        }
    }


}
