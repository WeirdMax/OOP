public class WinButton extends Control implements Button {
    private String text;
    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setOnClick() {
        System.out.println("Method called from Windows Button");
    }

    @Override
    public void click() {
        System.out.println("Method called from Windows Button");
    }
}