package hwch16.ch16;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {
    private Mediator mediator;

    //CheckboxGroup group의 중요성: 라디오 버튼을 한 그룹에 지정해야 중복 선택이 안된다.
    public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {
        super(caption, group, state);
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        this.setEnabled(enabled);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // 상태가 변화하면 Mediator에 알린다
        mediator.colleagueChanged();
    }
}
