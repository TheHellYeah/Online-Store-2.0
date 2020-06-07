package kostuchenkov.rgr.model.domain.order;

public enum OrderStatus {
    DELIVERED,
    IN_TRANSIT,
    PENDING;

    @Override
    public String toString() {
        if(this.equals(DELIVERED)) return "Доставлен";
        if(this.equals(IN_TRANSIT)) return "Передано доставке";
        else return "Выполняется";
    }
}
