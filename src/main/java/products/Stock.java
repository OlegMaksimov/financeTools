package product;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Акции
 */
public class Stock extends AbstractProduct {

    private Double dividendStock;

    /**
     * Возвращает ожидаемую доходность
     *
     * @param expectPrice ожидаемая цена
     * @return
     */
    public Double getExpectPrice(Double expectPrice) {
        return (dividendStock/price)+((expectPrice-price)/price);
    }

    /**
     * Диведендная доходность
     * дивидент === EPS
     * @return
     */
    public Double getStockYeild(){
        return dividendStock/price;
    }

    /**
     * Справедливая доходность акции
     * @param countYear количество лет использования
     * @return
     */
    public Double getFairYeld(int countYear){
        return IntStream.rangeClosed(1,countYear)
                .parallel()
                .mapToDouble(value -> dividendStock/getDiscontProcentAllOfYear(value))
                .sum();
    }

    /**
     * Модель Гордона. Возвращает величину дисконтирования с постоянны темпом роста
     * @param g - темп роста
     * @return
     */
    public Double getGordonModel(Double g){
        return dividendStock/(r-g);
    }

    public Double getDividendStock() {
        return dividendStock;
    }

    public void setDividendStock(Double dividendStock) {
        this.dividendStock = dividendStock;
    }
}
