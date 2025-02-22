import java.util.LinkedList;
import java.util.Queue;

class CallCenter {
    // 用队列来存储lead，對列會有先進先出的特性，最早空閒的員工應該優先接到新的電話
    private Queue<LeadEmp> leads = new LinkedList<>();
    private Queue<JuniorEmp> juniors = new LinkedList<>();
    private Queue<BossEmp> bosses = new LinkedList<>();

    public CallCenter(int numLeads, int numJuniors, int numBosses) {
        
    }

    
    
    

}
