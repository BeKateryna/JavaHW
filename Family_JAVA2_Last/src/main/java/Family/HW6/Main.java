package Family.HW6;

public class Main {
    public static void print(Object o) {
        System.out.println(o);
    }

    public static void main(String[] args) throws Exception {
        String[] taksaHabits = {"curious", "cheese lover"};

        print(" dog --------------------");
        Dog taksa = new Dog("Baget", 8, 5, taksaHabits);
        print(taksa);
        taksa.foul();
        taksa.eat();
        taksa.respond();
        print(" fish --------------------");
        Fish fish = new Fish();
        Fish fish2 = new Fish("Fish2", 3, 1,taksaHabits);
        print(fish);
        print(fish2);
        fish.eat();
        fish.respond();
        print(" domesticCat --------------------");
        DomesticCat domesticCat = new DomesticCat();
        print(domesticCat);
        domesticCat.eat();
        domesticCat.respond();
        domesticCat.foul();
        print(" roboCat --------------------");
        RoboCat roboCat = new RoboCat();
        print(roboCat);
        roboCat.eat();
        roboCat.respond();
        print(" UnknownSpecias --------------------");
        UniverseSpecias x = new UniverseSpecias();
        print(x);

        // familySchedule
        String[][] familySchedule = new String[2][2];
        familySchedule[0] = new String[]{DayOfWeek.SUNDAY.name(), "family time"};
        familySchedule[1] = new String[]{DayOfWeek.MONDAY.name(), "resolve other problems"};

        Human kate = new Human("Kate", "Ivanova", 1990, 80, familySchedule);
        Human vova = new Human("Vova", "Ivanov", 1988, 50, familySchedule);

        Human children2 = new Human("Child2", "Ivanov", 2012);
        Human children3 = new Human("Child3", "Ivanov", 2015);

        Family european = new Family(kate, vova);
        european.setPet(taksa);

        print("MAN________________________________________");
        Man Dooge = new Man("Dooge", "Doogovich", 1968, 10, familySchedule);
        print(Dooge);
        print("WOMAN________________________________________");
        Woman Mimi = new Woman("Mimi", "Doogovich", 1978, 5, familySchedule);
        print(Mimi);
        print("NEW FAMILY________________________________________");
        Family asian = new Family(Mimi, Dooge);
        asian.setPet(taksa);
        print(asian);
        print("Прежний метод greetPet________________________________________");
        vova.greetPet();
        print("Переопределенные методы greetPet________________________________________");
        Mimi.greetPet();
        Dooge.greetPet();
        print("NEW MAN WOMAN METHODS________________________________________");
        Mimi.makeUp();
        Dooge.repairCar();
        print(domesticCat.toString());
    }
}
