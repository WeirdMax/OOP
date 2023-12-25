public interface IUserRepository extends IRepository<User> {
    User getById(int id);
    User getByLogin(String login);
}