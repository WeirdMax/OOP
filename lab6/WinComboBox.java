import java.util.ArrayList;
import java.util.List;

public class WinComboBox extends Control implements ComboBox {
    private int selectedIndex;
    private List<String> items = new ArrayList<>();
    @Override
    public int getSelectedIndex() {
        return selectedIndex;
    }

    @Override
    public void setSelectedIndex(int index) {
        System.out.println("Method called from Windows Button");
    }

    @Override
    public void setItems(List<String> items) {
        System.out.println("Method called from Windows Button");
    }

    @Override
    public List<String> getItems() {
        return items;
    }
}