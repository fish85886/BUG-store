package HouseApp.HouseService;

import HouseApp.House.House;

public class HouseService {
    House[] houses ;
    int houseNum = 1;
    private int id = 1;

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(0,"stmis","1321","鹿邑县",1000,"未出租");
    }

    public void lis(){
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] == null){
                break;
            }
            System.out.println(houses[i]);
        }
    }
    public boolean add(String name,String phone,String addpress,double rent,String state){
        if(houseNum == houses.length){
            System.out.println("--------------房屋信息已满--------------");
            System.out.println("--------------添加失败--------------");
            return false;
        }
        houses[houseNum++] = new House(id++,name,phone,addpress,rent,state);
        return true;
    }
    public boolean dele(int id){
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if(houses[i].getHouse_id()==id){//此ID是传进来的ID
                index = i;
                break;
            }
        }
        if(index==-1){
            return false;
        }
        for (int i = index; i <houseNum-1 ; i++) {
            houses[i] = houses[i+1];
        }
        houses[--houseNum] = null;
        return true;
    }
    public House find(int ID){
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if(houses[i].getHouse_id()==ID){//此ID是传进来的ID
                index = i;
                break;
            }
        }
        if(index==-1){
            return null;
        }
        return houses[index];
    }
    public void updata(House h,String name,String phone,String addpress,double rent,String state){
        h.setName(name);
        h.setPhone(phone);
        h.setAddress(addpress);
        h.setRent(rent);
        h.setState(state);
    }
}
