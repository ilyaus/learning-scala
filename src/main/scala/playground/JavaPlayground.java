package playground;


public class JavaPlayground {
    public static void main(String[] args) {
        System.out.println("Hello Java");

        // Class level functionality
        System.out.println(Person.N_EYES);

        // ++++++++++++
        LinkedList l = new LinkedList(1);

        for(int i = 0; i <= 10; i++) {
            l.insert(i);
        }

        l.printList();
    }
}

class Person {
    public static final int N_EYES = 2;
}