package hw.ch19;

public class DayState implements State { // 구체적인 상태를 나타내는 클래스
    private static DayState singleton = new DayState();

    private DayState() { // 생성자 형성
    }

    public static State getInstance() { // 인스턴스 한개 생성
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
    public void doUse(Context context) { // 주간상태에서 일을 표현하는 메서드
        context.recordLog("금고사용(주간)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(주간)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("일반 통화(주간)");
    }

    @Override
    public String toString() {
        return "[주간]";
    }

    @Override
    public void doCCTV(Context context) {
       context.recordLog("CCTV 해상도 600 dpi로 변경");
    }
}
