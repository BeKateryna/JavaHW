package Family.HW9.main.modal;

import java.util.Set;

public class Dog extends Pet implements animalsFuels {
    final private Species species = Species.DOG;

    @Override
    public Species getSpecies() {
        return species;
    }

    @Override
    void respond() {
        System.out.println("Gav Gav ");
    }

    @Override
    public void foul() {
        System.out.println("I can do everything...Im a crazy Dod ");
    }

    public Dog(String nickname) {
        super(nickname);
    }

    public Dog(String nickname, int age, int trickLevel) {
        super(nickname, age, trickLevel);
    }

    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Dog() {}
}
