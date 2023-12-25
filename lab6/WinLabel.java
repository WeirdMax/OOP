public class WinLabel extends Control implements Label {
    private String text;


    @Override
    public void setText(String text) {
        System.out.println("Method called from Windows Button");
    }

    @Override
    public String getText() {
        return text;
    }

}