import DB.DBConsole;
import DB.DBGame;
import DB.DBHelper;
import Models.Console;
import Models.Game;
import Models.GenreType;
import Models.Owner;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {






        Console ps4 = new Console("Sony", "PS4", "Europe");
        DBHelper.save(ps4);

        Console One = new Console("MicroSoft", "XBox One", "Europe");
        DBHelper.save(One);


        Game BioShockInfinite = new Game("BioShock Infinite", GenreType.FPS);
        DBHelper.save(BioShockInfinite);
        Game persona5 = new Game("Persona 5", GenreType.RPG);
        DBHelper.save(persona5);
        Game Witcher3 = new Game("Witcher 3", GenreType.RPG);
        DBHelper.save(Witcher3);


        DBConsole.addGametoConsole(Witcher3, One);
        DBConsole.addGametoConsole(persona5, ps4);
        DBConsole.addGametoConsole(BioShockInfinite, One);
        DBConsole.addGametoConsole(Witcher3, ps4);

        Owner owner1 = new Owner("Roddy", BioShockInfinite);
        DBHelper.save(owner1);
        Owner owner2 = new Owner("David", BioShockInfinite);
        DBHelper.save(owner2);



        List<Console> consoles = DBGame.getAvailableOn(persona5);
        List<Game> games1 = DBConsole.getGames(One);

        List<Owner> ownerList2 = DBGame.getFavOwner(BioShockInfinite);
    }
}
