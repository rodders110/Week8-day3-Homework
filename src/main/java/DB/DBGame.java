package DB;

import Models.Console;
import Models.Game;
import Models.Owner;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBGame {

    public static Session session;



    public static List<Console> getAvailableOn(Game game){
        List<Console> results = null;
        session = HibernateUtil.getSessionFactory().openSession();

        try{
            Criteria cr = session.createCriteria(Console.class);
            cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            cr.createAlias("games", "game");
            cr.add(Restrictions.eq("game.id", game.getId()));
            results = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static List<Owner> getFavOwner (Game game){
        session = HibernateUtil.getSessionFactory().openSession();

        List<Owner> results = null;

        try{
            Criteria cr = session.createCriteria(Owner.class);
            cr.add(Restrictions.eq("favGame", game));
            results = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return results;
    }


}
