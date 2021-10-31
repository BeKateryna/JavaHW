package Family.HW6;

public class DomesticCat extends Pet implements animalsFuels {
    final private Species species = Species.DOMESTICCAT;

    @Override
    public Species getSpecies() {
        return species;
    }

    @Override
    public void respond() {
        System.out.println("Im a super Domestic cat!!...");
    }

    @Override
    public void foul() {
        System.out.println("I can make a big mass...");
    }

    public DomesticCat() {
    }

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public DomesticCat(String nickname) {
        super(nickname);
    }
}
