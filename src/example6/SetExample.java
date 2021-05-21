import java.util.*;

public class SetExample {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Set<String> hashset = new HashSet<String>();

        hashset.add("1 Java");
        hashset.add("2 Data Structure");
        hashset.add("3 Set");
        hashset.add("4 Example"); 
        //hashtable 함수에 의해 결정된 순서에 따라 내부적으로 저장됨. -> 코드 순서와 다르게 저장됨
        
        System.out.println("Set output without the duplicates : ");
        System.out.println(hashset);
        
        
        Iterator it = hashset.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}