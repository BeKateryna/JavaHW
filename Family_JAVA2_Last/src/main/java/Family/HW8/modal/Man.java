package Family.HW8.modal;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Set;

public final class Man extends Human {
    private Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, int iq, Family family, HashMap<DayOfWeek, String> schedule) {
        super(name, surname, year, iq, family, schedule);
    }

    private Man() {
        super();
    }

    @Override
    void greetPet() {
        Set<Pet> pp = this.getFamily().getPets();
        for (Pet pett : pp) {
            System.out.printf("==== Wow wow!!! Look at this  %s \n", pett.getSpecies());
        }
    }

    void repairCar() {
        System.out.printf("Я %s и я не умею чинить машины!!!\n", this.getName());
    }
}
