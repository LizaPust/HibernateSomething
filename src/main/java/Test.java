import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        int id = 30;

        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            Client client = new Client();
            client.setName("John");
            client.setAdress("Africa");
            client.setNumber("123");

            session.save(client);

            session.getTransaction().commit();

        } catch (Throwable cause) {
            cause.printStackTrace();
        }


        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            Client client = (Client) session.get(Client.class, id);

            session.delete(client);

            session.getTransaction().commit();

        } catch (Throwable cause) {
            cause.printStackTrace();
        }


        List<Client> list = null;

        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Query query = session.createQuery("From Client");
            list = (List<Client>) query.list();

        } catch (Throwable cause) {
            cause.printStackTrace();
        }

        if (list != null && !list.isEmpty()) {
            for (Client client : list) {
                System.out.println(client);
            }

        }

    }
}
