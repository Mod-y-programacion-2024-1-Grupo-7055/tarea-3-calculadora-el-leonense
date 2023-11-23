/**
 *
 * @author Oscar David Hernández Rodríguez <OscarHe@ciencias.unam.mx>
 */
public class NodoRaizCuadrada extends NodoOperador {
    public NodoRaizCuadrada() {
        super();
        precedence = 2;
    }

    @Override
    public double evalua() {
        throw new UnsupportedOperationException("No se puede evaluar una raíz cuadrada");
    }
}