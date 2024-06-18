package hw.ch19;

// DayState 클래스와 거의 비슷하다.
public class NightMealState implements State {
    private static NightMealState singleton = new NightMealState();

    private NightMealState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (9 <= hour && hour < 12) { // 주간
            context.changeState(DayState.getInstance());
        } else if (12 <= hour && hour < 17) { // 오후
            context.changeState(NoonState.getInstance());
        } else if (17 <= hour && hour < 22) { //야간
            context.changeState(NightState.getInstance());
        } else { //야식
            context.changeState(NightMealState.getInstance());
        }
    }
    

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("비상：야식시간 금고 사용！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(야식시간)");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("야식시간 통화 녹음");
    }

    @Override
    public String toString() {
        return "[야식]";
    }

    @Override
    public void doCCTV(Context context) {
       context.recordLog("CCTV Off");
    }
}