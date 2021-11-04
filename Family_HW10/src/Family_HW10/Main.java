package Family_HW10;
import Family_HW10.modal.Human;

public class Main {
    public static void main(String[] args) {
        long dateBirth = System.currentTimeMillis() / 1000L;
        Human kate = new Human("Kate", "Katevich", dateBirth);
        Human adoptChild = new Human("Max", "Maxovich", "30/11/1998", 10);
        System.out.println(adoptChild.describeAge());
        System.out.println(kate.getBirthDate());
        System.out.println(kate);
        System.out.println(adoptChild);
    }
}
