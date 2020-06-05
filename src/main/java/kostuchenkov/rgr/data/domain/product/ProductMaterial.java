package kostuchenkov.rgr.data.domain.product;

public enum  ProductMaterial {
    TEXTILE,
    LEATHER,
    POLYESTER,
    SYNTHETIC;

    @Override
    public String toString() {
        if(this.equals(TEXTILE)) return "Текстиль";
        if(this.equals(LEATHER)) return "Кожа";
        if(this.equals(POLYESTER)) return "Полиэстер";
        else return "Синтетика";
    }
}
