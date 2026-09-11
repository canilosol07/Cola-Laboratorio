public class Main {
    public static void main(String[] args) {

        Queue queue = new Queue(false);   // cola normal

        //Modulo isEmpty
        System.out.println(queue.isEmpty());

        //Modulo insert
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");

        //Modulo toString
        System.out.println(queue.toString());

        //Modulo size
        System.out.println(queue.size());

        //Modulo search
        System.out.println(queue.search("B"));
        System.out.println(queue.search("X"));

        //Modulo extract
        System.out.println(queue.extract());
        System.out.println(queue.toString());

        //Modulo clear
        queue.clear();
        System.out.println(queue.toString());
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());

        // Prioridad
        Queue colaPrioridad = new Queue(true);

        colaPrioridad.insert("Angel Fabian", 5);
        colaPrioridad.insert("Calvo", 1);
        colaPrioridad.insert("Martin", 5);
        colaPrioridad.insert("Adriancito", 0);

        System.out.println(colaPrioridad.toString());
        System.out.println(colaPrioridad.extract());
        System.out.println(colaPrioridad.extract());
    }
}