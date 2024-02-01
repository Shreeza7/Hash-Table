public class HashMe {

    String[] table;
    int hashKey;

    public void Hash(int size, String[] name) {
        table = new String[size];
        Hash(name);

    }

    public int HashKey(String name) {
        int maxVal = 17576;
        int nameVal = (((name.charAt(0) - 'a') * (26 * 26))
                + ((name.charAt(1) - 'a') * (26)) +
                ((name.charAt(2) - 'a') * (1)));
        int sections = maxVal / table.length;
        hashKey = ((nameVal / sections) - 1);

        int HashKey = hashKey > 0 ? hashKey : 0;

        return HashKey;

    }

    public void Hash(String[] names) {
        int collisions = 0;
        for (int i = 0; i < names.length; i++) {
            int key = HashKey(names[i]);
            if (table[key] != null) {
                collisions++;

                int newKey, c = 0;
                while (table[key + c] != null) {
                    c++;
                }
                newKey = key + c;
                table[newKey] = names[i];

            } else {
                table[key] = names[i];
            }
        }
        System.out.println("Number of Collisions = " + collisions);
    }

    public void reHash(int size, String[] names) {
        table = new String[size];
        Hash(names);
    }

    public void showTable() {
        System.out.println("Size of Table: " + table.length);
        System.out.println("NAME" + "         " + "HashKey");
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.printf("%s" + "\t\t" + "%d" + "\n", table[i], i);
            }
        }
        System.out.println("Finished");
        System.out.println();
    }

}
