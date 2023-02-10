package coe.unosquare.benefits.benefit;

public class ConditionAttributes {
    Integer quantity;
    Double amount;

    public ConditionAttributes(Integer quantity, Double amount) {
        this.quantity = quantity;
        this.amount = amount;
    }

    public ConditionAttributes(Double amount) {
        this.amount = amount;
    }

    public ConditionAttributes(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
