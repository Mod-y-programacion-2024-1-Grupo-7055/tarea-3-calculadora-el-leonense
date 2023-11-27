    /**
     * La clase NodoTangente representa la operación de tangente en una expresión matemática.
     * Esta clase es un 'Composite' en el patrón de diseño Composite, ya que puede contener otros componentes.
     */
    public class NodoTangente extends NodoOperador {

        /** Operador para la operación de tangente. */
        static final String OPERADOR_TANGENTE = "tan";

        /** Precedencia de la operación de tangente en la jerarquía de operaciones. */
        static final int PRECEDENCIA_TANGENTE = 4;

        /** Indica si la operación de tangente es una operación binaria (verdadero) o unaria (falso). */
        static final boolean ES_BINARIO = false;

        /**
         * Constructor que toma un operando. 
         * Este operando es la expresión a la que se le calculará la tangente.
         *
         * @param operando El operando de la tangente.
         */
        
        public NodoTangente(Expresion operando) {
            super(operando);
        }

        public NodoTangente() {
        }

        /**
         * La evaluación del nodo, calcula la tangente del operando.
         *
         * @return la tangente del operando.
         */
        @Override
        public double evalua() {
            return Math.tan(operandoIzquierdo.evalua());
        }

        /**
         * Devuelve una representación en cadena del operador y su operando.
         *
         * @return Una representación en cadena del operador y su operando.
         */
        @Override
        public String toString() {
            return "tan";
        }

        @Override
        public String getOperador() {
            return OPERADOR_TANGENTE;
        }

        @Override
        public int getPrecedencia() {
            return PRECEDENCIA_TANGENTE;
        }

        @Override
        public boolean esBinario() {
            return ES_BINARIO;
        }
    }