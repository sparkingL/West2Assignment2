import java.time.LocalDate;

public class Beer extends Drinks{
    private static final int expirationDate=30;//保质期
    private float alcoholDegree;//酒精度数
    public Beer() {
    }

    public Beer(String name, double cost, LocalDate productionDate, int expirationDate, float alcoholDegree) {
        super(name, cost, productionDate, expirationDate);
        this.alcoholDegree = alcoholDegree;
    }

    @Override
    public boolean isOverDue(LocalDate productionDate) {
        return super.isOverDue(productionDate);
    }

    public float getAlcoholDegree() {
        return alcoholDegree;
    }

    public void setAlcoholDegree(float alcoholDegree) {
        this.alcoholDegree = alcoholDegree;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "degrees=" + alcoholDegree +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", manufacture=" + productionDate +
                ", quality=" + expirationDate +
                '}';
    }
}
