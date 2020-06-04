package kostuchenkov.rgr.data.domain.product;

public enum ProductCategory {
    MAN,
    WOMAN,
    CHILD;

    @Override
    public String toString() {
        if(this.equals(MAN)) return "Мужчинам";
        if(this.equals(WOMAN)) return "Девушкам";
        else return "Детям";
    }
}
