package coe.unosquare.benefits.util.benefit;

/**
 * The type Condition attributes.
 */
public class ConditionAttributes {
    /**
     * The Quantity.
     */
    Integer quantity;
    /**
     * The Amount.
     */
    Double amount;

    /**
     * Instantiates a new Condition attributes.
     *
     * @param quantity the quantity
     * @param amount   the amount
     */
    public ConditionAttributes(Integer quantity, Double amount) {
        this.quantity = quantity;
        this.amount = amount;
    }

    /**
     * Instantiates a new Condition attributes.
     *
     * @param amount the amount
     */
    public ConditionAttributes(Double amount) {
        this.amount = amount;
    }

    /**
     * Instantiates a new Condition attributes.
     *
     * @param quantity the quantity
     */
    public ConditionAttributes(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
