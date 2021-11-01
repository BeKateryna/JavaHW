package Family.HW9.main.modal;

import java.util.Set;

class RoboCat extends Pet implements animalsFuels {

    public RoboCat(String nickname) {
        super(nickname);
    }

    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.ROBOCAT);
    }
    public RoboCat() {}

    @Override
    public Species getSpecies() {
        return Species.ROBOCAT;
    }

    @Override
    void respond() {
        System.out.println("Im a RoboCat ");
    }

    @Override
    public void foul() {
        System.out.println("I need to hide my work!!");
    }
}
