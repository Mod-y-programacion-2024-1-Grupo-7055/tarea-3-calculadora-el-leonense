
/**
 * La clase abstracta NodoOperador representa un operador en una expresión matemática.
 * Esta clase implementa la interfaz Expresion y puede tener uno o dos operandos, dependiendo del operador.
 * Los operandos son también Expresiones, lo que permite construir árboles de expresiones complejas.
 * 
 * En el patrón de diseño Composite, NodoOperador es un "Composite", ya que puede contener otros componentes.
 * Los operandos (operandoIzquierdo y operandoDerecho) son los "componentes" en este patrón.
 * Pueden ser otros NodoOperador (otro Composite) o una implementación simple de Expresion (un "Leaf" en el patrón Composite).
 */
public abstract class NodoOperador implements CompositeEA {
    protected Expresion operandoIzquierdo;
    protected Expresion operandoDerecho;

    public abstract String getOperador();
    public abstract int getPrecedencia();
    public abstract boolean esBinario();

    
    

// Método factoryMethodOperadorNuevo
public static NodoOperador factoryMethodOperadorNuevo(String operador, Expresion operandoIzquierdo, Expresion operandoDerecho) {
    if (operador.equals("+")) {
        return new NodoSuma(operandoIzquierdo, operandoDerecho);
    } else if (operador.equals("-")) {
        return new NodoResta(operandoIzquierdo, operandoDerecho);
    } else if (operador.equals("*")) {
        return new NodoMultiplicacion(operandoIzquierdo, operandoDerecho);
    } else if (operador.equals("/")) {
        return new NodoDivision(operandoIzquierdo, operandoDerecho);
    } else if (operador.equals("sin")) {
        return new NodoSeno(operandoIzquierdo);
    } else if (operador.equals("tan")) {
        return new NodoTangente(operandoIzquierdo);
    } else {
        throw new IllegalArgumentException("Operador desconocido: " + operador);
    }
}

    /**
     * Constructor sin argumentos.
     */
    public NodoOperador() {
        this.operandoIzquierdo = null;
        this.operandoDerecho = null;
    }

        /**
     * Establece el operando izquierdo.
     *
     * @param operandoIzquierdo El operando izquierdo.
     */
    public void setOperandoIzquierdo(Expresion operandoIzquierdo) {
        this.operandoIzquierdo = operandoIzquierdo;
    }

    /**
     * Establece el operando derecho.
     *
     * @param operandoDerecho El operando derecho.
     */
    public void setOperandoDerecho(Expresion operandoDerecho) {
        this.operandoDerecho = operandoDerecho;
    }

    /**
     * Constructor para operadores binarios (operadores que toman dos operandos).
     *
     * @param operandoIzquierdo El primer operando del operador. Puede ser otro NodoOperador o una implementación simple de Expresion.
     * @param operandoDerecho El segundo operando del operador. Puede ser otro NodoOperador o una implementación simple de Expresion.
     */
    public NodoOperador(Expresion operandoIzquierdo, Expresion operandoDerecho) {
        this.operandoIzquierdo = operandoIzquierdo;
        this.operandoDerecho = operandoDerecho;
    }

    /**
     * Constructor para operadores unarios (operadores que toman un solo operando).
     *
     * @param operando El operando del operador. Puede ser otro NodoOperador o una implementación simple de Expresion.
     */
    public NodoOperador(Expresion operando) {
        this.operandoIzquierdo = operando;
        this.operandoDerecho = null;
    }

    /**
     * Evalúa el operando izquierdo y el operando derecho (si existe) y realiza la operación correspondiente.
     *
     * @return El resultado de evaluar el operando izquierdo y el operando derecho (si existe) y realizar la operación correspondiente.
     */
    @Override
    public abstract double evalua();

    /**
     * Devuelve el operando izquierdo.
     *
     * @return El operando izquierdo.
     */
    public Expresion getOperandoIzquierdo() {
        return operandoIzquierdo;
    }

    /**
     * Devuelve el operando derecho.
     *
     * @return El operando derecho.
     */

    public Expresion getOperandoDerecho() {
        return operandoDerecho;
    }

  
    /**
     * Devuelve una representación en cadena del operador.
     *
     * @return Una representación en cadena del operador.
     */
    @Override
    public String toString() {
        return String.format("%s", getPrecedencia());
    }

    /**
     * Devuelve una representación en cadena del operador y sus operandos.
     *
     * @return Una representación en cadena del operador y sus operandos.
     */
    public String toStringInOrder() {
        String operador = toString();
        if (operandoIzquierdo != null) {
            if (operandoIzquierdo instanceof NodoOperador) {
                operador = String.format("(%s %s)", ((NodoOperador) operandoIzquierdo).toStringPostOrder(), operador);
            } else {
                operador = String.format("(%s %s)", operandoIzquierdo.toString(), operador);
            }
        }
        if (operandoDerecho != null) {
            if (operandoDerecho instanceof NodoOperador) {
                operador = String.format("%s %s", operador, ((NodoOperador) operandoDerecho).toStringPostOrder());
            } else {
                operador = String.format("%s %s", operador, operandoDerecho.toString());
            }
        }
        return operador;
    }

    /**
     * Devuelve una representación en cadena del operador y sus operandos en notación postfija.
     * 
     * @return Una representación en cadena del operador y sus operandos en notación postfija.
     */
    public String toStringPostOrder() {
        String operador = toString();
        if (operandoIzquierdo != null && operandoIzquierdo instanceof NodoOperador) {
            operador = String.format("%s %s", ((NodoOperador) operandoIzquierdo).toStringPostOrder(), operador);
        }
        if (operandoDerecho != null && operandoDerecho instanceof NodoOperador) {
            operador = String.format("%s %s", operador, ((NodoOperador) operandoDerecho).toStringPostOrder());
        }
        return operador;
    }
    public int getPrecedence() {
        return 0;
    }



}