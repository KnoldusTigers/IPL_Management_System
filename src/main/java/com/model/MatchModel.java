package com.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="MatchScheduling")
public class MatchModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer matchid;
    private String schedule_date;
    private String venue;
    private String Team1_Description;


    @ManyToOne
    @JoinColumn(name = "team_id1")
    private TeamModel team1;

    @ManyToOne
    @JoinColumn(name = "team_id2")
    private TeamModel team2;

    public TeamModel getTeam1() {
        return team1;
    }

    public void setTeam1(TeamModel team1) {
        this.team1 = team1;
    }

    public TeamModel getTeam2() {
        return team2;
    }

    public void setTeam2(TeamModel team2) {
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

    private String Team2_Description;

    public String getSchedule_date() {
        return schedule_date;
    }

    public void setSchedule_date(String schedule_date) {
        this.schedule_date = schedule_date;
    }




    public Integer getMatchid() {
        return matchid;
    }

    public void setMatchid(Integer matchid) {
        this.matchid = matchid;
    }



//    public String getMatchid() {
//        return matchid;
//    }
//
//    public void setMatchid(String matchid) {
//        this.matchid = matchid;
//    }


    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }


}
