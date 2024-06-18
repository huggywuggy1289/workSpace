package hw.ch22.Command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MacroCommand implements Command {
    // 명령의 배열 
    private Deque<Command> commands = new ArrayDeque<>();

    // 추가: Deque commandsForRedo 속성을 추가
    private Deque<Command> commandsForRedo = new ArrayDeque<>();

    // 실행 
    @Override
    public void execute() {
        // commands에 저장된 명령을 역순으로 순회하면서 명령을 실행하는 역할
        // descendingIterator를 그냥 사용할 수 없어서 commands 변수가 
        // ArrayDeque<Command> 타입이니 이것으로 캐스팅 한 뒤 메서드를 이용해
        // 명령들을 아래서부터 순회하여 호출할 수 있도록 반복자를 얻는 것이다.
        Iterator<Command> it = ((ArrayDeque<Command>) commands).descendingIterator();
        while (it.hasNext()) {
            Command cmd = it.next();
            cmd.execute();
        }
        // for (Command cmd: commands) {
        //     cmd.execute();
        // }
    }

    // 추가 
    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    // 마지막 명령을 삭제
    public void undo() { // 뒤로가기
        if (!commands.isEmpty()) {
            Command cmd = commands.pop();
            cmd.execute(); // = commands.pop()과 동일하다
            commandsForRedo.push(cmd); // 최근명령 삭제한걸 이 속성에 추가
        }
    }

    // 전부 삭제 
    public void clear() {
        commands.clear();
    }

    public void redo(){
        if (!commandsForRedo.isEmpty()){
            // undo 메서드에는 삭제한 명령을 변수에 저장하는 기능도 포함함.
            // 이걸 다시 꺼내와야 한다.
            Command cwd = commandsForRedo.pop(); // push한걸 빼온다.
            cwd.execute(); // 실행한다.
            commands.push(cwd); // 실행한 명령을 다시 commands 스택에 추가한다.
        }
    }

    
}
