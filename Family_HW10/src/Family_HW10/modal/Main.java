package Family_HW10.modal;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void print(Object o) {
        System.out.println(o);
    }

    public static void createFamily() {
        Family european = new Family(new Human("Kate", "Ivanova", 1990, 150, null, new HashMap<DayOfWeek, String>() {{
            put(DayOfWeek.MONDAY, "Nothing");
        }}), new Human("Vova", "Ivanov", 1988, 100, null, new HashMap<DayOfWeek, String>() {{
            put(DayOfWeek.MONDAY, "Nothing");
        }}));
        print("======== European  Family  ============");
        print(european);
        System.out.printf("======= European Family count: %d\n", european.countFamily());

        print("======== Family get pet ============");
        Pet goldFish = new Fish();
        european.addPet(goldFish);
        Set<Pet> pets = european.getPets();
        print(pets);
        print(european);
        print("======== Add two children: ============ ");
        european.addChild(new Human("child", "ivanow", 0, 5, european, new HashMap<DayOfWeek, String>() {{
            put(DayOfWeek.MONDAY, "cry");
        }}));
        european.addChild(new Human("child2", "ivanow", 5, 50, european, new HashMap<DayOfWeek, String>() {{
            put(DayOfWeek.MONDAY, "run all day");
        }}));
        print(european);
        System.out.printf(" ========  Family european count: %d\n", european.countFamily());
        print("========= Remove one child: ============");
        european.deleteChild(1);
        print("Family: ==============");
        print(european);

    }

    public static void petsManipulations() {
        HashSet<String> dogHabits = new HashSet<>();
        dogHabits.add("curious");
        dogHabits.add("cheese lover");
        Set<String> roboCatHabits = new HashSet<>(Arrays.asList("kill", "love", "eat"));

        print("Create Pets: ");
        Pet taksa = new Dog("Baget", 8, 5, dogHabits);
        Pet fish = new Fish("Fish", 3, 1);
        Pet roboCat = new RoboCat("RoboCat", 3, 1, roboCatHabits);
        print(taksa);
        print(fish);
        print(roboCat);

        print("Pets Methods: ");
        taksa.foul();
        taksa.respond();
        roboCat.eat();
        fish.respond();
        roboCat.foul();
        Species checkSpecias = roboCat.getSpecies();
        print(checkSpecias);
    }

    public static void main(String[] args) {

        createFamily();
        petsManipulations();

        HashMap<DayOfWeek, String> asianFamilySchedule = new HashMap<>();
        asianFamilySchedule.put(DayOfWeek.SUNDAY, "work all time");

        print("MAN__AND__WOMAN___________________________________");
        Man Dooge = new Man("Dooge", "Doogivich", 1965, 90, null, asianFamilySchedule);
        Woman Mimi = new Woman("Mimi", "Doogovich", 1978, 5, null, asianFamilySchedule);
        print(Mimi);
        print(Dooge);
        print("NEW MAN WOMAN METHODS________________________________________");
        Mimi.makeUp();
        Dooge.repairCar();
        Family asian = new Family(Dooge, Mimi);
        asian.addPet(new Fish("Fish", 3, 1));
        asian.addPet(new Dog("Max"));
        print("Overrided MAN's WOMAN's METHODS________________________________________");
        Dooge.greetPet();
        Mimi.greetPet();
        Human Kate = new Human("Kate", "Ivanova", 1990);
        print(Kate.toString());
    }
}
