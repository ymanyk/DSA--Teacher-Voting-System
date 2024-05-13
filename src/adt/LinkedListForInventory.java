package adt;
/**
 * @author Rinisha
 */
public class LinkedListForInventory<T> implements LinkedListInterface<T> {

    private Node headNode; // reference to first node
    private int TotalLengthOfList;  	// total number of entries in list
    boolean reverse = true;

    public LinkedListForInventory() {
        clear();
    }

    @Override
    public final void clear() {
        headNode = null;
        TotalLengthOfList = 0;
    }

    @Override
    public boolean addNewItem(T newEntry) {
        Node newNode = new Node(newEntry);	// create the new node

        if (isEmpty()) {
            headNode = newNode;
        } else {                        // add to end of nonempty list
            Node currentNode = headNode;	// traverse linked list with p pointing to the current node
            while (currentNode.next != null) { // while have not reached the last node
                currentNode = currentNode.next;
            }
            currentNode.next = newNode; // make last node reference new node
        }

        TotalLengthOfList++;
        return true;
    }

    public boolean addReceipt(T newEntry) {
        Node newNode = new Node(newEntry);	// create the new node
        if (!reverse) {
            headNode = reverse(headNode);
            reverse = true;
        }
        // Node current will point to head
        Node current = headNode;

        while (current != null) {

            // Prints each node by incrementing pointer
            current = current.next;
        }
        if (isEmpty()) {
            headNode = newNode;
        } else {                        // add to end of nonempty list

            Node currentNode = headNode;	// traverse linked list with p pointing to the current node

            while (currentNode.next != null) { // while have not reached the last node
                currentNode = currentNode.next;
            }
            currentNode.next = newNode; // make last node reference new node
        }

        TotalLengthOfList++;
        return true;
    }

    @Override
    public boolean add(int newPosition, T newEntry) { // OutOfMemoryError possible
        boolean Done = true;

        if ((newPosition >= 1) && (newPosition <= TotalLengthOfList + 1)) {
            Node newNode = new Node(newEntry);

            if (isEmpty() || (newPosition == 1)) { // case 1: add to beginning of list
                newNode.next = headNode;
                headNode = newNode;
            } else {								// case 2: list is not empty and newPosition > 1
                Node nodeBefore = headNode;
                for (int i = 1; i < newPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
                }

                newNode.next = nodeBefore.next;	// make new node point to current node at newPosition
                nodeBefore.next = newNode;		// make the node before point to the new node
            }

            TotalLengthOfList++;
        } else {
            Done = false;
        }

        return Done;
    }

    @Override
    public T removeItem(int givenPosition) {
        T result = null;                 // return value

        if ((givenPosition >= 1) && (givenPosition <= TotalLengthOfList)) {
            if (givenPosition == 1) {      // case 1: remove first entry
                result = headNode.data;     // save entry to be removed
                headNode = headNode.next;
            } else {                         // case 2: givenPosition > 1
                Node nodeBefore = headNode;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
                }
                result = nodeBefore.next.data;  // save entry to be removed
                nodeBefore.next = nodeBefore.next.next;	// make node before point to node after the
            } 	// one to be deleted (to disconnect node from chain)

            TotalLengthOfList--;
        }

        return result; // return removed entry, or null if operation fails
    }

    @Override
    public boolean update(int givenPosition, T newEntry) {
        boolean Done = true;

        if ((givenPosition >= 1) && (givenPosition <= TotalLengthOfList)) {
            Node currentNode = headNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            currentNode.data = newEntry;	// currentNode is pointing to the node at givenPosition
        } else {
            Done = false;
        }

        return Done;
    }

    @Override
    public T findVariable(int givenPosition) {
        T finalVariable = null;

        if ((givenPosition >= 1) && (givenPosition <= TotalLengthOfList)) {
            Node currentNode = headNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            finalVariable = currentNode.data;	// currentNode is pointing to the node at givenPosition
        }

        return finalVariable;
    }

    @Override
    public int search(T anEntry) {

        int position = 1;
        Node currentNode = headNode;

        while ((currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                //if found return entry position
                return position;

            } else {
                currentNode = currentNode.next;
                position++;
            }
        }
        //if not found return -1
        return -1;
    }

    @Override
    public int getTotalLength() {
        return TotalLengthOfList;
    }

    @Override
    public boolean isEmpty() {
        boolean result;

        result = TotalLengthOfList == 0;

        return result;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    Node reverse(Node node) {
        Node previous = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        node = previous;
        return node;
    }

    @Override
    public void display() {

        // Node current will point to head
        Node current = headNode;

        if (headNode == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {

            // Prints each node by incrementing pointer
            System.out.print(current.data);
            current = current.next;
        }

        System.out.println();
    }

    public void displayReverse() {
        // Node current will point to head
        if (reverse) {
            headNode = reverse(headNode);
            reverse = false;
        }
        Node current = headNode;

        if (headNode == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {

            // Prints each node by incrementing pointer
            System.out.print(current.data);
            current = current.next;
        }

        System.out.println();
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

}
