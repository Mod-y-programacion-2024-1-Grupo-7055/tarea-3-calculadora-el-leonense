/**
 * La clase NodoDivision representa la operación de división en una expresión matemática.
 * Esta clase es un 'Composite' en el patrón de diseño Composite, ya que puede contener otros componentes.
 */
public class NodoDivision extends NodoOperador {

    /** Operador para la operación de división. */
    static final String OPERADOR_DIVISION = "/";

    /** Precedencia de la operación de división en la jerarquía de operaciones. */
    static final int PRECEDENCIA_DIVISION = 2;

    /** Indica si la operación de división es una operación binaria (verdadero) o unaria (falso). */
    static final boolean ES_BINARIO = true;

    /**
     * Constructor que toma dos operandos. 
     * Estos operandos son las expresiones que se dividirán.
     *
     * @param operandoIzquierdo El primer operando de la división.
     * @param operandoDerecho El segundo operando de la división.
     */
    public NodoDivision(Expresion operandoIzquierdo, Expresion operandoDerecho) {
        super(operandoIzquierdo, operandoDerecho);
    }

    public NodoDivision() {
    }

    /**
     * La evaluación del nodo, divide las evaluaciones de los operandos.
     *
     * @return la división de los operandos.
     */
    @Override
    public double evalua() {
        if (operandoDerecho.evalua() == 0) {
            throw new ArithmeticException("División por cero");
        }
        return operandoIzquierdo.evalua() / operandoDerecho.evalua();
    }

    /**
     * Devuelve una representación en cadena del operador y sus operandos.
     *
     * @return Una representación en cadena del operador y sus operandos.
     */
    @Override
    public String toString() {
        return "/";
    }

    @Override
    public String getOperador() {
        return OPERADOR_DIVISION;
    }

    @Override
    public int getPrecedencia() {
        return PRECEDENCIA_DIVISION;
    }

    @Override
    public boolean esBinario() {
        return ES_BINARIO;
    }
}