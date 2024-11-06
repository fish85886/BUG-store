package HouseApp;

public class text {
    public static void main(String[] args) {
        Utility utility = new Utility();
        double d = utility.readDouble();
        String s = utility.readString(4,"1");
        System.out.println(d);
        System.out.println(s);
    }
}
