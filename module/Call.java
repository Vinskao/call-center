public class Call {
    private static int idCreator = 0;
    private int id;
    private EmpRank rank;

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

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                ", rank=" + rank +
                '}';
    }
}