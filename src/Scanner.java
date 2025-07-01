import utils.*;

public class Scanner {

    private boolean fehler;
    private String eingabe;
    private List<Token> tokenliste;

    public Scanner(String pEingabe, List<Token> pTokenliste){
        this.eingabe = pEingabe;
         this.tokenliste = pTokenliste;
         this.fehler = false;


    }
    public void Scanner(){

        if(eingabe.length() !=7 || eingabe.charAt(6) != '#') {
            fehler = true;
            ausgabe(fehler);
            return;
        }
        int pos = 0;
        Token letztesToken= null;

        while( pos < 6){
            String kombi = "" + eingabe.charAt(pos) + eingabe.charAt(pos + 1);


            switch (kombi) {
                case "la":
                case "le":
                    letztesToken = new Token("Egal", kombi);
                    tokenliste.append(letztesToken);
                    break;
                case "lu":
                    letztesToken = new Token("Ende", kombi);
                    tokenliste.append(letztesToken);
                    break;
                default:
                    fehler = true;
                    return;
            }
            pos += 2;
        }

        if (!letztesToken.getWert().equals("lu")) {
            fehler = true;
        }

        ausgabe(fehler);

    }
    private void ausgabe(boolean pFehler){
        tokenliste.toFirst();
        while(tokenliste.hasAccess()) {
            Token t = tokenliste.getContent();
            System.out.println(t.getTyp() + " : " + t.getWert());
            tokenliste.next();
        }

    }
    public List<Token> getTokenliste(){
        return tokenliste;
    }







}
