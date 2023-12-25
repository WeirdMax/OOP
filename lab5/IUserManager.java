
public interface IUserManager {
    void signIn(User user);
    void signOut(User user);
    boolean isAuthorized();
}