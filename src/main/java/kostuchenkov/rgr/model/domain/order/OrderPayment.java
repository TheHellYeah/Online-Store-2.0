package kostuchenkov.rgr.model.domain.order;

public enum OrderPayment {
    CASH,
    BALANCE;

    @Override
    public String toString() {
        if(this.equals(CASH)) return "Наличными";
        else return "Балансом";
    }

}
