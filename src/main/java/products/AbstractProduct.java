package products;

import java.util.Arrays;

/**
 * Абстрактный класс всех финансовых продуктов
 */
public abstract class AbstractProduct implements Product {

    /* Наименование */
    private String name;

    /* Стоимость */
    private Double price = 0.00;

    /* коэфицент дисконтирования */
    private Double r = 0.00;

    /* Количество лет хранения */
    private int saveCountYear;


    public Double getDiscontProcentAllOfYear() {
        return Math.pow(1 + this.r, this.saveCountYear);
    }

    public Double getFutureValue() {
        return this.price * getDiscontProcentAllOfYear();
    }

    public Double getPV(Double futureValue) {
        this.r = (1 / getDiscontProcentAllOfYear()) * futureValue;
        return this.r;
    }

    public Double getNPV(Double futureValue) {

        return getPV(futureValue) - this.price;
    }

    public Double getExcpectProcent(Double futureValue) {
        return (futureValue - this.price) / this.price;
    }

    public Double getExcpectProcent(Double[] futureValue) {
        Double middleCost = Arrays.asList(futureValue).stream()
                .reduce((e1, e2) -> e1 + e2)
                .orElse(0.00)
                / futureValue.length;
        return getExcpectProcent(middleCost);
    }

    public Double getPerpetuity() {
        return (this.price / this.r) * getDiscontProcentAllOfYear();
    }

    public Double getAnnuity() {
        return this.price * (((1 / this.r) - (1 / (this.r * getDiscontProcentAllOfYear()))));
    }

    public Double getCompoutInterest(int m) {
        return Math.pow(this.price + this.r / m, m) - this.price;
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

    public int getSaveCountYear() {
        return saveCountYear;
    }

    public void setSaveCountYear(int saveCountYear) {
        this.saveCountYear = saveCountYear;
    }
}
