package ui.todo.model;

public final class Item {

    private final String name;
    private boolean done;

    public Item(String name, boolean done) {
        this.name = name;
        this.done = done;
    }

    public boolean done() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String name() {
        return name;
    }
}
