package hwch16.ch16;

public interface Mediator {
    // Colleague를 생성하는 메소드
    public abstract void createColleagues();

    // Colleage의 상태가 변화했을 때 호출된다 즉, 통지 받을 때 메소드
    public abstract void colleagueChanged();
}
