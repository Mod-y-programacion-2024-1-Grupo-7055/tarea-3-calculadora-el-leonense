import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexico {

    public List<Token> analizar(String expresion) {
        List<Token> tokens = new ArrayList<>();
        
        String patron = "(\\d+\\.\\d+)|(\\d+)|([+\\-*/()])|sqrt|sin|cos|tan";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(expresion);

        while (matcher.find()) {
            String lexema = matcher.group();
            tokens.add(new Token(lexema, obtenerTipoToken(lexema)));
        }

        return tokens;
    }

    private TipoToken obtenerTipoToken(String lexema) {
        if (lexema.matches("\\d+\\.\\d+|\\d+")) {
            return TipoToken.NUMERO;
        } else if (lexema.matches("[+\\-*/()]")) {
            return TipoToken.OPERADOR;
        } else if (lexema.equals("sqrt") || lexema.equals("sin") || lexema.equals("cos") || lexema.equals("tan")) {
            return TipoToken.FUNCION;
        } else {
            return TipoToken.DESCONOCIDO;
        }
    }
}
