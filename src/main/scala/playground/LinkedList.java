package playground;

class LinkedList {
    private int data;
    private LinkedList nextLink;
    private LinkedList firstLink;
    private LinkedList lastLink;

    LinkedList(int d) {
        this.data = d;
        this.nextLink = null;
        attach(this);
    }

    void insert(int d) {
        LinkedList a = new LinkedList(d);
        attach(a);
    }

    private void attach(LinkedList link) {
        if (firstLink != null) {
            lastLink.nextLink = link;
        } else {
            firstLink = link;
        }

        lastLink = link;
    }

    void printList() {
        LinkedList temp = firstLink;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.nextLink;
        }
    }
}
