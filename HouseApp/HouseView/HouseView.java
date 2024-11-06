package HouseApp.HouseView;

import HouseApp.House.House;
import HouseApp.HouseService.HouseService;
import HouseApp.Utility;

import java.util.Scanner;

public class HouseView {
    private boolean loop = true;
    private String key ;
    Scanner scanner = new Scanner(System.in);
    HouseService houseService = new HouseService(3);
    Utility utility = new Utility();
    public void houseMenu(){
        do{
            System.out.println("\n--------------房屋出租系统--------------");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋 信 息");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 信 息 列 表");
            System.out.println("\t\t\t6 退            出");
            System.out.print("请选择（1-6）：");
            key = scanner.next();
            switch (key){
                case "1":
                    addhouse();
                    break;
                case "2":
                   findhouse();
                    break;
                case "3":
                    delehouse();
                    break;
                case "4":
                    updatahouse();
                    break;
                case "5":
                    listhouse();
                    break;
                case "6":
                    if(exit()){
                        loop = false;
                    }
                    break;
            }
        }while (loop);

    }
    public void listhouse(){
        System.out.println("--------------房屋列表信息--------------");
        System.out.println("编号\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        houseService.lis();
    }

    public void addhouse(){
        System.out.println("--------------添加房屋--------------");
        System.out.print("房主：");
        String name = utility.readString(5,"无名");
        System.out.print("电话：");
        String phone = utility.readString(11,"空");
        System.out.print("地址：");
        String addpress = utility.readString(5,"空");
        System.out.print("月租：");
        double rent = utility.readDouble();
        System.out.print("状态：");
        String state = utility.readString(3,"空");
        if(houseService.add(name,phone,addpress,rent,state)){
            System.out.println("--------------添加成功--------------");
        }
    }

    public void delehouse(){
        System.out.println("--------------删除房屋--------------");
        System.out.println("请输入你要删除房屋的ID：");
        int ID = scanner.nextInt();
        if(houseService.dele(ID)){
            System.out.println("--------------删除成功--------------");
        }else {
            System.out.println("--------------未找到此房屋信息--------------");
            System.out.println("--------------删除失败--------------");
        }
    }

    public void findhouse(){
        System.out.println("--------------查找房屋信息--------------");
        System.out.print("请输入要查询的房屋ID:");
        int ID = scanner.nextInt();
        House house = houseService.find(ID);
        if(house==null){
            System.out.println("--------------未找到此ID的信息--------------");
        }else {
            System.out.println("编号\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
            System.out.println(house);
        }
    }

    public void updatahouse(){
        System.out.println("--------------修改房屋信息--------------");
        System.out.println("请选择要修改房屋的ID（-1退出）：");
        int user = scanner.nextInt();
        if(user == -1){
            return;
        }
        House house = houseService.find(user);
        if (house==null){
            System.out.println("未找到此房屋信息");
        }else {

            System.out.print("房主("+house.getName()+")：");
            String name = utility.readString(5,house.getName());
            System.out.print("电话("+house.getPhone()+")：");
            String phone = utility.readString(11,house.getPhone());
            System.out.print("地址("+house.getAddress()+")：");
            String addpress = utility.readString(5,house.getAddress());
            System.out.print("月租("+house.getRent()+")：");
            double rent = utility.readDouble();
            System.out.print("状态("+house.getState()+")：");
            String state = utility.readString(3,house.getState());
            houseService.updata(house,name,phone,addpress,rent,state);
        }
    }

    public boolean exit(){
        String user;
        while (true){
            System.out.println("你确定要退出吗？请输入(y/n)");
            user = scanner.next();
            if(user.equals("y")||user.equals("n")){
                break;
            }
            System.out.println("请正确输出");
        }
        if(user.equals("y")){
            return true;
        }else {
            return false;
        }
    }
}
