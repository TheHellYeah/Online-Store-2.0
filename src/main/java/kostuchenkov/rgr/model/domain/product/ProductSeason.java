package kostuchenkov.rgr.model.domain.product;

public enum ProductSeason {
    SUMMER,
    AUTUMN,
    WINTER,
    SPRING;

    @Override
    public String toString() {
        if(this.equals(SUMMER)) return "Лето";
        if(this.equals(AUTUMN)) return "Осень";
        if(this.equals(WINTER)) return "Зима";
        else return "Весна";
    }
}
