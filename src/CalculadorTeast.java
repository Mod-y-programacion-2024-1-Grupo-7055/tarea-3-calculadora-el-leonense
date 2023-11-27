import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

class CalculadoraTest {

    @Test
    void testAnalisisLexico() {
        // Crear una instancia de la clase que estás probando
        Calculadora calculadora = new Calculadora();

        // Llamar al método que quieres probar
        List<String> resultado = calculadora.analisisLexico("1 + 1");

        // Usar una aserción para verificar que el resultado es el esperado
        assertEquals(Arrays.asList("1", "+", "1"), resultado);
    }

    // Puedes agregar más métodos de prueba aquí
}