package Family_HW11.modal;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Set;

public final class Woman extends Human {
    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, int iq, Family family, HashMap<DayOfWeek, String> schedule) {
        super(name, surname, year, iq, family, schedule);
    }

    public Woman(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);

    }



    public Woman() {
        super();
    }

    void greetPet() {
        Set<Pet> pp = this.getFamily().getPets();
        for (Pet pett : pp) {
            System.out.printf("==== So pretty!!!! My  small  %s \n", pett.getSpecies());
        }
    }

    void makeUp () {
                System.out.printf("Я %s и я ненавижу краситься!!!\n", this.getName());
    }
}
