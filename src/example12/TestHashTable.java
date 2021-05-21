import java.util.Hashtable;

public class TestHashTable {
    public TestHashTable() {
        Hashtable t = new Hashtable(11);

        t.put("LEE", new Student("Lee Youngseok", "Computer", 2020, 4));
        System.out.println("t.size(): " + t.size());
        t.put("KIM", new Student("Kim Younghee", "AI", 2011, 3));
        System.out.println("t.size(): " + t.size());
        t.put("PARK", new Student("Park Chulsoo", "Electronics", 2020, 4));
        System.out.println("t.size(): " + t.size());
        t.put("CHOI", new Student("Choi Cheesoo", "Mechanical", 2019, 3));
        System.out.println("t.size(): " + t.size());
        t.put("LEE", new Student("Lee Chulsoo","Software", 2019, 3));

        System.out.println("t.size(): " + t.size());
        System.out.println("t.get(\"LEE\"): " + t.get("LEE"));
        System.out.println("t.get(\"CHOI\"): " + t.get("CHOI"));
        System.out.println("t.remove(\"PARK\"): " + t.get("PARK"));
        System.out.println("t.size(): " + t.size());

        t.put("HONG", new Student("Hong Gildong", "Chemical", 2018, 4));
        System.out.println("t.size(): " + t.size());
    }

    public static void main(String[] args) {
        new TestHashTable();
    }
}