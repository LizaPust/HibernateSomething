import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Edit implements Command{

    @Override
    public void process(){

        int id = 4;

        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            Client client = (Client) session.get(Client.class, id);
            session.evict(client);

            client.setName("JoJo");
            session.update(client);

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
