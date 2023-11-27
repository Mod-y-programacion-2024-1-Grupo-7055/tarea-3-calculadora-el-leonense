/**
 * La clase NodoParentesis representa un paréntesis en una expresión matemática.
 * Esta clase es un 'Composite' en el patrón de diseño Composite, ya que puede contener otros componentes.
 */
public class NodoParentesis extends NodoOperador {

    /** Operador para el paréntesis. */
    static final String OPERADOR_PARENTESIS = "()";

    /** Precedencia de los paréntesis en la jerarquía de operaciones. */
    static final int PRECEDENCIA_PARENTESIS = 3;

    /** Indica si los paréntesis son una operación binaria (verdadero) o unaria (falso). */
    static final boolean ES_BINARIO = false;

    /**
     * Constructor que toma un operando. 
     * Este operando es la expresión dentro de los paréntesis.
     *
     * @param operando El operando dentro de los paréntesis.
     */
    public NodoParentesis(Expresion operando) {
        super(operando);
    }

    public NodoParentesis() {
    }

    /**
     * La evaluación del nodo, simplemente devuelve la evaluación del operando.
     *
     * @return la evaluación del operando.
     */
    @Override
    public double evalua() {
        return operandoIzquierdo.evalua();
    }

    /**
     * Devuelve una representación en cadena del paréntesis y su operando.
     *
     * @return Una representación en cadena del paréntesis y su operando.
     */
    @Override
    public String toString() {
        return "(" + operandoIzquierdo.toString() + ")";
    }

    @Override
    public String getOperador() {
        return OPERADOR_PARENTESIS;
    }

    @Override
    public int getPrecedencia() {
        return PRECEDENCIA_PARENTESIS;
    }

    @Override
    public boolean esBinario() {
        return ES_BINARIO;
    }
}