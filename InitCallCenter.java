public class InitCallCenter {
  public static void main(String[] args) {
    CallCenter callCenter = new CallCenter(5, 3, 2);

    // 创建电话来测试升级机制
    // 首先创建5个初级电话（假设有5个junior员工）
    Call call1 = new Call(EmpRank.JUNIOR);
    Call call2 = new Call(EmpRank.JUNIOR);
    Call call3 = new Call(EmpRank.JUNIOR);
    Call call4 = new Call(EmpRank.JUNIOR);
    Call call5 = new Call(EmpRank.JUNIOR);
    
    // 派发这些电话，应该都由junior员工接听
    callCenter.dispatch(call1);
    callCenter.dispatch(call2);
    callCenter.dispatch(call3);
    callCenter.dispatch(call4);
    callCenter.dispatch(call5);
    
    // 再创建一个junior级别的电话，此时应该由lead来接听
    Call call6 = new Call(EmpRank.JUNIOR);
    callCenter.dispatch(call6);
    
    // 创建更多junior电话测试升级到boss
    Call call7 = new Call(EmpRank.JUNIOR);
    Call call8 = new Call(EmpRank.JUNIOR);
    Call call9 = new Call(EmpRank.JUNIOR);
    callCenter.dispatch(call7);
    callCenter.dispatch(call8);
    callCenter.dispatch(call9);

    // 创建多个电话来测试
    Call call10 = new Call(EmpRank.JUNIOR);
    Call call11 = new Call(EmpRank.JUNIOR);
    Call call12 = new Call(EmpRank.JUNIOR);
    Call call13 = new Call(EmpRank.JUNIOR);
    Call call14 = new Call(EmpRank.LEAD);
    Call call15 = new Call(EmpRank.LEAD);
    Call call16 = new Call(EmpRank.BOSS);
    Call call17 = new Call(EmpRank.JUNIOR);
    Call call18 = new Call(EmpRank.LEAD);
    Call call19 = new Call(EmpRank.JUNIOR);
    Call call20 = new Call(EmpRank.LEAD);

    // 派发所有电话，模拟繁忙情况
    callCenter.dispatch(call10);
    callCenter.dispatch(call11);
    callCenter.dispatch(call12);
    callCenter.dispatch(call13);
    callCenter.dispatch(call14);
    callCenter.dispatch(call15);
    callCenter.dispatch(call16);
    callCenter.dispatch(call17);
    callCenter.dispatch(call18);
    callCenter.dispatch(call19);
    callCenter.dispatch(call20);

    // 模拟通话结束时，由对应的员工结束通话
    Emp emp1 = new LeadEmp("張三");
    Emp emp2 = new JuniorEmp("李四");
    Emp emp3 = new BossEmp("王五");
    // 结束通话
    emp1.endCall();
    emp2.endCall();
    emp3.endCall();
    // 在通话结束后尝试派发新的通话，测试员工是否可以接听新电话
    Call newCall1 = new Call(EmpRank.JUNIOR);
    Call newCall2 = new Call(EmpRank.LEAD);
    Call newCall3 = new Call(EmpRank.BOSS);

    callCenter.dispatch(newCall1);
    callCenter.dispatch(newCall2);
    callCenter.dispatch(newCall3);
  }
}
