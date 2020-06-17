package kostuchenkov.rgr.model.domain.product;

public enum ProductSize {
    SIZE_30,
    SIZE_31,
    SIZE_32,
    SIZE_33,
    SIZE_34,
    SIZE_35,
    SIZE_36,
    SIZE_37,
    SIZE_38,
    SIZE_39,
    SIZE_40,
    SIZE_41,
    SIZE_42,
    SIZE_43,
    SIZE_44,
    SIZE_45,
    SIZE_46,
    SIZE_47;

    @Override
    public String toString() {
        if(this.equals(SIZE_30)) return "30";
        if(this.equals(SIZE_31)) return "31";
        if(this.equals(SIZE_32)) return "32";
        if(this.equals(SIZE_33)) return "33";
        if(this.equals(SIZE_34)) return "34";
        if(this.equals(SIZE_35)) return "35";
        if(this.equals(SIZE_36)) return "36";
        if(this.equals(SIZE_37)) return "37";
        if(this.equals(SIZE_38)) return "38";
        if(this.equals(SIZE_39)) return "39";
        if(this.equals(SIZE_40)) return "40";
        if(this.equals(SIZE_41)) return "41";
        if(this.equals(SIZE_42)) return "42";
        if(this.equals(SIZE_43)) return "43";
        if(this.equals(SIZE_44)) return "44";
        if(this.equals(SIZE_45)) return "45";
        if(this.equals(SIZE_46)) return "46";
        else return "47";
    }
}
