package hello.controller;

import hello.controller.action.Action;
import hello.controller.action.BoardListAction;
import hello.controller.action.BoardPostAction;
import hello.controller.action.BoardPostFormAction;

public class ActionFactory {
    private static ActionFactory instance = new ActionFactory();

    private ActionFactory() {
        super();
    }

    public static ActionFactory getInstance() {
        return instance;
    }

    public Action getAction(String command) {
        Action action = null;
        System.out.println("ActionFactory :" + command);
        if (command.equals("board_list")) {
            action = new BoardListAction();
        } else if (command.equals("board_post_form")) {
            action = new BoardPostFormAction();
        } else if (command.equals("board_post")) {
            action = new BoardPostAction();
        }
        return action;
    }
}
