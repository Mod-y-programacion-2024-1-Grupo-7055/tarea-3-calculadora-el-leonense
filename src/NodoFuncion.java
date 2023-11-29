public class NodoFuncion implements Nodo {
    private String nombre;
    private Nodo argumento;

    public NodoFuncion(String nombre, Nodo argumento) {
        this.nombre = nombre;
        this.argumento = argumento;
    }

    @Override
    public double evaluar() {
        // Aquí deberías implementar la lógica para evaluar la función
        // Por ejemplo, si tu lenguaje de expresiones soporta las funciones "sqrt", "cos", "sin" y "tan", podrías hacer algo como esto:
        switch (nombre) {
            case "sqrt":
                return Math.sqrt(argumento.evaluar());
            case "cos":
                return Math.cos(argumento.evaluar());
            case "sin":
                return Math.sin(argumento.evaluar());
            case "tan":
                return Math.tan(argumento.evaluar());
            default:
                throw new IllegalArgumentException("Función desconocida: " + nombre);
        }
    }