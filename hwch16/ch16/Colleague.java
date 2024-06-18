package hwch16.ch16;

public interface Colleague {
    // 클래스 Mediator를 설정한다 
    public abstract void setMediator(Mediator mediator);

    // Mediator에서 활성/비활성을 지시한다 
    //즉, 지시 받을 때 메소드(true=활성화 false=비활성화)
    public abstract void setColleagueEnabled(boolean enabled);
}
