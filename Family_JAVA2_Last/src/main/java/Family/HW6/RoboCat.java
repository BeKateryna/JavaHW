package Family.HW6;

public class RoboCat extends Pet {
    final private Species species = Species.ROBOCAT;

    @Override
    public Species getSpecies() {
        return species;
    }

    @Override
    public void respond() {
        System.out.println("Im a RoboCat ");
    }

    public RoboCat(String nickname) {
        super(nickname);
    }

    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public RoboCat() {
    }
}
