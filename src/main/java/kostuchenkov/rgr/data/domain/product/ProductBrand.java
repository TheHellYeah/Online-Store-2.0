package kostuchenkov.rgr.data.domain.product;

public enum ProductBrand {
    NIKE,
    ADIDAS,
    RIEKER,
    PUMA,
    RALPH_RINGER,
    CALVIN_KLEIN;

    @Override
    public String toString() {
        if(this.equals(NIKE)) return "Nike";
        if(this.equals(ADIDAS)) return "Adidas";
        if(this.equals(RIEKER)) return "Rieker";
        if(this.equals(PUMA)) return "Puma";
        if(this.equals(CALVIN_KLEIN)) return "Calvin Klein";
        else return "Ralph Ringer";
    }
}
