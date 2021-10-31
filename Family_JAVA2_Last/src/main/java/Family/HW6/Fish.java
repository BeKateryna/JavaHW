package Family.HW6;

public class Fish extends Pet {
    final private Species species = Species.FiSH;

    @Override
    public Species getSpecies() {
        return species;
    }

    @Override
    public void respond() {
        System.out.println("bul bul bul");
    }

    public Fish() {
    }

    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Fish(String nickname) {
        super(nickname);
    }

}
