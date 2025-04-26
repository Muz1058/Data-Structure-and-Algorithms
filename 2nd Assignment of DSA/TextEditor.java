import java.util.Stack;
enum ActionType {
    INSERT,DELETE
}
class Action{
    private  ActionType type;
    private  String text;

    public Action(ActionType type, String text) {
        this.type = type;
        this.text = text;
    }

    public ActionType getType() {
        return type;
    }

    public String getText() {
        return text;
    }
    public String toString() {
        return "Type: " + type + ", Text: \"" + text + "\"";
    }
}


class EditorControl {
    private final Stack<Action> undoStack = new Stack<>();
    private final Stack<Action> redoStack = new Stack<>();
    private String content = "";


    public void performAction(ActionType type, String text) {
        if (type == null || text == null || text.isEmpty()) {
            System.out.println("Invalid action or text.");
            return;
        }

        Action action = new Action(type, text);

        switch (type) {
            case INSERT:
                content += text;
                break;
            case DELETE:
                int len = text.length();
                if (content.length() >= len) {
                    content = content.substring(0, content.length() - len);
                } else {
                    System.out.println("Delete length exceeds current content. No action performed.");
                    return;
                }
                break;
            default:
                System.out.println("Unknown action type.");
        }
        undoStack.push(action);
        redoStack.clear();
        System.out.println("Performed: " + action);
        showContent();
    }


    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        Action lastAction = undoStack.pop();
        switch (lastAction.getType()) {
            case INSERT:
                if (content.length() >= lastAction.getText().length()) {
                    content = content.substring(0, content.length() - lastAction.getText().length());
                }
                break;
            case DELETE:
                content += lastAction.getText();
                break;
            default:
                System.out.println("Unknown action type in undo.");
        }
        redoStack.push(lastAction);
        System.out.println("Undo " + lastAction.getType() + ": \"" + lastAction.getText() + "\"");
        showContent();
    }



    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }

        Action action = redoStack.pop();
        switch (action.getType()) {
            case INSERT:
                content += action.getText();
                break;
            case DELETE:
                if (content.length() >= action.getText().length()) {
                    content = content.substring(0, content.length() - action.getText().length());
                }
                break;
            default:
                System.out.println("Unknown action type in redo.");
        }


        undoStack.push(action);
        System.out.println("Redo " + action.getType() + ": \"" + action.getText() + "\"");
        showContent();
    }


    public void showContent() {
        System.out.println("Current Content: \"" + content + "\"\n");
    }


    public void showHistory() {
        System.out.println("Undo Stack History:");
        for (int i = undoStack.size() - 1; i >= 0; i--) {
            System.out.println("  " + undoStack.get(i));
        }
        System.out.println();
    }
}

public class TextEditor {
    public static void main(String[] args) {
        EditorControl editor = new EditorControl();

        editor.performAction(ActionType.INSERT, "Hello");
        editor.performAction(ActionType.INSERT, " World");
        editor.performAction(ActionType.DELETE, " World");
        editor.undo();
        editor.redo();
        editor.performAction(ActionType.INSERT, "!!!");
        editor.undo();
        editor.showHistory();
    }
}
