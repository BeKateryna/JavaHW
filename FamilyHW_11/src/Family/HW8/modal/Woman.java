package Family.HW8.modal;
import java.util.Set;

public final class Woman extends Human {

    public Woman() {
        super();
    }

    public Woman(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Woman(String name, String surname, int iq, Family family, String birthDate) {
        super(name, surname, iq, family, birthDate);
    }

    @Override
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
