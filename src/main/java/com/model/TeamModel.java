package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;


/**
 * The type Team model.
 */
@Entity
@Table(name = "team")
public class TeamModel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @NotNull
    @Size(min=2, max=30)
    private String teamname;
    private String state;
    private String captain;

    @OneToMany(mappedBy = "team1", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MatchModel> addteam1;

    @OneToMany(mappedBy = "team2", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MatchModel> addteam2;

    /**
     * The Players model.
     */
    @OneToMany(mappedBy = "team")
    List<PlayersModel> playersModel;

    /**
     * The Point models.
     */
    @OneToMany(mappedBy = "team")
    List<PointModel> pointModels;


    /**
     * Gets point models.
     *
     * @return the point models
     */
    public List<PointModel> getPointModels() {
        return pointModels;
    }

    /**
     * Sets point models.
     *
     * @param pointModels the point models
     */
    public void setPointModels(List<PointModel> pointModels) {
        this.pointModels = pointModels;
    }

    /**
     * Gets teamname.
     *
     * @return the teamname
     */
    public String getTeamname() {
        return teamname;
    }

    /**
     * Sets teamname.
     *
     * @param teamname the teamname
     */
    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {

        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets players model.
     *
     * @return the players model
     */
    public List<PlayersModel> getPlayersModel() {
        return playersModel;
    }

    /**
     * Sets players model.
     *
     * @param playersModel the players model
     */
    public void setPlayersModel(List<PlayersModel> playersModel) {
        this.playersModel = playersModel;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }


    /**
     * Gets captain.
     *
     * @return the captain
     */
    public String getCaptain() {
        return captain;
    }

    /**
     * Sets captain.
     *
     * @param captain the captain
     */
    public void setCaptain(String captain) {
        this.captain = captain;
    }


    /**
     * Instantiates a new Team model.
     *
     * @param teamname     the teamname
     * @param addteam2     the addteam 2
     * @param playersModel the players model
     */
//constructer
    public TeamModel(String teamname, Set<MatchModel> addteam2, List<PlayersModel> playersModel) {

        this.teamname = teamname;
        this.addteam2 = addteam2;
        this.playersModel = playersModel;
    }

    /**
     * Instantiates a new Team model.
     */
    public TeamModel() {

    }
}
