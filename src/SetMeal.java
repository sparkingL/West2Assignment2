public class SetMeal {
     String setMealName;//套餐名
     double price;//价格
     String firedChickenName;//炸鸡名
     Drinks drink;//饮料

    public SetMeal() {
    }

    public SetMeal(String setMealName, double price, String firedChickenName, Drinks drink) {
        this.setMealName = setMealName;
        this.price = price;
        this.firedChickenName = firedChickenName;
        this.drink = drink;
    }

    public String getSetMealName() {
        return setMealName;
    }

    public void setSetMealName(String setMealName) {
        this.setMealName = setMealName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFiredChickenName() {
        return firedChickenName;
    }

    public void setFiredChickenName(String firedChickenName) {
        this.firedChickenName = firedChickenName;
    }

    public Drinks getDrink() {
        return drink;
    }

    public void setDrink(Drinks drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "SetMeal{" +
                "setMealName='" + setMealName + '\'' +
                ", price=" + price +
                ", firedChickenName='" + firedChickenName + '\'' +
                ", drink=" + drink +
                '}';
    }
}
