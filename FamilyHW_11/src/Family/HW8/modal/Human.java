package Family.HW8.modal;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Human {
    private String name;
    private String surname;
    private int iq;
    private Family family;
    private long birthDate = new Date().getTime();
    private Map<DayOfWeek, String> schedule;

    public int iqLevel(int iq) throws Exception {
        if (iq >= 0 && iq <= 100) {
            return iq;
        } else {
            throw new Exception("IQ must be from 0 to 100");
        }
    }

    public Human() {}

    public Human(String name, String surname, String birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.birthDate = dateFormatter(birthDate);
    }

    public Human(String name, String surname, int iq, Family family, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.family = family;
        this.birthDate = dateFormatter(birthDate);
    }
    public long dateFormatter (String birthDay) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(birthDay, formatter);
        Date date1 = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return this.birthDate = date1.getTime();
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

    public long getBirthDate() {
        return birthDate;
    }


    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    void greetPet() {
      Set<Pet> pp = this.family.getPets();
        for (Pet pett : pp) {
            System.out.println(pett.getTrickLevel());
            System.out.printf("==== Heyyy!, %s \n", pett.getNickname());
        }
    }

    public String describeAge() {
        LocalDate today = LocalDate.now();
        LocalDate date = Instant.ofEpochMilli(this.birthDate)
                .atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate date1 = LocalDate.parse(today.toString());
        LocalDate date2 = LocalDate.parse(date.toString());
        LocalDate date3 = LocalDate.of(date1.getYear(), date1.getMonth(), date1.getDayOfMonth());
        LocalDate date4 = LocalDate.of(date2.getYear(), date2.getMonth(), date2.getDayOfMonth());
        Period period = Period.between(date4, date3);

        return getName() + "'s age is: " + period.getYears() + " years "
                + period.getMonths() + " months "
                + period.getDays() + " days ";
    }


    public void greetPet(Pet pet) {
        System.out.println("Hi, " + pet.getNickname());
    }

    public void greetAllPet() {
        for (Pet greet : family.getPets()) {
            System.out.println(greet);
        }
    }

    public String prettyFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("{name=%s, surname=%s, birthDate=%s, iq=%d, schedule=%s}", this.getName(), this.getSurname(),
                formatter.format(this.birthDate),
                this.getIq(), this.getSchedule());
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "Human{name=" + name + ", surname="
                + surname + ", birthday=" + formatter.format(this.birthDate)
                + ", iq=" + iq + ", schedule" + schedule + "}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return iq == human.iq && birthDate == human.birthDate && name.equals(human.name) && surname.equals(human.surname) && family.equals(human.family) && schedule.equals(human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, iq, family, birthDate, schedule);
    }

    @Override
    protected void finalize() {
        System.out.println("Delete");
    }
}