package library;

public class Book {
    private int id;
    private String title;
    private static int counter = 0;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        counter += 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "ID_" + id + " " + title;
    }
}
