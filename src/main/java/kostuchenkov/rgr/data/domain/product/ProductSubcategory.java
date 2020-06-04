package kostuchenkov.rgr.data.domain.product;

public enum ProductSubcategory {
    SNEAKERS,
    GUMSHOES,
    LOW_SHOES,
    SANDALS,
    SLIPPERS;

    @Override
    public String toString() {
        if(this.equals(SNEAKERS)) return "Кроссовки";
        if(this.equals(GUMSHOES)) return "Кеды";
        if(this.equals(LOW_SHOES)) return "Туфли";
        if(this.equals(SANDALS)) return "Сандали";
        else return "Шлёпанцы";
    }
}
