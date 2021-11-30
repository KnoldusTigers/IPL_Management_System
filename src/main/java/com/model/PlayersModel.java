package com.model;
import javax.persistence.*;

@Entity(name = "players")
@Table(name="players")
public class PlayersModel  {
    @Id
    @Column(name = "id", nullable = false )


    private int id;
     private String player_name;
     private String player_team;
    private String player_role;
    private int run;
    private int wickets;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamModel team;

    public TeamModel getTeam() {
        return team;
    }

    public void setTeam(TeamModel team) {
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_team() {
        return player_team;
    }

    public void setPlayer_team(String player_team) {
        this.player_team = player_team;
    }

    public String getPlayer_role() {
        return player_role;
    }

    public void setPlayer_role(String player_role) {
        this.player_role = player_role;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }
}
