import java.util.LinkedList;
import java.util.Queue;

class CallCenter {
    private static final String[] LEAD_NAMES = {
        "張三", "李四", "David", "Mary", "小明", "小華"
    };
    
    private static final String[] JUNIOR_NAMES = {
        "王五", "趙六", "John", "Sarah", "小芳", "小美"
    };
    
    private static final String[] BOSS_NAMES = {
        "James", "Emma", "Michael", "Sophie"
    };
    
    // 用队列来存储lead，對列會有先進先出的特性，最早空閒的員工應該優先接到新的電話
    private Queue<LeadEmp> availableLeads = new LinkedList<>();
    private Queue<JuniorEmp> availablejuniors = new LinkedList<>();
    private Queue<BossEmp> availablebosses = new LinkedList<>();

    // 初始化CallCenter，创建指定数量的Lead、Junior和Boss员工
    public CallCenter(int numLeads, int numJuniors, int numBosses) {
        for(int i = 0; i < numLeads; i++){
            LeadEmp lead = new LeadEmp(LEAD_NAMES[i]);
            if(lead.isAvailable()){
                availableLeads.add(lead);
            }
        }  
        for(int i = 0; i < numJuniors; i++){
            JuniorEmp junior = new JuniorEmp(JUNIOR_NAMES[i]);
            if(junior.isAvailable()){
                availablejuniors.add(junior);
            }
        }
        for(int i = 0; i < numBosses; i++){
            BossEmp boss = new BossEmp(BOSS_NAMES[i]);
            if(boss.isAvailable()){
                availablebosses.add(boss);
            }
        }
    }

    // 派发电话给员工
    public void dispatch(Call call){
        System.err.println("CallCenter dispatching...");
        Emp emp = getAvailableEmp(call.getRank());
        if(emp != null){
            emp.handleCall(call);
        }else{
            System.err.println("No available employee to handle call");
        }
    }

    private Emp getAvailableEmp(EmpRank rank){
        // 創建一個Emp對象
        Emp emp = null;
        switch(rank){
            case JUNIOR:
                if(!availablejuniors.isEmpty()){
                    emp = availablejuniors.poll();
                } else if(!availableLeads.isEmpty()){
                    emp = availableLeads.poll();
                } else if(!availablebosses.isEmpty()){
                    emp = availablebosses.poll();
                }
                break;
            case LEAD:
                if(!availableLeads.isEmpty()){
                    emp = availableLeads.poll();
                } else if(!availablebosses.isEmpty()){
                    emp = availablebosses.poll();
                }
                break;
            case BOSS:
                if(!availablebosses.isEmpty()){
                    emp = availablebosses.poll();
                } 
                break;
            default:
                break;
        }
        return emp;
    }

    public void returnToAvailable(Emp emp){
        if(emp == null){
            System.err.println("Employee is null");
            return;
        }

        if(emp.isAvailable()){
            try {
                switch(emp.rank) {
                    case JUNIOR -> availablejuniors.add((JuniorEmp) emp);
                    case LEAD -> availableLeads.add((LeadEmp) emp);
                    case BOSS -> availablebosses.add((BossEmp) emp);
                    default -> System.err.println("Invalid employee rank");
                }
            } catch (Exception e) {
                System.err.println("Error returning employee to available list");
            }
        }
    }
}
