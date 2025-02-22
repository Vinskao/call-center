abstract class Emp {
    protected EmpRank rank;
    protected String name;
    private boolean isAvailable = true;

    public Emp(EmpRank rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void handleCall(Call call) {
        // 如果員工是空閒的，則處理電話
        if (this.isAvailable) {
            System.out.println(this.name + " (" + this.rank + ") is handling call " + call);
            this.isAvailable = false;
            endCall();
        } else {
            System.out.println(this.name + " is not available");
        }
    }

    protected void endCall() {
        System.out.println(this.name + " finished call");
        this.isAvailable = true;
    }
}
