package com.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="team")
 public class TeamModel {
    @Id
    @Column(name = "id", nullable = false )



    private  String id;
    public String team_name;
    public String state;

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

    public String captain;



    @OneToMany(mappedBy = "team")
    List<PlayersModel> playersModel;


    public String getId() {

        return id;
    }

    public TeamModel(  String team_name, List<PlayersModel> playersModel) {

        this.team_name = team_name;
        this.playersModel = playersModel;
    }
public TeamModel(){

}
    public void setId(String id) {
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
}
