public class HashTable implements Map{
    private Entry[] entries;
    private int size, used;
    private float loadFactor;
    private final Entry Dummy = new Entry(null, null);

    public HashTable(int capacity, float loadFactor) {
        entries = new Entry[capacity];
        this.loadFactor = loadFactor;
    }

    public HashTable(int capacity) {
        this(capacity, 0.75F);
    }

    public HashTable() {
        this(101);
    }

    public Object get(Object key) {
        int h = hash(key);
        for(int i = 0; i < entries.length; i++) {
            int j = nextProbe(h, i);
            Entry entry = entries[j];
            if (entry == null) {
                break;
            }
            if (entry == Dummy) {
                continue;
            }
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public Object put(Object key, Object value) {
        if (used > loadFactor * entries.length) {
            rehash();
        }
        int h = hash(key);
        for (int i = 0; i < entries.length; i++) {
            int j = nextProbe(h, i);
            if (i != 0) {
                System.out.println("Collision! " + key + " h: " + h + " i: " + i + " j: " + j);
            }
            Entry entry = entries[j];
            if (entry == null) {
                System.out.println("Put success! " + "key: " + key + " h: " + h + " i: " + i + " value: " + value);
                entries[j] = new Entry(key, value);
                ++size;
                ++used;
                return null;
            }
            if (entry == Dummy) {
                continue;
            }
            if (entry.key.equals(key)) {
                System.out.println("Update success! " + "key: " + key + " h: " + h + " i: " + i + " value: " + value);
                Object oldValue = entry.value;
                entries[j].value = value;
                return oldValue;
            }
        }
        return null;
    }

    public Object remove(Object key) {
        int h = hash(key);
        for (int i = 0; i < entries.length; i++) {
            int j = nextProbe(h, i);
            Entry entry = entries[j];
            if (entry == null) {
                break;
            }
            if (entry == Dummy) {
                continue;
            }
            if (entry.key.equals(key)) {
                Object oldValue = entry.value;
                entries[j] = Dummy;
                --size;
                return oldValue;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private class Entry {
        Object key, value;

        Entry(Object k, Object v) {
            key = k;
            value = v;
        }
    }

    private int hash(Object key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }

    private int nextProbe(int h, int i) {
        return (h + i) % entries.length;
    }

    private void rehash() {
        Entry[] oldEntries = entries;
        entries = new Entry[2 * oldEntries.length + 1];
        for (int k = 0; k < oldEntries.length; k++) {
            Entry entry = oldEntries[k];
            if (entry == null || entry == Dummy) {
                continue;
            }
            int h = hash(entry.key);
            for (int i = 0; i < entries.length; i++) {

            }
        }
    }
}
