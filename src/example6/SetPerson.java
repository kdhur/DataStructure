import java.util.*;

class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


public class SetPerson {
    public static void main(String[] args) {
        HashSet<Person> pset = new HashSet<Person>();

        System.out.println("\t HashSet");
        pset.add(new Person("lee", 1111));
        pset.add(new Person("kim", 2222));
        pset.add(new Person("choi", 3333));
        pset.add(new Person("park", 4444));
        pset.add(new Person("hong", 1111));
        
        for (Person p : pset) {
            System.out.println(p.name + "\t" + p.id);
        }
    }
}
