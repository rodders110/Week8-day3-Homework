package Models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {

    private int id;
    private String title;
    private GenreType genre;
    private List<Console> consoleList;
    private List<Owner> ownerList;



    public Game() {
    }

    public Game(String title, GenreType genre) {
        this.title = title;
        this.genre = genre;
        this.consoleList = new ArrayList<Console>();

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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Enumerated(value = EnumType.STRING)
    public GenreType getGenre() {
        return genre;
    }

    public void setGenre(GenreType genre) {
        this.genre = genre;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "Games_Consoles",
            joinColumns = {@JoinColumn(name = "game_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "console_id", nullable = false, updatable = false)})
    public List<Console> getConsoleList() {
        return consoleList;
    }

    public void setConsoleList(List<Console> consoleList) {
        this.consoleList = consoleList;
    }

    @OneToMany(mappedBy = "favGame", fetch = FetchType.LAZY)
    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    public void addConsole(Console console){
        this.consoleList.add(console);
    }


}
