public class Call {
    // Basic implementation
    private static int counter = 0;
    private final int id;

    public Call() {
        this.id = ++counter;
    }

    @Override
    public String toString() {
        return "Call-" + id;
    }
} 