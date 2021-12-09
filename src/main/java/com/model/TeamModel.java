package com.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "team")
 public class TeamModel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
   private String team_name;
    private String state;
    private String captain;

@OneToMany(mappedBy = "team1", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<MatchModel> addteam1;

    @OneToMany(mappedBy = "team2", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MatchModel> addteam2;

    @OneToMany(mappedBy = "team")
    List<PlayersModel> playersModel;

    @OneToMany(mappedBy = "team")
    List<PointModel> pointModels;


    public List<PointModel> getPointModels() {
        return pointModels;
    }

    public void setPointModels(List<PointModel> pointModels) {
        this.pointModels = pointModels;
    }

    public Long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public List<PlayersModel> getPlayersModel() {
        return playersModel;
    }

    public void setPlayersModel(List<PlayersModel> playersModel) {
        this.playersModel = playersModel;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }



    //constructer
    public TeamModel(String team_name, Set<MatchModel> addteam2, List<PlayersModel> playersModel) {

        this.team_name = team_name;
        this.addteam2 = addteam2;
        this.playersModel = playersModel;
    }
    public TeamModel() {

    }
}
