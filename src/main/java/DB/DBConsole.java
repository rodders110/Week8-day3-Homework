package DB;

import Models.Console;
import Models.Game;
import com.sun.xml.internal.ws.handler.HandlerException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBConsole {

    private static Session session;




    public static List<Game> getGames(Console console){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Game> results = null;

        try{
            Criteria cr = session.createCriteria(Game.class);
            cr.createAlias("consoleList", "console");
            cr.add(Restrictions.eq("console.id", console.getId()));
            cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            results = cr.list();
        } catch (HandlerException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return results;
    }

    public static void addGametoConsole(Game game, Console console){

        console.addGame(game);
        game.addConsole(console);
        DBHelper.update(game);
    }
}
