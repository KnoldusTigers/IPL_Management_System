package com.controller;
import com.model.TeamModel;
import com.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Controller
public class TeamController {
    @Autowired
    public TeamService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {

        List<TeamModel> teamList = service.listAll();
        model.addAttribute("teamList", teamList);

     return "index";
    }

    @GetMapping(value="/addTeam")
    public String add(Model model){
        model.addAttribute("Team",new TeamModel());
        return "addTeam";
    }
    @RequestMapping( value="/save",method = RequestMethod.POST)
    public String saveTeam( @ModelAttribute("Team") TeamModel tm){
        service.save(tm);
        return "redirect:Admin";
    }
@GetMapping("/Teams")
    public String viewTeamsPage(Model model){
    List<TeamModel> teamList = service.listAll();
    model.addAttribute("teamList", teamList);
    return "Teams";
}
@GetMapping("/Admin")
public String viewTeams1(Model model){
    List<TeamModel> teamList = service.listAll();
    model.addAttribute("teamList", teamList);

    return "Admin";
}

}
