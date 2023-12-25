public class OSControlFactory implements ControlFactory {
    String osName = System.getProperty("os.name").toLowerCase();
    @Override
    public Label createLabel() {
        if (osName.startsWith("win")) {
            return new WinLabel();
        }
        return null;
    }

    @Override
    public TextBox createTextBox() {
        if (osName.startsWith("win")) {
            return new WinTextBox();
        }
        return null;
    }

    @Override
    public ComboBox createComboBox() {
        if (osName.startsWith("win")) {
            return new WinComboBox();
        }
        return null;
    }

    @Override
    public Button createButton() {
        if (osName.startsWith("win")) {
            return new WinButton();
        }
        return null;
    }
}

