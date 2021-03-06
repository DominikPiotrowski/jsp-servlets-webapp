package repo;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.Optional;

@Slf4j
public class UserRepository extends GenericRepository<User, Long> {

    public Optional<User> findByEmail(String email) {

        try (Session session = HibernateUtil.openSession()) {
            Query query = session.createQuery("SELECT u FROM User u WHERE u.email=:a");
            query.setParameter("a", email);

            User user = (User) query.uniqueResult();
            return Optional.ofNullable(user);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Optional.empty();
        }
    }
}