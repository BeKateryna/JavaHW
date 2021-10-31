package Family.HW6;

public final class Woman extends Human {
    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, int iq, Family family, String[][] schedule) throws Exception {
        super(name, surname, year, iq, family, schedule);
    }

    public Woman(String name, String surname, int year, int iq, String[][] schedule) throws Exception {
        super(name, surname, year, iq, schedule);
    }

    public Woman() {}

//    @Override
//    public void greetPet() {
//        System.out.printf("Привет из Women's GREETPET method %s!!!\n", this.getFamily().getPet().getNickname());
//    }
    public void makeUp() {
                System.out.printf("Я %s и я ненавижу краситься!!!\n", this.getName());
    }
}
