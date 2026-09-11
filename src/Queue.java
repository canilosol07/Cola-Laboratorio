public class Queue implements QueueInterface {

    QueueNode head;
    QueueNode tail;
    int size = 0;
    boolean isPriorityQueue;

    public Queue(boolean isPriorityQueue) {
        this.isPriorityQueue = isPriorityQueue;
        this.head = null;
        this.tail = null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object extract() {
        if (isEmpty()) {
            return null;
        }

        Object datoExtraido = head.object;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size = size - 1;
        return datoExtraido;
    }

    @Override
    public boolean insert(Object object) {
        QueueNode nuevoNodo = new QueueNode(object);

        if (isEmpty()) {
            head = nuevoNodo;
            tail = nuevoNodo;
        } else {
            tail.next = nuevoNodo;
            tail = nuevoNodo;
        }

        size = size + 1;
        return true;
    }

    @Override
    public boolean insert(Object object, int prioridad) {

        if (!isPriorityQueue) {
            return insert(object);
        }

        QueueNode nuevoNodo = new QueueNode(object, prioridad);

        if (isEmpty() || head.priority > prioridad) {
            nuevoNodo.next = head;
            head = nuevoNodo;
            if (tail == null) {
                tail = nuevoNodo;
            }
        } else {
            QueueNode actual = head;
            while (actual.next != null && actual.next.priority <= prioridad) {
                actual = actual.next;
            }
            nuevoNodo.next = actual.next;
            actual.next = nuevoNodo;

            if (nuevoNodo.next == null) {
                tail = nuevoNodo;
            }
        }

        size = size + 1;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean search(Object object) {
        QueueNode actual = head;
        while (actual != null) {
            if (actual.object == object) {
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    @Override
    public String toString() {
        String resultado = "[";
        QueueNode actual = head;
        while (actual != null) {
            resultado = resultado + actual.object;
            if (actual.next != null) {
                resultado = resultado + ", ";
            }
            actual = actual.next;
        }
        resultado = resultado + "]";
        return resultado;
    }
}