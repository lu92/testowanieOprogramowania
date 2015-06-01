package LoginServiceHomework;

public class User {
    protected String name, surname;
    public User(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    // dodane hashCode i equals aby porownywac obiekty klasy User
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        if (!surname.equals(user.surname)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        return result;
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }

}
