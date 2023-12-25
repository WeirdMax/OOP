
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUserRepository implements IUserRepository{
    private List<User> users;
    private String filePath;

    public FileUserRepository(String filePath) {
        this.filePath = filePath;
        this.users = new ArrayList<>();
        loadUsersFromFile();
    }

    private void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String login = parts[1];
                String password = parts[2];
                String name = parts[3];
                User user = new User(id, login, password, name);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : users) {
                String line = user.getId() + "," + user.getLogin() + "," + user.getPassword() + "," + user.getName();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void add(User item) {
        users.add(item);
        saveUsersToFile();
    }

    @Override
    public void remove(User item) {
        users.remove(item);
        saveUsersToFile();
    }

    @Override
    public void update(User item) {
        // ~
    }

    @Override
    public User getById(int id) {
        for (User user : users) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}