class UserManager implements IUserManager {
    private User currentUser;
    private IUserRepository userRepository;

    public UserManager(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.currentUser = null;
    }

    @Override
    public void signIn(User user) {
        currentUser = user;
    }

    @Override
    public void signOut(User user) {
        if (currentUser != null && currentUser.getId() == user.getId()) {
            currentUser = null;
        }
    }

    @Override
    public boolean isAuthorized() {
        return currentUser != null;
    }
}