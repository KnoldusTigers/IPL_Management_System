package com.controller;



import com.model.MatchModel;

 import com.model.TeamModel;
import com.service.MatchService;
import com.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MatchController {
    @Autowired
    MatchService matchService;
@Autowired
TeamService teamService;

    @GetMapping(value="/viewMatch")
    public String viewMatch(Model model){
        List<MatchModel> matchModelsList=matchService.getAllMatches();
        model.addAttribute("matchModelsList",matchModelsList);
        return "viewMatch";
    }

    //return match scheduling page
    @GetMapping(value="/matchSchedule")
    public String addMatch(Model model){
        model.addAttribute( "match",new MatchModel());
        List<TeamModel> teamList= teamService.listAll();
        model.addAttribute("teamList",teamList);

        return "matchSchedule";
    }

    //Save a scheduled match and return veiw match page
    @RequestMapping(value="/SaveMatch",method = RequestMethod.POST)
    public String saveMatch(@Valid @ModelAttribute("match") MatchModel match, BindingResult result) {

        if (result.hasErrors()) {
            return "matchSchedule";
        }
        else {
            matchService.save(match);
            return "redirect:viewMatch";
        }
    }

//edit a match
    @RequestMapping("/editmatch/{matchid}")
    public ModelAndView showEditPllayer(@PathVariable(name = "matchid") String id) {
        ModelAndView modelAndView = new ModelAndView("updateMatch");
        MatchModel matchModel = matchService.get(String.valueOf(id));
        modelAndView.addObject("match", matchModel);
        return modelAndView;
    }

    //delete a match
    @RequestMapping("/deletematch/{matchid}")
    public String deletestudent(@PathVariable(name = "matchid") String id) {
        matchService.delete(id);
        return "redirect:/viewMatch";
    }
    @GetMapping(value="/result")
    public String viewMatchResult(Model model){
        List<MatchModel> matchModelsList=matchService.getAllMatches();
        model.addAttribute("matchModelsList",matchModelsList);
        return "result";
    }
    @GetMapping(value="/editMatch")
    public String editMatch(Model model){
        List<MatchModel> matchModelsList=matchService.getAllMatches();
        model.addAttribute("matchModelsList",matchModelsList);
        List<TeamModel> teamList= teamService.listAll();
        model.addAttribute("teamList",teamList);
        return "editMatch";
    }

}

