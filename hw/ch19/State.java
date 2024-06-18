package hw.ch19;

public interface State { // 상태를 대표하는 인터페이스
    public abstract void doClock(Context context, int hour);	// 시간 설정
    public abstract void doUse(Context context);		// 금고 사용 
    public abstract void doAlarm(Context context);		// 비상벨 
    public abstract void doPhone(Context context);		// 일반 통화 
    public abstract void doCCTV(Context context); // cctv작동
}
