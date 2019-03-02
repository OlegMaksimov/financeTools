package product;

import java.math.BigDecimal;

/**
 * Облигации
 */
public class Bound extends AbstractProduct {

    /* Стоимость купона */
    private Double cuponPrice;


    public Double getCuponValue(){

    }


    public Double getCuponPrice() {
        return cuponPrice;
    }

    public void setCuponPrice(Double cuponPrice) {
        this.cuponPrice = cuponPrice;
    }
}