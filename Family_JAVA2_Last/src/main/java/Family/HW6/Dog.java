package Family.HW6;

public class Dog extends Pet implements animalsFuels {
    final private Species species = Species.DOG;

    @Override
    public Species getSpecies() {
        return species;
    }

    @Override
    public void respond() {
        System.out.println("Gav Gav ");
    }

    @Override
    public void foul() {
        System.out.println("I can do everything...Im a crazy Dod ");
    }

    public Dog(String nickname) {
        super(nickname);
    }

    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Dog() {
    }
}
