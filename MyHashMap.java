class MyHashMap<K, V> {
    private static final int SIZE = 16; // Initial size of the hash map
    private Entry<K, V>[] table; // Array of linked lists

    public MyHashMap() {
        table = new Entry[SIZE];
    }

    // Entry class for linked list
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Insert a key-value pair
    public void put(K key, V value) {
        int hash = key.hashCode() % SIZE; // Calculate hash
        Entry<K, V> entry = table[hash];

        if (entry == null) {
            table[hash] = new Entry<>(key, value); // No collision, just add
        } else {
            // Handle collision using linked list
            while (entry.next != null) {
                if (entry.key.equals(key)) {
                    entry.value = value; // Update existing key
                    return;
                }
                entry = entry.next;
            }
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing key
            } else {
                entry.next = new Entry<>(key, value); // Add new entry
            }
        }
    }

    // Retrieve value by key
    public V get(K key) {
        int hash = key.hashCode() % SIZE;
        Entry<K, V> entry = table[hash];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value; // Found the key!
            }
            entry = entry.next;
        }
        return null; // Key not found
    }

    // Remove a key-value pair
    public void remove(K key) {
        int hash = key.hashCode() % SIZE;
        Entry<K, V> entry = table[hash];

        if (entry == null) {
            return; // Key not found
        }
        if (entry.key.equals(key)) {
            table[hash] = entry.next; // Remove the first entry
            return;
        }
        while (entry.next != null) {
            if (entry.next.key.equals(key)) {
                entry.next = entry.next.next; // Remove the entry
                return;
            }
            entry = entry.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        System.out.println("apple: " + map.get("apple")); // 1
        map.remove("banana");
        System.out.println("banana: " + map.get("banana")); // null
    }
}