package Models;


import javax.persistence.*;

@Entity
@Table(name = "owners")
public class Owner {

    private int id;
    private String name;
    private Game favGame;

    public Owner() {
    }

    public Owner(String name, Game favGame) {
        this.name = name;
        this.favGame = favGame;
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ManyToOne
    @JoinColumn(name = "favGame_id", nullable = false)
    public Game getFavGame() {
        return favGame;
    }

    public void setFavGame(Game favGame) {
        this.favGame = favGame;
    }
}
