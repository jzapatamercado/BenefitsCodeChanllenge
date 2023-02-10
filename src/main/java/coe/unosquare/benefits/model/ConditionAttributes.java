package coe.unosquare.benefits.model;

/**
 * The type Condition attributes.
 * This class could allow us to manage multiple attributes
 * in initial approach we were able to handle or quantity or amount,
 * based on this new class we can handle these two combined or include more attributes to be evaluated.
 */
public class ConditionAttributes {
    /**
     * The Quantity.
     */
    private Integer quantity;
    /**
     * The Amount.
     */
    private Double amount;

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
