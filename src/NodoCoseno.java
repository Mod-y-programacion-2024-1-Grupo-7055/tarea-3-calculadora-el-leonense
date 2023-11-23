/**
 *
 * @author Oscar David Hernández Rodríguez <OscarHe@ciencias.unam.mx>
 */
public class NodoCoseno extends NodoOperador {
    public NodoCoseno() {
        super();
        precedence = 2;
    }

    @Override
    public double evalua() {
        throw new UnsupportedOperationException("No se puede evaluar un coseno");
    }
}
