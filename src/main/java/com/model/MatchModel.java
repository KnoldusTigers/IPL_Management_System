package com.model;
import com.validations.MatchValidation;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "MatchScheduling")
@MatchValidation
 public class MatchModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matchid", nullable = false)


     private int matchid;
     private String  schedule_date;
    private String venue;
    private String Team1_Description;
    private String Team2_Description;

    @Column(name = "team1_wickets", nullable = true)
    private String Team1_Wickets;

    @Column(name = "team2_wickets", nullable = true)
     private String Team2_Wickets;
    @Column(name = "team1_overs", nullable = true)
    private String Team1_Overs;
    @Column(name = "team2_overs", nullable = true)

     private String Team2_Overs;


    private String result;

    public String getTeam2_Description() {
        return Team2_Description;
    }

    public void setTeam2_Description(String team2_Description) {
        Team2_Description = team2_Description;
    }

    public String getTeam1_Wickets() {
        return Team1_Wickets;
    }

    public void setTeam1_Wickets(String team1_Wickets) {
        Team1_Wickets = team1_Wickets;
    }

    public String getTeam2_Wickets() {
        return Team2_Wickets;
    }

    public void setTeam2_Wickets(String team2_Wickets) {
        Team2_Wickets = team2_Wickets;
    }

    public String getTeam1_Overs() {
        return Team1_Overs;
    }

    public void setTeam1_Overs(String team1_Overs) {
        Team1_Overs = team1_Overs;
    }

    public String getTeam2_Overs() {
        return Team2_Overs;
    }

    public void setTeam2_Overs(String team2_Overs) {
        Team2_Overs = team2_Overs;
    }

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

    public String getTeam1_Description() {
        return Team1_Description;
    }

    public void setTeam1_Description(String team1_Description) {
        Team1_Description = team1_Description;
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
