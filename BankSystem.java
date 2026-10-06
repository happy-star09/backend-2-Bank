import java.util.InputMismatchException;
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

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("请输入存款金额：");
                        try {

                            long deposit = scanner.nextLong();

                            if (deposit > 0) {

                                if (balance + deposit < balance) { // 防止存入数字过大数据溢出（究竟谁会这么有钱，能有long最大值那么多钱，简直是恶意存款）
                                    System.out.println("存入金额过大，余额已溢出，存款失败！");
                                } else {
                                    balance = balance + deposit;
                                    System.out.println("当前余额为：" + balance);
                                }

                            } else {
                                System.out.println("不可输入负数！");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("输入错误，请输入数字！");
                            scanner.next();
                        }
                        break;

                    case 2:
                        System.out.print("请输入取款金额：");
                        try {
                            long withdraw = scanner.nextLong();

                            if (withdraw > 0) {
                                if (balance >= withdraw) {
                                    balance = balance - withdraw;

                                    System.out.println("当前余额为：" + balance);
                                } else {
                                    System.out.println("余额不足");
                                }
                            } else {
                                System.out.println("不可输入负数！");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("输入错误，请输入数字！");
                            scanner.next();
                        }
                        break;

                    case 3:
                        System.out.println("当前余额为：" + balance);
                        break;

                    case 4:
                        System.out.println("谢谢使用！");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("输入无效，请输入正确数字！");
                }
            } catch (InputMismatchException e) {
                System.out.println("输入错误，请输入数字！");
                scanner.next();
            }
        }
        scanner.close();
    }
}
