import java.time.*;

public abstract class Drinks<LocaleDate> {
    protected String name;//名称
    protected double cost;//成本
    protected LocalDate productionDate;//生产日期
    protected int expirationDate;//保质期

    public Drinks() {
    }

    public Drinks(String name, double cost, LocalDate productionDate, int expirationDate) {
        this.name = name;
        this.cost = cost;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
    }

    public boolean isOverDue(LocalDate productionDate){
        LocalDate now=LocalDate.now();
        long count=now.toEpochDay()-productionDate.toEpochDay();
        return count>expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public abstract String toString() ;
}
