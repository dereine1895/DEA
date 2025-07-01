import utils.*;

public class Token {

    private String wert;
    private String typ;

    public Token(String pWert, String pTyp){
        this.wert = pWert;
        this.typ = pTyp;
    }
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getWert() {
        return wert;
    }

    public void setWert(String wert) {
        this.wert = wert;
    }

}
