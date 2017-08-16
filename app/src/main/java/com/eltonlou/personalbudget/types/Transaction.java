package com.eltonlou.personalbudget.types;

import org.apache.commons.lang3.Validate;

/**
 * Encapsulates the metadata of a day-to-day transcation (expense or income)
 */

public final class Transaction {
    private final String date;
    private final Double amount;
    private final String description;

    private Transaction(Builder builder) {
        this.date = Validate.notBlank(builder.date, "Date should not be blank");
        this.amount = Validate.notNull(builder.amount, "Amount should not be null");
        this.description = Validate.notNull(builder.description, "Description should not be blank");
    }

    public String getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public abstract static class Builder<T extends Builder<T>> {
        private String date;
        private Double amount;
        private String description;

        protected Builder() {
        }

        public T setDate(String date) {
            this.date = date;
            return self();
        }

        public T setAmount(Double amount) {
            this.amount = amount;
            return self();
        }

        public T setDescription(String description) {
            this.description = description;
            return self();
        }

        protected abstract T self();
    }

    public static class ConcreteBuilder extends Builder<ConcreteBuilder> {
        @Override
        protected ConcreteBuilder self() {
            return this;
        }
    }

    public static Builder<?> builder() {
        return new ConcreteBuilder();
    }
}
