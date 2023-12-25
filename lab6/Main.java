public class Main {
    public static void main(String[] args) {
        ControlFactory controlFactory = new OSControlFactory();
        Label label = controlFactory.createLabel();
        TextBox textBox = controlFactory.createTextBox();
        ComboBox comboBox = controlFactory.createComboBox();
        Button button = controlFactory.createButton();
        button.click();
    }
}