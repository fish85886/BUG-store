package HouseApp;

import java.util.Scanner;

public class Utility {
    Scanner scanner = new Scanner(System.in);

    //控制输入一个字符串长度，并且如果直接回车给个默认值
    public String readString(int n, String s) {
        // 处理输入流里面是否还有换行符
        if(scanner.hasNextLine()){
            String f = scanner.nextLine();
        }
        String user;
        while (true) {
            user = scanner.nextLine();
            if (user.length() > n) {
                System.out.println("请输入的长度小于" + n);
            } else if (user.isEmpty()) {
                return s;
            } else {
                return user;
            }
        }
    }
    public double readDouble(){
        double user;
        while (true){
            user = scanner.nextDouble();
            if (user<0){
                System.out.println("请输入输大于0");
            }else {
                return user;
            }
        }

    }

}
