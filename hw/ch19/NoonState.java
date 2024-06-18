package hw.ch19;

public class NoonState implements State {
    private static NoonState singleton = new NoonState();

    private NoonState(){

    }
    public static State getInstance(){
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (9 <= hour && hour < 12) {
            context.changeState(DayState.getInstance());
        } else if (12 <= hour && hour < 17) {
            context.changeState(NoonState.getInstance());
        } else if (17 <= hour && hour < 22) {
            context.changeState(NightState.getInstance());
        } else {
            context.changeState(NightMealState.getInstance());
        }
    }
    
    
    
    

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("금고사용!(오후)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨!(오후)");
    }

    @Override
    public void doPhone(Context context) {
       context.recordLog("통화녹음(오후)");
    }

    @Override
    public void doCCTV(Context context) {
       context.recordLog("CCTV 해상도 300 dpi로 변경");
    }
    
    public String toString(){
        return "[오후]";
    }
}
