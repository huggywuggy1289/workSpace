package hwch16.ch16;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption);
    }

    // Mediator를 받아서 보관
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 중재를 받을 경우 if문에 맞게
    //활성/비활성 여부를 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        this.setEnabled(enabled);
    }
}
