public class WinControlFactory implements ControlFactory{
    public WinControlFactory() {
        System.out.println("Creating WindowsControlFactory");
    }
    @Override
    public Label createLabel() {
        return new WinLabel();
    }

    @Override
    public TextBox createTextBox() {
        return new WinTextBox();
    }

    @Override
    public ComboBox createComboBox() {
        return new WinComboBox();
    }

    @Override
    public Button createButton() {
        return new WinButton();
    }
}