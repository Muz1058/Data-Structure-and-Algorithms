class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data) {
        this.data = data;
    }
}

class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        Node<T> current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println("]");
    }

    public void add(T data) {
        addLast(data);
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void insertAt(int index, T data) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds");
            return;
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
            size++;
        }
    }

    public void insertBefore(int index, T data) {
        insertAt(index, data);
    }

    public void insertAfter(int index, T data) {
        insertAt(index + 1, data);
    }

    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;

            current.next = null;
            current.prev = null;
            size--;
        }
    }

    public void removeFirst() {
        if (isEmpty()) return;
        if (size == 1) {
            head = tail = null;
        } else {
            Node<T> temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) return;
        if (size == 1) {
            head = tail = null;
        } else {
            Node<T> temp = tail;
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        size--;
    }

    public T get(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }


    public boolean contains(T data) {
        return get(data) != null;
    }

    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.prev = null;
            current.next = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }
    
    @Override
    public String toString() {
        String result = "[";
        Node<T> current = head;
        while (current != null) {
            result += current.data;
            if (current.next != null) {
                result += " <-> ";
            }
            current = current.next;
        }
        result += "]";
        return result;
    }

}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.display();
        list.add(10);
        list.add(20);
        list.display();
        list.addFirst(5);
        list.display();
        list.insertAt(1, 15);
        list.display();
        list.insertBefore(2, 7);
        list.display();
        list.insertAfter(3, 18);

        list.display();
        System.out.println("Size: " + list.size());

        list.remove(4);
        list.display();

        list.removeFirst();
        list.display();

        list.removeLast();
        list.display();
    }
}
