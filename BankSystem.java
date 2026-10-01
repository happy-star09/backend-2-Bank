import java.util.Scanner;
public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long balance = 0L;
        boolean isRunning = true;

        System.out.println("Thank you for using our system.");

        while(isRunning) {


            System.out.println("1.存款");
            System.out.println("2.取款");
            System.out.println("3.查询余额");
            System.out.println("4.退出");
            System.out.print("请输入所需功能对应的序号：");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("请输入存款金额：");
                    long deposit = scanner.nextLong();
                    balance = balance + deposit;

                    System.out.println("当前余额为：" + balance);
                    break;
                case 2:
                    System.out.print("请输入取款金额：");

                    long withdraw = scanner.nextLong();

                    if (balance >= withdraw) {
                        balance = balance - withdraw;

                        System.out.println("当前余额为：" + balance);
                    } else {
                        System.out.println("余额不足");
                    }

                    break;
                case 3:
                    System.out.println("当前余额为：" + balance);
                    break;
                case 4:
                    System.out.println("谢谢使用！");
                    isRunning = false;
                    break;
            }
        }
        scanner.close();
    }
}
