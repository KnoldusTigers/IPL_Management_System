package com.service;

import com.dao.PointRepo;
import com.model.MatchModel;
import com.model.PointModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class resultservice {
@Autowired
private PointRepo pointRepo;


public MatchModel getResult(MatchModel matchModel){
    PointModel pointModel1=new PointModel();
    PointModel pointModel2=new PointModel();
    pointModel1.setPoint(0);
    pointModel1.setWinCount(0);
    pointModel1.setLossCount(0);
    pointModel1.setMatchCount(0);
    pointModel1.setTeam(matchModel.getTeam1());
    //
    pointModel2.setPoint(0);
    pointModel2.setWinCount(0);
    pointModel2.setLossCount(0);
    pointModel2.setMatchCount(0);
    pointModel2.setTeam(matchModel.getTeam2());
    String team1[]=matchModel.getTeam1_Description().split("/");
    int team1Score= Integer.parseInt(team1[0]);
    int wicket1= Integer.parseInt(team1[1]);
    String team2[]=matchModel.getTeam2_Description().split("/");
    int team2Score= Integer.parseInt(team2[0]);
    int wicket2= Integer.parseInt(team2[1]);
    System.out.println("===============--------------------------------------==============="+pointModel1.getMatchCount()+" "+pointModel2.getMatchCount());



    if(team1Score>team2Score){
        matchModel.setResult(matchModel.getTeam1().getTeam_name()+" won by "+(team1Score-team2Score)+ " Runs");
        pointModel1.setWinCount(pointModel1.getWinCount()+1);
        pointModel2.setLossCount(pointModel2.getLossCount()+1);
        pointModel1.setPoint(pointModel1.getPoint()+2);
        pointModel1.setMatchCount(pointModel1.getMatchCount()+1);


        System.out.println("===============--------------------------------------==============="+ matchModel.getResult());
    }

    else if(team2Score>team1Score){
        matchModel.setResult(matchModel.getTeam2().getTeam_name() + " won by " + (11 - wicket2)+ " wickets");

        pointModel2.setWinCount(pointModel2.getWinCount()+1);
        pointModel1.setLossCount(pointModel1.getLossCount()+1);
        pointModel2.setPoint(pointModel2.getPoint()+2);
        pointModel2.setMatchCount(pointModel2.getMatchCount()+1);

        System.out.println("===============-------------===========-------------------------==============="+ matchModel.getResult());
    }
    System.out.println(matchModel.getResult()+"----------------------------------------------------------------=========================================");
    pointRepo.save(pointModel1);
    pointRepo.save(pointModel2);

    return matchModel;
}


}
