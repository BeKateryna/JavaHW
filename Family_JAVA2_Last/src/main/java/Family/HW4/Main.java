package Family.HW4;

public class Main {
    public static void print(Object o) {
        System.out.println(o);
    }

    public static void main(String[] args) throws Exception {
        String[] taksaHabits = {"curious", "cheese lover"};

        Pet taksa = new Pet(Species.DOG, "Baget", 8, 5, taksaHabits);
        Pet cat = new Pet(Species.CAT, "Pushka");

        // familySchedule
        String[][] familySchedule = new String[2][2];
        familySchedule[0] = new String[]{DayOfWeek.SUNDAY.name(), "family time"};
        familySchedule[1] = new String[]{DayOfWeek.MONDAY.name(), "resolve other problems"};


        Human kate = new Human("Kate", "Ivanova", 1990, 80, familySchedule);
        Human vova = new Human("Vova", "Ivanov", 1988, 50, familySchedule);

        Human children2 = new Human("Child2", "Ivanov", 2012);
        Human children3 = new Human("Child3", "Ivanov", 2015);

        Family european = new Family(kate, vova);

        print(taksa);
        print(vova);

        // pets methods
        taksa.foul();
        taksa.eat();
        taksa.respond();

        print(taksa);

        print(european);

        //add Child
        european.addChild(children2);
        european.addChild(children3);
        print(european);

        european.setPet(taksa);
        vova.greetPet();

        //delete Child
        Boolean delete = european.deleteChildObj(children3);
        Boolean deleteInx = european.deleteChildInx(0);

        print(european.countFamily());
        print(delete);
        print(deleteInx);
        european.addChild(children3);
//        print(children2.getFamily());

        Runtime runTime = Runtime.getRuntime();
        System.out.println("total memory before" + " " + runTime.totalMemory());
        System.out.println("_________________________________________");
        System.out.println("free memory before" + " " + runTime.freeMemory());

        int i = 0;
        for (i = 0; i < 10000; i++) {
            Human human1 = new Human("Tanos", "Tonosovich", 6000);
            Human human2 = new Human("Capitan", "Capitanovich", 4000);

            i++;
        }
        System.out.println("_________________________________________");
        System.out.println("free memory after" + " " + runTime.freeMemory());
        System.gc();
        System.out.println("_________________________________________");
        System.out.println("free memory after gc" + " " + runTime.freeMemory());
        System.out.println("_________________________________________");
    }
}
