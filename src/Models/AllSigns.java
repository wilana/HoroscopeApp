package Models;

public class AllSigns {
    private Sign[] signs;

    public AllSigns(Sign[] signs) {
        setSigns(signs);
    }

    public Sign[] getSigns() {
        return signs;
    }

    public void setSigns(Sign[] signs) {
        this.signs = signs;
    }
}
