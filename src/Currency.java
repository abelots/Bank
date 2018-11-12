public enum Currency {
    RUB(1),
    USD(2),
    EUR(3);

    double rate;

    Currency(double rate) {
        this.rate = rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public double converter(double amount, Currency fromCurrency, Currency toCurrency){
        return amount*fromCurrency.getRate()/toCurrency.getRate();
    }

}
