package dao;

import com.sun.istack.NotNull;
import entities.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDAO implements DAO<User, Integer> {

    private final SessionFactory factory;

    public UserDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final User engine) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(engine);

            session.getTransaction().commit();
        }
    }

    @Override
    public User read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {

            final User result = session.get(User.class, id);

            if (result != null) {
                Hibernate.initialize(result.getName());
            }

            return result != null ? result : new User();
        }
    }

    @Override
    public List<User> readAll() {
        try (final Session session = factory.openSession()) {

            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<User> criteria = builder.createQuery(User.class);

            criteria.from(User.class);

            List<User> result = session.createQuery(criteria).getResultList();

            for (User user : result) {
                if (user != null) {
                    Hibernate.initialize(user.getName());
                    Hibernate.initialize(user.getLocation());
                    Hibernate.initialize(user.getLocation().getStreet());
                    Hibernate.initialize(user.getLocation().getTimezone());
                    Hibernate.initialize(user.getLocation().getCoordinates());
                    Hibernate.initialize(user.getLogin());
                    Hibernate.initialize(user.getDob());
                    Hibernate.initialize(user.getRegistered());
                    Hibernate.initialize(user.getID());
                    Hibernate.initialize(user.getPicture());




                }
            }

            return result;
        }
    }

    public User readLast() {
        try (final Session session = factory.openSession()) {
            User result = (User) session.createQuery("from User order by id DESC ").setMaxResults(1).uniqueResult();

            if (result != null) {
                Hibernate.initialize(result.getName());
            }

            return result;
        }
    }

    @Override
    public void update(@NotNull final User engine) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(engine);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final User engine) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(engine);

            session.getTransaction().commit();
        }
    }
}
