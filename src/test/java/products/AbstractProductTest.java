package products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractProductTest {
    private Deposit product;

    @BeforeEach
    void setUp() {
        product = new Deposit();
    }

    @Test
    void getFutureValue() {
        product.setPrice(100.00);
        product.setR(0.05);
        Assertions.assertEquals(105.00, product.getFutureValue());
    }

    @Test
    void getPV() {
        product.setR(0.05);
        product.setSaveCountYear(2);
        Assertions.assertEquals(100.00, Math.round(product.getPV(110.25)));
    }

    @Test
    void getNPV() {
        product.setPrice(370.00);
        product.setR(0.05);
        product.setSaveCountYear(1);
        Assertions.assertEquals(30.00, Math.round(product.getNPV(420.00)));

    }

    @Test
    void checkProduct() {
        Deposit investProject = new Deposit();
        investProject.setPrice(100000.00);
        Deposit stockProject = new Deposit();
        stockProject.setPrice(95.65);
        Double investProjectExcpectProcent = investProject.getExcpectProcent(new Double[]{80000.00, 110000.00, 140000.00});
        Double stockProjectExcpectProcent = stockProject.getExcpectProcent(110d);
        System.out.println(investProjectExcpectProcent);
        System.out.println(stockProjectExcpectProcent);
        Assertions.assertTrue(stockProjectExcpectProcent > investProjectExcpectProcent);

    }

    @Test
    void getcompoutInterest() {
        product.setPrice(1.00);
        product.setR(0.06);
        System.out.println(product.getCompoutInterest(4));
    }
}

