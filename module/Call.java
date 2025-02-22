public class Call {
    private static int idCreator = 0;
    private int id;
    private EmpRank rank;
    private boolean isActive = true;

    public Call(EmpRank rank) {
        this.id = ++idCreator;
        this.rank = rank;
    }

    public EmpRank getRank() {
        return rank;
    }

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                ", rank=" + rank +
                '}';
    }
}