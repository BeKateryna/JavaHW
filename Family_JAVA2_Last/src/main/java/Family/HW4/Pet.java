package Family.HW4;
import java.util.Arrays;
import java.util.Objects;

 class Pet {
    private Species species;;
    private String nickname;
    private int age;
    private int trickLevel; // (целое число от 0 до 100)
    private String[] habits;

    //    конструктор, описывающий вид животного и его кличку
    public Pet (Species species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    //    конструктор, описывающий все поля животного
    public Pet (Species species, String nickname, int age, int trickLevel, String[] habits) {
        this(species, nickname);
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    //    пустой конструктор
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

    public String[] getHabits() {
        return habits;
    }

    //Setters
    public void setSpecies(Species species) {
        this.species = species;
    }

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
    void eat() {
        System.out.println("Я кушаю!");
    }

    void respond() {
        System.out.printf("Привет, хозяин. Я - %s. Я соскучился!%n", this.nickname);
    }

    void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }



    @Override
    public String toString() {
        return "Pet{" +
                "species='" + species + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && Objects.equals(species, pet.species) && Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println (this.toString() + " was deleted");
    }
}
