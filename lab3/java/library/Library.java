package library;

public class Library {
    private Node root;

    /**
     * Method add book node to the btree structure of Library
     *
     * @param book the book to be added
     */
    public void add(Book book) {
        Node current = root;
        Node parent = null;
        Node node = new Node(book);

        while (current != null) {
            if (current.getBook().getId() == node.getBook().getId()) {
                System.out.println("Book: " + "'" + node.getBook() + "' was previously added to the library.");
                return;
            }
            parent = current;
            current = (node.getBook().getId() < current.getBook().getId()) ? current.getLeft() : current.getRight();
        }
        node.setParent(parent);
        if (parent == null) {
            root = node;
        } else if (node.getBook().getId() < parent.getBook().getId()) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }
    }

    /**
     * Method printing btree structure of Library
     */
    public void print() {
        printNode(root, 0);
    }

    /**
     * Method that search book with specific id in btree
     *
     * @param id identifier of the book
     * @return searched book or null if it does not exist
     */
    public Book findBookById(int id) {
        long start = System.nanoTime();
        Node current = root;
        while((current != null) && current.getBook().getId() != id) {
            current = (id < current.getBook().getId()) ? current.getLeft() : current.getRight();
        }
        long end = System.nanoTime();
        System.out.println("Search time: " + (end - start) + " ns.");
        if (current != null) {
            return current.getBook();
        }
        return null;
    }

    /**
     * Recursive helper method for printing whole btree structure of Library
     *
     * @param node current node
     * @param spaces int number of spaces (indents)
     */
    private void printNode(Node node, int spaces) {
        if (node != null) {
            spaces += 2;
            System.out.print(" ".repeat(spaces) + "-- ");
            System.out.println(node.getBook());
            printNode(node.getLeft(), spaces);
            printNode(node.getRight(), spaces);
        }
    }
}
