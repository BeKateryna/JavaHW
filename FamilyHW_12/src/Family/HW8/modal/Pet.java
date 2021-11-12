package Family.HW8.modal;

import java.util.Objects;
import java.util.Set;

public abstract class Pet implements animalsFuels {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel; // (целое число от 0 до 100)
    private Set<String> habits;


    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet(String nickname, int age, int trickLevel) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.species = getUnknownSpecies();
    }

    @Override
    public void foul() {
        System.out.println("i override fuel method");
    }

    public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
        this.species = getUnknownSpecies();
    }

    public Pet() {}

    // Getters

    public Species getSpecies() {
        return species;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public Set<String> getHabits() {
        return habits;
    }

    //Setters
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }
    public void setSpecies(Species species) {
        this.species = species;
    }

    // methods
    public Species getUnknownSpecies() {
        return Species.GOD_CHILD;
    }

    void eat() {
        System.out.println("Я кушаю!");
    }

    abstract void respond();

    @Override
    public String toString() {
        return this.getSpecies() + "{nickname="
                + this.getNickname() + ", age="
                + this.getAge() + ", trickLevel="
                + this.getTrickLevel() + ", habits="
                + this.getHabits() + "}";
    }

    public String prettyFormat() {
        return String.format("species=%s, nickname=%s, age=%d, trickLevel=%d, habits=%s", this.getSpecies(), this.getNickname(),
                this.getAge(), this.getTrickLevel(), this.getHabits());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && nickname.equals(pet.nickname) && habits.equals(pet.habits) && species == pet.species;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, age, trickLevel, habits, species);
    }

    @Override
    protected void finalize() {
        System.out.println("Delete Pet");
    }
}
