package Family.HW9.main.modal;

import java.time.*;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Human {
    //    public long birthDate;
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Family family;
    private Map<DayOfWeek, String> schedule;
    private String adoptChildBirth;

    public int iqLevel(int iq) throws Exception {
        if (iq >= 0 && iq <= 100) {
            return iq;
        } else {
            throw new Exception("IQ must be from 0 to 100");
        }
    }

    public Human(String name, String surname, long birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, long birthDate, int iq, Family family, HashMap<DayOfWeek, String> schedule) {
        this(name, surname, birthDate);
        this.iq = iq;
        this.family = family;
        this.schedule = schedule;
    }

    public Human() {
    }

    public Human(String name, String surname, String adoptChildBirth, int iq) {
        this.name = name;
        this.surname = surname;
        this.adoptChildBirth = adoptChildBirth;
        this.iq = iq;
    }

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

    public int getBirthDate() {
        return (int) birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
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

        public String describeAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDay = Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(birthDay, currentDate);
        return String.format("Full Years: %s, Full Months: %s, Days: %s,", period.getYears(), period.getMonths(), period.getDays());
    }


    private String dateFormatter() {
        LocalDate birthDay = Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate res = LocalDate.of(birthDay.getYear(), birthDay.getMonth(), birthDay.getDayOfMonth());
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(res);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + dateFormatter() +
                ", childBirth='" + adoptChildBirth + '\'' +
                ", iq=" + iq +
                ", schedule=" + schedule +
                ", family=" + family +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate && iq == human.iq && name.equals(human.name) && surname.equals(human.surname) && family.equals(human.family) && schedule.equals(human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iq, family, schedule);
    }

    @Override
    protected void finalize() {
        System.out.println("Delete");
    }
}