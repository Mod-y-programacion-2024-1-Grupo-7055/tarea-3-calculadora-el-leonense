/**
 * La clase NodoSuma representa la operación de suma en una expresión matemática.
 * Esta clase es un 'Composite' en el patrón de diseño Composite, ya que puede contener otros componentes.
 */
public class NodoSuma extends NodoOperador {

    /** Operador para la operación de suma. */
    static final String OPERADOR_SUMA = "+";

    /** Precedencia de la operación de suma en la jerarquía de operaciones. */
    static final int PRECEDENCIA_SUMA = 1;

    /** Indica si la operación de suma es una operación binaria (verdadero) o unaria (falso). */
    static final boolean ES_BINARIO = true;

    /**
     * Constructor que toma dos operandos. 
     * Estos operandos son las expresiones que se sumarán.
     *
     * @param operandoIzquierdo El primer operando de la suma.
     * @param operandoDerecho El segundo operando de la suma.
     */
    public NodoSuma(Expresion operandoIzquierdo, Expresion operandoDerecho) {
        super(operandoIzquierdo, operandoDerecho);
    }

    public NodoSuma() {
    }

    /**
     * La evaluación del nodo, suma las evaluaciones de los operandos.
     *
     * @return la suma de los operandos.
     */
    @Override
    public double evalua() {
        return operandoIzquierdo.evalua() + operandoDerecho.evalua();
    }

    /**
     * Devuelve una representación en cadena del operador y sus operandos.
     *
     * @return Una representación en cadena del operador y sus operandos.
     */
    @Override
    public String toString() {
        return "+";
    }

    @Override
    public String getOperador() {
        return OPERADOR_SUMA;
    }

    @Override
    public int getPrecedencia() {
        return PRECEDENCIA_SUMA;
    }

    @Override
    public boolean esBinario() {
        return ES_BINARIO;
    }
}