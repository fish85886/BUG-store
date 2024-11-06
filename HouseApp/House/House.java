package HouseApp.House;

public class House {
    private int house_id;
    private String name;
    private String phone;
    private String address;
    private double rent;
    private String state;

    public House(int house_id, String name, String phone, String address, double rent, String state) {
        this.house_id = house_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return house_id +
                "\t" + name  +
                "\t" + phone +
                "\t" + address +
                "\t" + rent  +
                "\t" + state ;
    }
}
