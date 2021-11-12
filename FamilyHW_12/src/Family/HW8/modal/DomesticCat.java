package Family.HW8.modal;

import java.util.Set;

class DomesticCat extends Pet implements animalsFuels {
    final private Species species = Species.DOMESTICCAT;

    public DomesticCat() {}

    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public DomesticCat(String nickname) {
        super(nickname);
    }

    @Override
    public Species getSpecies() {
        return species;
    }

    @Override
    void respond() {
        System.out.println("Im a super Domestic cat!!...");
    }

    @Override
    public void foul() {
        System.out.println("I can make a big mass...");
    }
}

