public class Token {
    private String lexema;
    private TipoToken tipo;

    public Token(String lexema, TipoToken tipo) {
        this.lexema = lexema;
        this.tipo = tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public TipoToken getTipo() {
        return tipo;
    }
}