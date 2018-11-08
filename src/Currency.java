public enum Currency {
    RUB(1),
    USD(2),
    EUR(3);

    double course;

    Currency(double course) {
        this.course = course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    public double getCourse() {
        return course;
    }

    public double converter(double amount, Currency fromCurrency, Currency toCurrency){
        return amount*fromCurrency.getCourse()/toCurrency.getCourse();
    }

}
