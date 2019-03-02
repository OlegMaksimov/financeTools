package product;

import java.math.BigDecimal;

/**
 * Облигации
 */
public class Bound extends AbstractProduct {

    /* Процент по купону*/
    private Double cuponProcent;

    /* Стоимость купона */
    private Double cuponPrice;


    /**
     * Возвращает купонную доходность
     * @param countYear количество используемых лет
     * @return
     */
    public Double getYTM(int countYear){
        if (cuponPrice == null){
            getCuponPrice();
        }
        return cuponPrice/getDiscontProcentAllOfYear(countYear);

    }

    /**
     * возвращает стоимость купона
     * @return
     */
    public Double getCuponPrice() {
        if (cuponPrice == null) {
            if (cuponProcent != null) {
                cuponPrice = price == null ? 0 : price * 100 / cuponProcent;
            }
        }
        return cuponPrice;
    }

    public void setCuponPrice(Double cuponPrice) {
        this.cuponPrice = cuponPrice;
    }

    public Double getCuponProcent() {
        if (cuponProcent == null){
            if(cuponPrice != null){
                cuponProcent = cuponPrice/price;
            }
        }
        return cuponProcent;
    }

    public void setCuponProcent(Double cuponProcent) {
        this.cuponProcent = cuponProcent;
    }
}