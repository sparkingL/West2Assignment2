import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        West2FriedChickenRestaurant restaurant=new West2FriedChickenRestaurant();

        ArrayList<Beer> beerStore=restaurant.getBeerStore();
        ArrayList<Juice> juiceStore=restaurant.getJuiceStore();
        ArrayList<SetMeal> mealStore=restaurant.getMealStore();
        ArrayList<SetMeal> mealList=restaurant.getMealList();

        Scanner sc=new Scanner(System.in);
        System.out.println("选择服务: ");
        System.out.print(" 1:进货 ");
        System.out.print(" 2.销售 ");
        System.out.print(" 3.查询余额 ");
        while (sc.hasNext()) {
            String str = sc.next();
            if(str.equals("1")) {
                    System.out.println("进货");
                    System.out.println("请输入要进货的套餐编号");
                    for (int i = 1; i <= mealList.size(); i++) {
                        System.out.println("套餐"+(i)+" : "+mealList.get(i-1).toString());
                    }
                    try {
                        int index = sc.nextInt();
                        System.out.println("购买数量");
                        int amount = sc.nextInt();
                        SetMeal meal = mealList.get(index - 1);
                       restaurant.mealPurchase(amount,meal);

                    }catch (Exception e){
                        System.out.println("输入错误");
                    }
            }
            else if(str.equals("2")) {
                System.out.println("销售");
                for (int i = 0; i < mealList.size(); i++) {
                    System.out.println("套餐" + (i+1) + " : " + mealList.get(i).toString());
                }

                System.out.println("请输入要购买的套餐编号");
                try {
                    int index=sc.nextInt();
                       SetMeal meal=mealStore.get(index -1);
                                restaurant.sellSetMeal(meal);
                                System.out.println("已购买套餐"+index);
                }catch (Exception e ) {
                    System.out.println("输入错误");
                }
            }
            else if(str.equals("3")){
                    System.out.println("当前余额 : " + restaurant.getBalance());
            }
            else
                    System.out.println("输入错误");
            }

            System.out.println("选择服务: ");
            System.out.print(" 1:进货 ");
            System.out.print(" 2.销售 ");
            System.out.print(" 3.查询余额 ");
        }
    }

