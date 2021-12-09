package com.model;
import com.validations.MatchValidation;

import javax.persistence.*;

@Entity
@Table(name = "MatchScheduling")
@MatchValidation(message = "team1 or team2 can't be same")
public class MatchModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matchid", nullable = false)


     private int matchid;
     private String  schedule_date;
    private String venue;
    private String Team1_Description;
    private String Team2_Description;
    private String result;
    @ManyToOne
    @JoinColumn(name = "states")
    private StateModel stateModel;

     @ManyToOne
    @JoinColumn(name = "team_id1")
     private TeamModel team1;

      @ManyToOne
    @JoinColumn(name = "team_id2")
    private TeamModel team2;

    public StateModel getStateModel() {
        return stateModel;
    }

    public void setStateModel(StateModel stateModel) {
        this.stateModel = stateModel;
    }


    public TeamModel getTeam1() {
        return team1;
    }

    public void setTeam1(final TeamModel team1) {
        this.team1 = team1;
    }

    public TeamModel getTeam2() {
        return team2;
    }

    public void setTeam2(final TeamModel team2) {
        this.team2 = team2;
    }

    public String getTeam1_Description() {
        return Team1_Description;
    }

    public void setTeam1_Description(String team1_Description) {
        Team1_Description = team1_Description;
    }

    public String getTeam2_Description() {
        return Team2_Description;
    }

    public void setTeam2_Description(String team2_Description) {
        Team2_Description = team2_Description;
    }


    public String getSchedule_date() {
        return schedule_date;
    }

    public void setSchedule_date(String schedule_date) {
        this.schedule_date = schedule_date;
    }

    public Integer getMatchid() {
        return matchid;
    }

    public void setMatchid(int matchid) {
        this.matchid = matchid;
    }


    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
