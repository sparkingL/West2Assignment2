import java.time.*;

public class Juice extends Drinks{
    private static final int expirationDate=2;

    public Juice() {
    }

    public Juice(String name, double cost, LocalDate productionDate, int expirationDate) {
        super(name, cost, productionDate, expirationDate);
    }

    @Override
    public boolean isOverDue(LocalDate productionDate) {
        return super.isOverDue(productionDate);
    }

    @Override
    public String toString() {
        return "Juice{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", productionDate=" + productionDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
