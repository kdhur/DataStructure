public class Student {
    public String name, department;
    public int id, gpa;

    public Student(String n, String d, int i, int g) {
        name = n;
        department = d;
        id = i;
        gpa = g;
    }

    public String toString() {
        return "(" + name + "," + department + "," + id + "," + gpa + ")";
    }
}
