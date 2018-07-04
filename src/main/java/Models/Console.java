package Models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "consoles")
public class Console {

    private int id;
    private String manufacturer;
    private String model;
    private String region;
    private List<Game> games;

    public Console() {
    }

    public Console(String manufacturer, String model, String region) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.region = region;
        this.games = new ArrayList<Game>();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "Games_Consoles",
            joinColumns = {@JoinColumn(name = "console_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "game_id", nullable = false, updatable = false)})
    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void addGame(Game game){
        this.games.add(game);
    }
}
