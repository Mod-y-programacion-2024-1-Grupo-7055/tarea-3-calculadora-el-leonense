import java.util.List;

public class Sintactico {

    private List<Token> tokens;
    private int index;

    public CompositeEA analizar(List<Token> tokens) throws ErrorDeSintaxisException {
        this.tokens = tokens;
        this.index = 0;
        return expresion();
    }

    private CompositeEA expresion() throws ErrorDeSintaxisException {
        CompositeEA resultado = termino();
        while (puedeConsume("+") || puedeConsume("-")) {
            String operador = tokens.get(index - 1).getLexema();
            CompositeEA siguienteTermino = termino();
            resultado = new NodoOperador(operador, resultado, siguienteTermino);
        }
        return resultado;
    }

    private CompositeEA termino() throws ErrorDeSintaxisException {
        CompositeEA resultado = factor();
        while (puedeConsume("*") || puedeConsume("/")) {
            String operador = tokens.get(index - 1).getLexema();
            CompositeEA siguienteFactor = factor();
            resultado = new NodoOperador(operador, resultado, siguienteFactor);
        }
        return resultado;
    }

    private CompositeEA factor() throws ErrorDeSintaxisException {
        if (puedeConsume("(")) {
            CompositeEA expresionParentesis = expresion();
            consume(")");
            return expresionParentesis;
        } else if (puedeConsumeFuncion()) {
            String funcion = tokens.get(index - 1).getLexema();
            consume("(");
            CompositeEA argumento = expresion();
            consume(")");
            return new NodoFuncion(funcion, argumento);
        } else if (puedeConsumeNumero()) {
            return new NodoValor(Double.parseDouble(tokens.get(index - 1).getLexema()));
        } else {
            throw new ErrorDeSintaxisException("Factor inesperado: " + tokens.get(index).getLexema());
        }
    }

    // Métodos de utilidad
    private boolean puedeConsume(String esperado) {
        if (index < tokens.size() && tokens.get(index).getLexema().equals(esperado)) {
            index++;
            return true;
        }
        return false;
    }

    private boolean puedeConsumeFuncion() {
        if (index < tokens.size() && tokens.get(index).getTipo() == TipoToken.FUNCION) {
            index++;
            return true;
        }
        return false;
    }

    private boolean puedeConsumeNumero() {
        if (index < tokens.size() && tokens.get(index).getTipo() == TipoToken.NUMERO) {
            index++;
            return true;
        }
        return false;
    }

    private void consume(String esperado) throws ErrorDeSintaxisException {
        if (puedeConsume(esperado)) {
            return;
        }
        throw new ErrorDeSintaxisException("Se esperaba '" + esperado + "' pero se encontró: " + tokens.get(index).getLexema());
    }
}
