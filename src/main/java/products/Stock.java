package products;

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
        return (dividendStock / getPrice()) + ((expectPrice - getPrice()) / getPrice());
    }

    /**
     * Диведендная доходность
     * дивидент === EPS
     * @return
     */
    public Double getStockYeild(){
        return dividendStock / getPrice();
    }

    /**
     * Справедливая доходность акции
     * @return
     */
    public Double getFairYeld() {
        return IntStream.rangeClosed(1, getSaveCountYear())
                .parallel()
                .mapToDouble(value -> dividendStock / getDiscontProcentAllOfYear())
                .sum();
    }

    /**
     * Модель Гордона. Возвращает величину дисконтирования с постоянны темпом роста
     * @param g - темп роста (ROE * коэф. реинвестирования)
     * @return
     */
    public Double getGordonModel(Double g){
        return dividendStock / (getR() - g);
    }


    public Double getDividendStock() {
        return dividendStock;
    }

    public void setDividendStock(Double dividendStock) {
        this.dividendStock = dividendStock;
    }
}
