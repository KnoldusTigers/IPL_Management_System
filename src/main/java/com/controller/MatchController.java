package com.controller;



import com.model.MatchModel;
import com.model.StateModel;
import com.model.TeamModel;
import com.service.MatchService;
import com.service.StateService;
import com.service.TeamService;
import com.service.resultservice;
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
private resultservice reservice;
    @Autowired
    private MatchService matchService;
@Autowired
private TeamService teamService;
@Autowired
private StateService stateService;
    @GetMapping(value = "/viewMatch")
    public String viewMatch(final Model model) {
        List<MatchModel> matchModelsList = matchService.getAllMatches();
        model.addAttribute("matchModelsList", matchModelsList);
        List<StateModel> stateList = stateService.listAllStates();
        model.addAttribute("stateList", stateList);
        return "viewMatch";
    }

    //return match scheduling page
    @GetMapping(value = "/matchSchedule")
    public String addMatch(final Model model) {
        model.addAttribute("match", new MatchModel());
        List<TeamModel> teamList = teamService.listAll();
        model.addAttribute("teamList", teamList);
        List<StateModel> stateList = stateService.listAllStates();
        model.addAttribute("stateList", stateList);
        return "matchSchedule";
    }

    //Save a scheduled match and return veiw match page
    @RequestMapping(value = "/SaveMatch", method = RequestMethod.POST)
    public String saveMatch(@Valid @ModelAttribute("match") MatchModel match, final BindingResult result) {
//System.out.println(match.getTeam1_Description());
        if (result.hasErrors()) {
            return "redirect:matchSchedule";}
        else {
            //match=reservice.getResult(match);
            // System.out.println(match.getResult()+"==========================================================");

            matchService.save(match);
            return "redirect:viewMatch";
        }
        }

    @RequestMapping(value = "/SaveScore", method = RequestMethod.POST)
    public String updatescore(@Valid @ModelAttribute("match") MatchModel match, final BindingResult result) {
if(result.hasErrors()){

}
         match=reservice.getResult(match);
            matchService.save(match);
            return "redirect:EditListScore";
        }

    //
    @GetMapping(value = "/UpdateScore")
    public String viewScore(final Model model) {
        List<MatchModel> matchModelsList = matchService.getAllMatches();
        model.addAttribute("matchModelsList", matchModelsList);
        return "UpdateScore";
    }

// edit score List
    @GetMapping(value = "/EditListScore")
    public String editScore(final Model model) {
        List<MatchModel> matchModelsList = matchService.getAllMatches();
        model.addAttribute("matchModelsList", matchModelsList);

        return "EditListScore";
    }
    @RequestMapping("/editScore/{matchid}")
    public ModelAndView showEditScore(@PathVariable(name = "matchid") final String id) {
        ModelAndView modelAndView = new ModelAndView("UpdateScore");
        MatchModel matchModel = matchService.get(Integer.parseInt((id)));
        modelAndView.addObject("match", matchModel);

        List<TeamModel> teamList = teamService.listAll();
        modelAndView.addObject("teamList", teamList);

        return modelAndView;
    }

//edit a match
    @RequestMapping("/editmatch/{matchid}")
    public ModelAndView showEditPllayer(@PathVariable(name = "matchid") final String id) {
        ModelAndView modelAndView = new ModelAndView("updateMatch");
        MatchModel matchModel = matchService.get(Integer.parseInt((id)));
        modelAndView.addObject("match", matchModel);

        List<TeamModel> teamList = teamService.listAll();
        modelAndView.addObject("teamList", teamList);
        List<StateModel> stateList = stateService.listAllStates();
        modelAndView.addObject("stateList", stateList);

        return modelAndView;
    }

    //delete a match
    @RequestMapping("/deletematch/{matchid}")
    public String deletestudent(@PathVariable(name = "matchid") final String id) {
        matchService.delete(Integer.parseInt(id));
        return "redirect:/editMatch";
    }
    //show result
    @GetMapping(value = "/result")
    public String viewMatchResult(final Model model) {
        List<MatchModel> matchModelsList = matchService.getAllMatches();
        model.addAttribute("matchModelsList", matchModelsList);
        return "result";
    }
    //edit a match page
    @GetMapping(value = "/editMatch")
    public String editMatch(final Model model) {
        List<MatchModel> matchModelsList = matchService.getAllMatches();
        model.addAttribute("matchModelsList", matchModelsList);
        List<TeamModel> teamList = teamService.listAll();
        model.addAttribute("teamList", teamList);
        List<StateModel> stateList = stateService.listAllStates();
        model.addAttribute("stateList", stateList);
        return "editMatch";
    }


}

