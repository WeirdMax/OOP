import java.util.List;
import java.util.Map;

public class Workflow {
    public void showLastPerformedAction(List<Map.Entry<Key, String>> keys) {
        Map.Entry<Key, String> action = keys.get(keys.size() - 1);
        System.out.println(action.getKey().getKeyName() + " | " + action.getValue());
    }
}