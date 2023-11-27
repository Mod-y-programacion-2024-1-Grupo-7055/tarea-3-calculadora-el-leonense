/**
 * La clase NodoResta representa la operación de resta en una expresión matemática.
 * Esta clase es un 'Composite' en el patrón de diseño Composite, ya que puede contener otros componentes.
 */
public class NodoResta extends NodoOperador {

    /** Operador para la operación de resta. */
    static final String OPERADOR_RESTA = "-";

    /** Precedencia de la operación de resta en la jerarquía de operaciones. */
    static final int PRECEDENCIA_RESTA = 1;

    /** Indica si la operación de resta es una operación binaria (verdadero) o unaria (falso). */
    static final boolean ES_BINARIO = true;

  
    

    /**
     * Constructor que toma dos operandos. 
     * Estos operandos son las expresiones que se restarán.
     *
     * @param operandoIzquierdo El primer operando de la resta.
     * @param operandoDerecho El segundo operando de la resta.
     */
    public NodoResta(Expresion operandoIzquierdo, Expresion operandoDerecho) {
        super(operandoIzquierdo, operandoDerecho);
    }

    public NodoResta() {
    }

    /**
     * La evaluación del nodo, resta las evaluaciones de los operandos.
     *
     * @return la resta de los operandos.
     */
    @Override
    public double evalua() {
        return operandoIzquierdo.evalua() - operandoDerecho.evalua();
    }

    /**
     * Devuelve una representación en cadena del operador y sus operandos.
     *
     * @return Una representación en cadena del operador y sus operandos.
     */
    @Override
    public String toString() {
        return "-";
    }

    @Override
    public String getOperador() {
        // TODO Auto-generated method stub
        return OPERADOR_RESTA;
    }

    @Override
    public int getPrecedencia() {
        return PRECEDENCIA_RESTA;
    }

    @Override
    public boolean esBinario() {
        // TODO Auto-generated method stub
        return ES_BINARIO;
    }
}