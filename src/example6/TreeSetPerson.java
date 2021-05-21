import java.util.*;

class Person1 implements Comparable<Person1> {
    String name;
    int id;

    public Person1(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean equals(Person1 o) {
        Person1 p = (Person1)o;
        return p.id == this.id;
    }

    public int compareTo(Person1 o) {
        if (this.id > o.id) {
            return 1;
        }
        else if (this.id < o.id) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

public class TreeSetPerson {
    public static void main(String[] args) {
        TreeSet<Person1> tset = new TreeSet<Person1>();

        System.out.println("\t TreeSet");
        tset.add(new Person1("lee", 1111));
        tset.add(new Person1("kim", 2222));
        tset.add(new Person1("choi", 3333));
        tset.add(new Person1("park", 4444));
        tset.add(new Person1("hong", 1111));
        
        for (Person1 t : tset) {
            System.out.println(t.name + "\t" + t.id);
        }
    }
}