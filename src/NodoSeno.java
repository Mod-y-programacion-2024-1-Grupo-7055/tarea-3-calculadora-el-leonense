/**
 * La clase NodoSeno representa la operación de seno en una expresión matemática.
 * Esta clase es un 'Composite' en el patrón de diseño Composite, ya que puede contener otros componentes.
 */
public class NodoSeno extends NodoOperador {

    /** Operador para la operación de seno. */
    static final String OPERADOR_SENO = "sin";

    /** Precedencia de la operación de seno en la jerarquía de operaciones. */
    static final int PRECEDENCIA_SENO = 4;

    /** Indica si la operación de seno es una operación binaria (verdadero) o unaria (falso). */
    static final boolean ES_BINARIO = false;

    /**
     * Constructor que toma un operando. 
     * Este operando es la expresión a la que se le calculará el seno.
     *
     * @param operando El operando del seno.
     */
    public NodoSeno(Expresion operando) {
        super(operando);
    }

    public NodoSeno() {
    }

    /**
     * La evaluación del nodo, calcula el seno del operando.
     *
     * @return el seno del operando.
     */
    @Override
    public double evalua() {
        return Math.sin(operandoIzquierdo.evalua());
    }

    /**
     * Devuelve una representación en cadena del operador y su operando.
     *
     * @return Una representación en cadena del operador y su operando.
     */
    @Override
    public String toString() {
        return "sin";
    }

    @Override
    public String getOperador() {
        return OPERADOR_SENO;
    }

    @Override
    public int getPrecedencia() {
        return PRECEDENCIA_SENO;
    }

    @Override
    public boolean esBinario() {
        return ES_BINARIO;
    }
}