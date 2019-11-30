import util.Calculate;

public class Main {

    public static void main(String[] args) {
        Calculate cal1 = new Calculate("add",1,2);
        int c1 = cal1.doCal();

        System.out.println(c1);
        System.out.println("fine");
    }
}
