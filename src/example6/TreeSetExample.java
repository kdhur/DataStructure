import java.util.*;

public class TreeSetExample {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Set<String> treeset = new TreeSet<String>();

        treeset.add("1 Java");
        treeset.add("2 Data Structure");
        treeset.add("3 Set");
        treeset.add("4 Example");
        //key값에 따라 정렬됨.
        
        System.out.println(treeset);

        Iterator it = treeset.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
