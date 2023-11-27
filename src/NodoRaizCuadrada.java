/**
 * La clase NodoRaizCuadrada representa la operación de raíz cuadrada en una expresión matemática.
 * Esta clase es un 'Composite' en el patrón de diseño Composite, ya que puede contener otros componentes.
 */
public class NodoRaizCuadrada extends NodoOperador {

    /** Operador para la operación de raíz cuadrada. */
    static final String OPERADOR_RAIZ = "sqrt";

    /** Precedencia de la operación de raíz cuadrada en la jerarquía de operaciones. */
    static final int PRECEDENCIA_RAIZ = 2;

    /** Indica si la operación de raíz cuadrada es una operación binaria (verdadero) o unaria (falso). */
    static final boolean ES_BINARIO = false;

    /**
     * Constructor que toma un operando. 
     * Este operando es la expresión a la que se le aplicará la raíz cuadrada.
     *
     * @param operando El operando de la raíz cuadrada.
     */
    public NodoRaizCuadrada(Expresion operando) {
        super(operando);
    }

    public NodoRaizCuadrada() {
    }

    /**
     * La evaluación del nodo, calcula la raíz cuadrada del operando.
     *
     * @return la raíz cuadrada del operando.
     */
    @Override
    public double evalua() {
        if (operandoIzquierdo == null) {
            throw new IllegalStateException("No se ha proporcionado un operando para la raíz cuadrada");
        }
        return Math.sqrt(operandoIzquierdo.evalua());
    }

    /**
     * Devuelve una representación en cadena del operador y su operando.
     *
     * @return Una representación en cadena del operador y su operando.
     */
    @Override
    public String toString() {
        return "sqrt";
    }

    @Override
    public String getOperador() {
        return OPERADOR_RAIZ;
    }

    @Override
    public int getPrecedencia() {
        return PRECEDENCIA_RAIZ;
    }

    @Override
    public boolean esBinario() {
        return ES_BINARIO;
    }
}