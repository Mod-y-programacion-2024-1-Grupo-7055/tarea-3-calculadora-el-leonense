/**
 * La clase NodoCoseno representa la operación de coseno en una expresión matemática.
 * Esta clase es un 'Composite' en el patrón de diseño Composite, ya que puede contener otros componentes.
 */
public class NodoCoseno extends NodoOperador {

    /** Operador para la operación de coseno. */
    static final String OPERADOR_COSENO = "cos";

    /** Precedencia de la operación de coseno en la jerarquía de operaciones. */
    static final int PRECEDENCIA_COSENO = 4;

    /** Indica si la operación de coseno es una operación binaria (verdadero) o unaria (falso). */
    static final boolean ES_BINARIO = false;

    /**
     * Constructor que toma un operando. 
     * Este operando es la expresión a la que se le calculará el coseno.
     *
     * @param operando El operando del coseno.
     */
    public NodoCoseno(Expresion operando) {
        super(operando);
    }

    public NodoCoseno() {
    }

    /**
     * La evaluación del nodo, calcula el coseno del operando.
     *
     * @return el coseno del operando.
     */
    @Override
    public double evalua() {
        return Math.cos(operandoIzquierdo.evalua());
    }

    /**
     * Devuelve una representación en cadena del operador y su operando.
     *
     * @return Una representación en cadena del operador y su operando.
     */
    @Override
    public String toString() {
        return "cos";
    }

    @Override
    public String getOperador() {
        return OPERADOR_COSENO;
    }

    @Override
    public int getPrecedencia() {
        return PRECEDENCIA_COSENO;
    }

    @Override
    public boolean esBinario() {
        return ES_BINARIO;
    }
}