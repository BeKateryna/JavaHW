package Family.HW8.modal;

import java.util.Set;

class Fish extends Pet {
    final private Species species = Species.FiSH;
    public Fish(String nickname) {
        super(nickname);
    }

    @Override
    public Species getSpecies() {
        return species;
    }

    @Override
    void respond() {
        System.out.println("bul bul bul");
    }

    public Fish() {}

    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Fish(String nickname, int age, int trickLevel) {
        super(nickname, age, trickLevel);
    }

    @Override
    public void foul() {
        super.foul();
    }
}