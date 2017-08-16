package com.eltonlou.personalbudget.types;

import org.apache.commons.lang3.Validate;

import java.util.List;

/**
 * Abstract representation of a budgeting category.
 */

public abstract class Category {

    private final String name;
    private final List<Transaction> transactions;

    private Category(Builder builder) {
        this.name = Validate.notBlank(builder.name, "Name of the category should not be blank");
        this.transactions = Validate.notNull(builder.transactions, "Transactions cannot be null");
    }

    public String getName() {
        return name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public abstract static class Builder<T extends Builder<T>> {
        private String name;
        private List<Transaction> transactions;

        protected Builder() {
        }

        public T setName(String name) {
            this.name = name;
            return self();
        }

        public T addTransactions(List<Transaction> transactions) {
            this.transactions.addAll(transactions);
            return self();
        }

        public T setTransactions(List<Transaction> transactions) {
            this.transactions = transactions;
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
