
public class Question2 {
    public static void main(String[] args) {



        Account a=new Account(0,"??",500,false);
        Account b=new Account();
        b.setId(0);
        System.out.println(a.getId());
        System.out.println(b.getId());
        b.setName("??");
        System.out.println(b.getName());
        b.setBalance(1000);
        System.out.println(b.getBalance());
        b.setFrozen(false);
        System.out.println(b.isFrozen());
        b.toString();

        a.transfer(b,100);
        Account[]accounts={a,b} ;
        Account.payoff(accounts,300);
        System.out.println(a.getBalance());

    }
    static class Account{
        private static int count=10001;
        private int id;
        private String name;
        private double balance;
        private boolean isFrozen;

        public Account() {

        }

        public Account(int id, String name, double balance, boolean isFrozen) {
            this.id = count++;
            this.name = name;
            this.balance = balance;
            this.isFrozen = isFrozen;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public boolean isFrozen() {
            return isFrozen;
        }

        public void setFrozen(boolean frozen) {
            isFrozen = frozen;
        }
        void transfer(Account target, double money){
            if(money<=0||this.isFrozen||target.isFrozen||this.balance<money){
                System.out.println("??????");
            }
            else{
            this.balance-=money;
            target.balance+=money;
            System.out.println("?????");
        }
        }
        static void payoff(Account[] accounts, double  salary){
            for(Account a: accounts){
                if(!a.isFrozen){
                    a.balance+=salary;
                }
                else{
                    a.toString();
                }
            }
        }
        @Override
        public String toString() {
            return "Account{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", balance=" + balance +
                    ", isFrozen=" + isFrozen +
                    '}';
        }
    }
}
