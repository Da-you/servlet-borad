package hello.controller;

import hello.controller.action.*;

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
        } else if (command.equals("board_view")) {
            action = new BoardViewAction();
        } else if (command.equals("board_update_form")) {
            action = new BoardUpdateFormAction();
        } else if (command.equals("board_update")) {
            action = new BoardUpdateAction();
        } else if (command.equals("board_delete")) {
            action = new BoardDeleteAction();
        }
        return action;
    }
}
