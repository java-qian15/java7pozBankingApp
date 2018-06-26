package repository;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.enterprise.context.RequestScoped;
import java.util.Optional;

@RequestScoped
public class UserRepository extends GenericRepository<User, Long> {

    public Optional<User> findByEmail(String email){
        try(
             Session   session = HibernateUtil.openSession()
                ) {
            String hql = "SELECT u FROM User u WHERE u.email = :email";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            User singleResult = (User) query.getSingleResult();
            return Optional.ofNullable(singleResult);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<User> findByActivationCode(String code){
        try(
                Session   session = HibernateUtil.openSession()
        ) {
            String hql = "SELECT u FROM User u WHERE u.activationCode = :code";
            Query query = session.createQuery(hql);
            query.setParameter("code", code);
            User singleResult = (User) query.getSingleResult();
            return Optional.ofNullable(singleResult);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
