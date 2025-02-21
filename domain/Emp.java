public class Emp {
    protected EmpRank rank;
    private boolean isAvailable = true;

    public Emp(EmpRank rank) {
        this.rank = rank;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void handleCall(Call call) {
        // 如果員工是空閒的，則處理電話
        if (this.isAvailable) {
            System.out.println(this.getClass().getSimpleName() + " is handling call " + call);
            this.isAvailable = false;
            endCall();
        } else {
            System.out.println(this.getClass().getSimpleName() + " is not available");
        }
    }

    public void endCall() {
        System.err.println(this.getClass().getSimpleName() + " finished call");
        this.isAvailable = true;
    }
}
