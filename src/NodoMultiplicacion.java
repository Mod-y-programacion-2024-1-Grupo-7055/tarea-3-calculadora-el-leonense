/**
 * La clase NodoMultiplicacion representa la operación de multiplicación en una expresión matemática.
 * Esta clase es un 'Composite' en el patrón de diseño Composite, ya que puede contener otros componentes.
 */
public class NodoMultiplicacion extends NodoOperador {

    /** Operador para la operación de multiplicación. */
    static final String OPERADOR_MULTIPLICACION = "*";

    /** Precedencia de la operación de multiplicación en la jerarquía de operaciones. */
    static final int PRECEDENCIA_MULTIPLICACION = 2;

    /** Indica si la operación de multiplicación es una operación binaria (verdadero) o unaria (falso). */
    static final boolean ES_BINARIO = true;

    /**
     * Constructor que toma dos operandos. 
     * Estos operandos son las expresiones que se multiplicarán.
     *
     * @param operandoIzquierdo El primer operando de la multiplicación.
     * @param operandoDerecho El segundo operando de la multiplicación.
     */
    public NodoMultiplicacion(Expresion operandoIzquierdo, Expresion operandoDerecho) {
        super(operandoIzquierdo, operandoDerecho);
    }

    public NodoMultiplicacion() {
    }

    /**
     * La evaluación del nodo, multiplica las evaluaciones de los operandos.
     *
     * @return la multiplicación de los operandos.
     */
    @Override
    public double evalua() {
        return operandoIzquierdo.evalua() * operandoDerecho.evalua();
    }

    /**
     * Devuelve una representación en cadena del operador y sus operandos.
     *
     * @return Una representación en cadena del operador y sus operandos.
     */
    @Override
    public String toString() {
        return "*";
    }

    @Override
    public String getOperador() {
        return OPERADOR_MULTIPLICACION;
    }

    @Override
    public int getPrecedencia() {
        return PRECEDENCIA_MULTIPLICACION;
    }

    @Override
    public boolean esBinario() {
        return ES_BINARIO;
    }
}