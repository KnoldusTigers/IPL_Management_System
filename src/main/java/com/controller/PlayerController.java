package com.controller;


import com.dao.PlayerRepo;
import com.model.PlayersModel;
import com.model.TeamModel;

import com.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.stream.Collectors;


@Controller
public class PlayerController {
    @Autowired
    private PlayerService playerservice;

//    @GetMapping("/")
//    public String viewHomePage(Model model) {
//
//        List<PlayersModel> playerList = playerservice.listAll();
//        model.addAttribute("playerList", playerList);
//
//        return "index";
//    }
//@GetMapping(value="/addPlayers")
//public String add(Model model){
//    model.addAttribute("Player",new PlayersModel());
//    return "addPlayers";
//}
//
@GetMapping(value="/addPlayers")
public String add(Model model){
    model.addAttribute("Player",new PlayersModel());
    return "addPlayers";
}
    @RequestMapping(value="/Save",method = RequestMethod.POST)
    public String savePlayer(@ModelAttribute("Player") PlayersModel pm){
        playerservice.save(pm);
        return "redirect:/";
    }

    @Autowired
    PlayerRepo playerRepo;
@GetMapping(value ="/showPlayers/{team_id}")
public String viewTeams(@PathVariable String team_id, Model model){
    List<PlayersModel> playerList =   playerRepo.findByTeamId(team_id);
    model.addAttribute("playerList",  playerList);

    return "showPlayers";
}
    @GetMapping(value ="/showPlayers")
    public String getAllPlayers( Model model){
        List<PlayersModel> playerList = (List<PlayersModel>) playerRepo.findAll();
        model.addAttribute("playerList",  playerList);

        return "showPlayers";
    }
    @GetMapping(value ="/editPlayers")
    public String getAllPlayersForEdit( Model model){
        List<PlayersModel> playerList = (List<PlayersModel>) playerRepo.findAll();
        model.addAttribute("playerList",  playerList);

        return "editPlayers";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPllayer(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("addPlayers");
        PlayersModel playModel = playerservice.get(String.valueOf(id));
        modelAndView.addObject("Player", playModel);
        return modelAndView;
    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        playerservice.delete(id);
        return "redirect:/editPlayers";
    }
}


