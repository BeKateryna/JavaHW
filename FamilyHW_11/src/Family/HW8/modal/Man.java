package Family.HW8.modal;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public  final class Man extends Human {
    public Man() {
    }

    public Man(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Man(String name, String surname, int iq, Family family, String birthDate) {
        super(name, surname, iq, family, birthDate);
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
