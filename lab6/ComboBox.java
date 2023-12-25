import java.util.ArrayList;
import java.util.List;

public interface ComboBox {
    public int getSelectedIndex();
    public void setSelectedIndex(int index);
    public void setItems(List<String> items);
    public List<String> getItems();
}