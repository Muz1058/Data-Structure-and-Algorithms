import java.util.Stack;

class TextAction {
    enum ActionType {
        INSERT,
        DELETE
    }

    ActionType type;
    String content;
    int position;

    public TextAction(ActionType type, String content, int position) {
        this.type = type;
        this.content = content;
        this.position = position;
    }

    @Override
    public String toString() {
        return type + " \"" + content + "\" at position " + position;
    }
}

class TextEditor {
    private String text;
    private Stack<TextAction> actionStack;

    public TextEditor() {
        text = "";
        actionStack = new Stack<>();
    }

    public void insert(String content, int position) {
        if (position < 0 || position > text.length()) {
            System.out.println("Invalid position");
            return;
        }

        String beforeInsert = text.substring(0, position);
        String afterInsert = text.substring(position);
        text = beforeInsert + content + afterInsert;

        TextAction action = new TextAction(TextAction.ActionType.INSERT, content, position);
        actionStack.push(action);

        System.out.println("Inserted: \"" + content + "\" at position " + position);
        System.out.println("Current text: " + text);
    }

    public void delete(int position, int length) {
        if (position < 0 || position + length > text.length()) {
            System.out.println("Invalid position or length");
            return;
        }

        String deletedContent = text.substring(position, position + length);

        String beforeDelete = text.substring(0, position);
        String afterDelete = text.substring(position + length);
        text = beforeDelete + afterDelete;

        TextAction action = new TextAction(TextAction.ActionType.DELETE, deletedContent, position);
        actionStack.push(action);

        System.out.println("Deleted: \"" + deletedContent + "\" from position " + position);
        System.out.println("Current text: " + text);
    }

    public void undo() {
        if (actionStack.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }

        TextAction lastAction = actionStack.pop();

        if (lastAction.type == TextAction.ActionType.INSERT) {
            String beforeDelete = text.substring(0, lastAction.position);
            String afterDelete = text.substring(lastAction.position + lastAction.content.length());
            text = beforeDelete + afterDelete;
            System.out.println("Undid insertion: \"" + lastAction.content + "\"");
        } else if (lastAction.type == TextAction.ActionType.DELETE) {
            String beforeInsert = text.substring(0, lastAction.position);
            String afterInsert = text.substring(lastAction.position);
            text = beforeInsert + lastAction.content + afterInsert;
            System.out.println("Undid deletion: \"" + lastAction.content + "\"");
        }

        System.out.println("Current text: " + text);
    }

    public String peekCurrentState() {
        return text;
    }

    public void displayAllActions() {
        if (actionStack.isEmpty()) {
            System.out.println("No actions performed yet");
            return;
        }

        System.out.println("\nAction History (most recent at top):");
        System.out.println("====================================");

        Stack<TextAction> tempStack = new Stack<>();
        while (!actionStack.isEmpty()) {
            tempStack.push(actionStack.pop());
        }

        int actionNumber = 1;
        while (!tempStack.isEmpty()) {
            TextAction action = tempStack.pop();
            System.out.println(actionNumber + ". " + action);
            actionStack.push(action);
            actionNumber++;
        }

        System.out.println("====================================");
    }
}

public class TextEditorDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.insert("Hello", 0);
        editor.insert(" world", 5);
        editor.insert("!", 11);

        editor.displayAllActions();

        editor.undo();

        editor.insert(" Java", 10);

        System.out.println("\nCurrent state: " + editor.peekCurrentState());

        editor.delete(0, 6);

        editor.displayAllActions();

        editor.undo();
        editor.undo();

        System.out.println("\nFinal state: " + editor.peekCurrentState());
    }
}