import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    private double balance = 1000000;
    private static final List<Drinks> beerList;
    private static final List<Drinks> juiceList;
    private static final List<SetMeal> mealList;

    private static ArrayList<Beer> beerStore;
    private static ArrayList<Juice> juiceStore;
    private static ArrayList<SetMeal> mealStore;

    public static ArrayList<SetMeal> getMealList() {
        return (ArrayList<SetMeal>) mealList;
    }

    public static ArrayList<Beer> getBeerStore() {
        return beerStore;
    }
    public static ArrayList<Juice> getJuiceStore() {
        return juiceStore;
    }
    public static ArrayList<SetMeal> getMealStore() {
        return mealStore;
    }

    public double getBalance() {
        return balance;
    }

    static {
        //使用ArrayList 是因为列表长度已经固定，而访问列表时 ArrayList速度优于LinkedList

        juiceList = new ArrayList<>();
        beerList = new ArrayList<>();
        mealList = new ArrayList<>();

        beerStore = new ArrayList<>();
        juiceStore = new ArrayList<>();
        mealStore = new ArrayList<>();

        Drinks juice1 = new Juice("葡萄汁", 6, LocalDateTime.now().toLocalDate(), 2);
        Drinks juice2 = new Juice("橙汁", 4, LocalDateTime.now().toLocalDate(), 2);
        Drinks juice3 = new Juice("苹果汁", 5, LocalDateTime.now().toLocalDate(), 2);
        Drinks juice4 = new Juice("西瓜汁", 4, LocalDateTime.now().toLocalDate(), 2);

        juiceList.add(juice1);
        juiceList.add(juice2);
        juiceList.add(juice3);
        juiceList.add(juice4);
        Drinks beer1 = new Beer("百威", 5, LocalDateTime.now().toLocalDate(), 30, 10);
        Drinks beer2 = new Beer("江小白", 36, LocalDateTime.now().toLocalDate(), 3, 45);
        Drinks beer3 = new Beer("莫斯卡托", 99, LocalDateTime.now().toLocalDate(), 30, 7);

        beerList.add(beer1);
        beerList.add(beer2);
        beerList.add(beer3);

        SetMeal meal1 = new SetMeal("1", 16, "炸鸡一号", juice1);
        SetMeal meal2 = new SetMeal("2", 11, "炸鸡一号", juice3);
        SetMeal meal3 = new SetMeal("3", 103, "炸鸡二号", beer3);
        SetMeal meal4 = new SetMeal("4", 56, "炸鸡三号", beer2);
        SetMeal meal5 = new SetMeal("5", 15, "炸鸡一号", beer1);

        mealList.add(meal1);
        mealList.add(meal2);
        mealList.add(meal3);
        mealList.add(meal4);
        mealList.add(meal5);


    }

    private void use(Beer b) {
        int count = 0;
        boolean flag = count < beerStore.size();
        if (flag) {
            for (Beer tempBeer : beerStore) {
                //找到酒则从仓库中删除
                if (tempBeer.getName().equals(b.getName())) {
                    beerStore.remove(tempBeer);
                    System.out.println("购买成功!");
                    break;
                }
                //否则继续搜索直至遍历仓库内存
                count++;
            }
        } else {
            throw new IngredientSortOutException("该酒已售完");
        }
    }

    private void use(Juice j) {
        int count = 0;
        boolean flag = count < juiceStore.size();
        if (flag) {
            for (Juice tempJuice : juiceStore) {
                //找到果汁则从仓库中删除
                if (tempJuice.getName().equals(j.getName())) {
                    beerStore.remove(tempJuice);
                    System.out.println("购买成功!");
                    break;
                }

                count++;
            }
        } else {
            throw new IngredientSortOutException("该果汁已售完");
        }

    }

    @Override
    public void sellSetMeal(SetMeal meal) {
        for (SetMeal tempMeal : mealStore) {
            //售出的套餐从仓库中删除，余额增加
            if (tempMeal.getSetMealName().equals(meal.getSetMealName())) {
                mealStore.remove(tempMeal);
                balance += meal.price;
                break;
            }
        }
        if (meal.getDrink() instanceof Beer) {
            use((Beer) meal.getDrink());
        } else if (meal.getDrink() instanceof Juice) {
            use((Juice) meal.getDrink());
        }
    }

    @Override
    public void mealPurchase(int amount, SetMeal meal) {
        boolean flag = balance > meal.getPrice() * amount;
        int count = 0;
        if (flag) {
            balance -= meal.price * amount;
            //批量进同一套餐，加入仓库中
            for (; count < amount; count++) {
                mealStore.add(meal);
                Drinks drink = meal.getDrink();
                drinkPurchase(drink);
            }
            System.out.println("已进货");
        } else {
            int priceDifference = (int) (meal.getPrice() * count - balance);
            throw new OverdraftBalanceException("余额不足，还差" + priceDifference);
        }

    }

    @Override
    public void drinkPurchase(Drinks drink) {
        //判断饮料是酒还是果汁
        if (drink instanceof Beer) {
            beerStore.add((Beer) drink);
        } else if (drink instanceof Juice) {
            juiceStore.add((Juice) drink);
        }
    }
}
