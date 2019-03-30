package product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import products.Stock;

import java.util.HashMap;
import java.util.Map;

class StockTest {

    Stock stock;

    @BeforeEach
    void setUp(){
        stock = new Stock();
    }

    @Test
    void getExpectPrice() {
    }

    @Test
    void getStockYeild() {
    }

    @Test
    void getFairYeld() {
        stock.setDividendStock(10.00);
        stock.setR(0.08);
        stock.setSaveCountYear(1);
        System.out.println(stock.getFairYeld());

    }

    @Test
    void getGordonModel() {
        stock.setDividendStock(10.00);
        stock.setR(0.08);
        stock.setPrice(stock.getGordonModel(0.05));
        System.out.println(stock.getPrice());
        stock.setR(0.05);
        stock.setPrice(15.00);
        stock.setSaveCountYear(4);
        System.out.println(stock.getFutureValue());
        System.out.println(stock.getNPV(489.7760));
    }

    @Test
    void getDividendStock() {
    }

    @Test
    void setDividendStock() {
        Map<Integer,Stock> stockMap = new HashMap();
        Double fairYield = 0.00;
        for (int i = 0; i <3 ; i++) {
            Stock stock = new Stock();
            stock.setName("stock"+(i+1));
            stock.setR(0.1);
            stockMap.put(i,stock);
        }
        stock = stockMap.get(0);
        stock.setDividendStock(10.00);
        fairYield = stock.getDividendStock()/stock.getR();
        System.out.println(stock.getName() + " " + fairYield);

        stock = stockMap.get(1);
        stock.setDividendStock(5.00);
        fairYield = stock.getGordonModel(0.04);
        System.out.println(stock.getName() + " " + fairYield);

        stock = stockMap.get(2);
        stock.setDividendStock(5d);
        stock.setR(0.07);
        stock.setDividendStock(stock.getDividendStock()*Math.pow(1.2,5));

        fairYield = stock.getDividendStock()/stock.getR();
        System.out.println(stock.getName() + " " + fairYield);
        System.out.println();


    }
}