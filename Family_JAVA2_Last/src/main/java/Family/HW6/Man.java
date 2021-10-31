package Family.HW6;

public final class Man extends Human {
    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, int iq, Family family, String[][] schedule) throws Exception {
        super(name, surname, year, iq, family, schedule);
    }

    public Man(String name, String surname, int year, int iq, String[][] schedule) throws Exception {
        super(name, surname, year, iq, schedule);
    }

    public Man() {}

//    @Override
//    void greetPet() {
//        System.out.printf("Привет из Man's  GREETPET method %s!!!\n", this.getFamily().getPet().getNickname());
//    }

    public void repairCar() {
        System.out.printf("Я %s и я не умею чинить машины!!!\n", this.getName());
    }
}
