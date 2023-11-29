public class NodoOperador implements Nodo {
    private String operador;
    private Nodo izquierdo;
    private Nodo derecho;

    public NodoOperador(String operador, Nodo izquierdo, Nodo derecho) {
        this.operador = operador;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    @Override
    public double evaluar() {
        switch (operador) {
            case "+":
                return izquierdo.evaluar() + derecho.evaluar();
            case "-":
                return izquierdo.evaluar() - derecho.evaluar();
            case "*":
                return izquierdo.evaluar() * derecho.evaluar();
            case "/":
                return izquierdo.evaluar() / derecho.evaluar();
            default:
                throw new IllegalArgumentException("Operador desconocido: " + operador);
        }
    }

    @Override
    public String toString() {
        return "(" + izquierdo + " " + operador + " " + derecho + ")";
    }
}