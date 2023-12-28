public class StringCommand extends Command{
    private String name;

    @Override
    public  void run() {
        System.out.println("Print: " + this.name);
    }

    @Override
    public void undo() {
        System.out.println("Undo: " + this.name);
    }

    public StringCommand(String name) {
        this.name = name;
    }
}
