/**
 *
 * @author Oscar David Hernández Rodríguez <OscarHe@ciencias.unam.mx>
 */
public class NodoTangente extends NodoOperador {
    public NodoTangente() {
        super();
        precedence = 2;
    }

    @Override
    public double evalua() {
        throw new UnsupportedOperationException("No se puede evaluar una tangente");
    }
}