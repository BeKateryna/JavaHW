package Family.HW8.modal;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Family family;
    private Map<DayOfWeek, String> schedule;

    public int iqLevel(int iq) throws Exception {
        if (iq >= 0 && iq <= 100) {
            return iq;
        } else {
            throw new Exception("IQ must be from 0 to 100");
        }
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }


    public Human(String name, String surname, int year, int iq, Family family, HashMap<DayOfWeek, String> schedule) {
        this(name, surname, year);
        this.iq = iq;
        this.family = family;
        this.schedule = schedule;
    }

    public Human() {}

    // Getters Setters
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

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(HashMap<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    void greetPet() {
      Set<Pet> pp = this.family.getPets();
        for (Pet pett : pp) {
            System.out.println(pett.getTrickLevel());
            System.out.printf("==== Heyyy!, %s \n", pett.getNickname());
        }
    }


    @Override
    public String toString() {
        return String.format(
                "Human{name='%s', surname='%s', year=%d, iq=%d, schedule=%s}",
                name,
                surname,
                year,
                iq,
                schedule
        );

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && name.equals(human.name) && surname.equals(human.surname) && family.equals(human.family) && schedule.equals(human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, family, schedule);
    }

    @Override
    protected void finalize() {
        System.out.println("Delete");
    }
}