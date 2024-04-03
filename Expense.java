
abstract class Expense {
    private String category;
    private Amount amount;
    private Date date;
    private String description;

    public Expense(String category, Amount amount, Date date, String description) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public Amount getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public abstract double calculateTax();
}

class FoodExpense extends Expense {
    public FoodExpense(String category, Amount amount, Date date, String description) {
        super(category, amount, date, description);
    }

    @Override
    public double calculateTax() {
        return getAmount().getValue() * 0.05; // 5% tax rate
    }
}

class TravelExpense extends Expense {
    public TravelExpense(String category, Amount amount, Date date, String description) {
        super(category, amount, date, description);
    }

    @Override
    public double calculateTax() {
        return getAmount().getValue() * 0.1; // 10% tax rate
    }
}

class Amount {
    private double value;

    public Amount(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

class Date {
    private String value;

    public Date(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
