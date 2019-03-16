package products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoundTest {
    private Bound bound;

    @BeforeEach
    void setUp() {
        bound = new Bound();
    }

    @Test
    void getYTM() {
        bound.setPrice(100.00);
        bound.setCuponProcent(5.375);
        bound.setSaveCountYear(6);
        Assertions.assertEquals(3.8, bound.getYTM());

    }
}