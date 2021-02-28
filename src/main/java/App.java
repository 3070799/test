import dao.DAO;
import dao.UserDAO;
import entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {

    public void reedDB (){

        SessionFactory factory = null;

        try {

            factory = new Configuration().configure().buildSessionFactory();
            DAO<User, Integer> userDAO = new UserDAO(factory);

            List<User> users = userDAO.readAll();
            System.out.println(users);
        }
        finally {
            if (factory != null){
                factory.close();
            }
        }
    }

    public void userToDatabase (){

        SessionFactory factory = null;

        try {

            factory = new Configuration().configure().buildSessionFactory();
            DAO<User, Integer> userDAO = new UserDAO(factory);

            List<User> users = JsonParse.jsonToUsers(JsonParse.urlToJson("https://randomuser.me/api/?results=5000"));
            users = setIdsList(users);

            for (User user : users) {
                userDAO.create(user);
            }
        }
        finally {
            if (factory != null){
                factory.close();
            }
        }
    }

    public List<User> setIdsList(List<User> users){

        SessionFactory factory = null;
        int id;
        try {

            factory = new Configuration().configure().buildSessionFactory();
            DAO<User, Integer> userDAO = new UserDAO(factory);
            id = userDAO.readLast().getId()+1;
        }
        finally {
            if (factory != null){
                factory.close();
            }
        }


        for (User user : users) {
            setIds(user,id);
            id++;
        }
        return users;
    }

    public User setIds(User user, int id){

        user.setId(id);
        user.getName().setId(id);
        user.getLocation().setId(id);
        user.getLocation().getStreet().setId(id);
        user.getLocation().getCoordinates().setId(id);
        user.getLocation().getTimezone().setId(id);
        user.getLogin().setId(id);
        user.getDob().setId(id);
        user.getRegistered().setId(id);
        user.getID().setId(id);
        user.getPicture().setId(id);

        return user;
    }


}
