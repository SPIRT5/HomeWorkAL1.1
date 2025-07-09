import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = age;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()){
            age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder builder = new PersonBuilder();
        builder.setSurname(this.surname);
        builder.setAge(0);
        if (this.hasAddress()) {
            builder.setAddress(this.address);
        }
        return builder;
    }


    @Override
    public String toString() {
        return name + " " + surname +
                (hasAge() ? ", возраст " + age : "") +
                (hasAddress() ? ", живет в " + address : "");
    }

    @Override
    public int hashCode() {
        int result = name.hashCode() * 31 + surname.hashCode();
    result = 31 * result + (hasAge() ? age : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    return result;
    }
}
