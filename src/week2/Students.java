package week2;

abstract class Students implements Comparable<Students> {
    public String name;

    public Students(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Students o) {
        if (this.getClass() == o.getClass()) {
            return this.compare(o);
        } else {
            return this.getClass().toString().compareTo(o.getClass().toString());
        }
    }

    abstract public int compare(Object o);
}
