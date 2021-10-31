package Family.HW6;

import java.util.Arrays;
import java.util.Objects;

public abstract class Pet {
    private String nickname;
    private int age;
    private int trickLevel; // (целое число от 0 до 100)
    private String[] habits;

    public Pet (String nickname) {
        this.nickname = nickname;
    }

    public Pet (String nickname, int age, int trickLevel, String[] habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() {}

    // Getters
    public Species getSpecies() {
        Species species;
        return species = Species.UNKNOWN;
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

    public String[] getHabits() {
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

    public void setHabits(String[] habits) {
        this.habits = habits;
    }


    // methods
    public void eat() {
        System.out.println("Я кушаю!");
    }

    abstract void respond();

    @Override
    public String toString() {
        return "Pet{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                ", species=" + this.getSpecies() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, age);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println (this.toString() + " was deleted");
    }
}

