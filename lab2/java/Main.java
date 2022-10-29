public class Main {
    public static void main(String[] args) {
        Equations equations = new Equations(3, 2, 500, -1, 1, 0);
        equations.print();
        equations.graph("graph.png", 300, 300);
    }
}
