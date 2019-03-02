package product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Абстрактный класс всех финансовых продуктов
 */
public abstract class AbstractProduct {

    /* Наименование */
    protected String name;

    /* Стоимость */
    protected Double price = 0.00;

    /* коэфицент дисконтирования */
    protected Double r = 0.00;


    /**
     * Рассчет коэфицента дисконтирования
     * @param countYear
     * @return
     */
    protected    Double getDiscontProcentAllOfYear(int countYear){
        return Math.pow(1+r,countYear);
    }

    /**
     * Рассчет будущей стоимости
     * @param countYear количество лет использования актива
     * @return
     */
    protected Double getFutureValue(int countYear){
        return price * getDiscontProcentAllOfYear(countYear);
    }

    /**
     * Рассчет приведенной стоимости
     * @param countYear количество лет использования актива
     * @param futureValue стоимость актива в будущем через countYear
     * @return
     */
    protected Double getPV(int countYear,Double futureValue){
        this.r = (1/getDiscontProcentAllOfYear(countYear))*futureValue;
        return r;
    }

    /**
     * Возвращает чистую приведенную стоимость
     * @param countYear количество лет использования актива
     * @param futureValue стоимость актива в будущем через countYear
     * @return
     */
    protected Double getNPV(int countYear,Double futureValue){

        return getPV(countYear,futureValue) - price;
    }

    /**
     * Возвращает ожидаемую доходность
     * @param futureValue будущая стоимость актива
     * @return
     */
    protected Double getExcpectProcent(Double futureValue){
        return (futureValue - price)/price;
    }

    /**
     * Возвращает ожидаемую доходность
     * @param futureValue будущая стоимость актива
     * @return
     */
    protected Double getExcpectProcent(Double[] futureValue){
        Double middleCost =  Arrays.asList(futureValue).stream()
                .reduce((e1,e2)->e1+e2)
                .orElse(0.00)
                /futureValue.length;
        return getExcpectProcent(middleCost);
    }

    /**
     * Возвращает значение перпетуэтета
     * @param countYear количество лет использования актива
     * @return
     */
    protected Double getPerpetuity(int countYear){
        return (price/r)*getDiscontProcentAllOfYear(countYear);
    }

    /**
     * Возвращает значение аннуитета
     * @param countYear количество лет использования актива
     * @return
     */
    protected Double getAnnuity(int countYear){
        return price*(((1/r)-(1/(r*getDiscontProcentAllOfYear(countYear)))));
    }

    /**
     * вычисление сложного процента
     * @param m количество начислений в год
     * @return
     */
    protected Double getCompoutInterest(int m){
        return Math.pow(price+r/m,m)-price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
