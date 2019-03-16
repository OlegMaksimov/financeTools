package products;

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
     * @return купонная доходность
     */
    public Double getYTM() {
        if (cuponPrice == null){
            getCuponPrice();
        }
        return cuponPrice / getDiscontProcentAllOfYear();

    }

    /**
     * возвращает стоимость купона
     * @return
     */
    public Double getCuponPrice() {
        if (cuponPrice == null) {
            if (cuponProcent != null) {
                cuponPrice = this.getPrice() == null ? 0 : this.getPrice() * 100 / cuponProcent;
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
                cuponProcent = cuponPrice / this.getPrice();
            }
        }
        return cuponProcent;
    }

    public void setCuponProcent(Double cuponProcent) {
        this.cuponProcent = cuponProcent;
    }
}