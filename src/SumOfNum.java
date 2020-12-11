import java.util.Scanner;

public class SumOfNum {
    public static void main(String[] args) {
        System.out.println("请输入变量：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        double time= System.currentTimeMillis();


        MyThread myThread1=new MyThread(0,500000000,num,1);
        myThread1.start();
        MyThread myThread2=new MyThread(500000001,1000000000,num,2);
        myThread2.start();

        while (!myThread1.isInterrupted()&&!myThread2.isInterrupted()){

        }
        System.out.println((System.currentTimeMillis()-time)+"ms");
        System.out.println("结果："+(ans1+ans2));

    }

    private static boolean contain(long total, int num) {
        return String.valueOf(total).contains(String.valueOf(num));
    }

    static long ans1;
    static long ans2;

    static class MyThread extends Thread{
        private int start;
        private int end;
        private int num;
        private int check;
        @Override
        public void run() {
            long res=0;
            for (int i = start; i <=end; i++) {
                if (contain(i, num)) {
                    res += i;
                }
            }
            if(check==1)
                ans1=res;
            else if(check==2)
                ans2=res;
            this.interrupt();
        }

        //构造方法
        public MyThread(int start, int end, int num,int check) {
            this.start = start;
            this.end = end;
            this.num = num;
            this.check=check;
        }

    }
}
