/**
 *
 * @author Oscar David Hernández Rodríguez <OscarHe@ciencias.unam.mx>
 */
public class NodoSeno extends NodoOperador {
    public NodoSeno() {
        super();
        precedence = 2;
    }

    @Override
    public double evalua() {
        throw new UnsupportedOperationException("No se puede evaluar un seno");
    }
}
