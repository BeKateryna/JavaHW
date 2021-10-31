package Family.HW4;

import java.util.Arrays;
import java.util.Objects;

 class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Family family;
    String[][] schedule;   // [день недели][тип секции \ отдыха]

    public  Family getFamily() {
       return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
    

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public int iqLevel(int iq) throws Exception {
        if (iq >= 0 && iq <= 100) {
            return iq;
        } else {
            throw new Exception("IQ must be from 0 to 100");
        }
    }

    //    конструктор, описывающий имя, фамилию и год рождения
    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, Family family, String[][] schedule) throws Exception {
        this(name, surname, year);
        this.iq = iqLevel(iq);
        this.family = family;
        this.schedule = schedule;
    }

    //    конструктор, описывающий все поля
    public Human(String name, String surname, int year, int iq, String[][] schedule) throws Exception {
        this(name, surname, year);
        this.iq = iqLevel(iq);
        this.schedule = schedule;
    }

    // empty constructor
    public Human() {
    }



    // Methods
    void greetPet() {
        System.out.printf("Привет %s!!!\n", this.getFamily().getPet().getNickname());
    }

    void describePet() {
        String tricky = (this.getFamily().getPet().getTrickLevel() > 50) ? "очень хитрый" : "почти не хитрый";
        System.out.printf("У меня есть %s, eмy %d лет, он %s\n", this.getFamily().getPet().getSpecies(), this.getFamily().getPet().getAge(), tricky);
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + Arrays.deepToString(schedule) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, family);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.toString() + " " + " was deleted");
    }

}
