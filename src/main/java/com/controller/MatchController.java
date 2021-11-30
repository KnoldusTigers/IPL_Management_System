package com.controller;


import com.model.MatchModel;

import com.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MatchController {
    @Autowired
    MatchService matchService;


    @GetMapping(value="/viewMatch")
    public String viewMatch(Model model){
        List<MatchModel> matchModelsList=matchService.getAllMatches();
        model.addAttribute("matchModelsList",matchModelsList);
        return "viewMatch";
    }

    @GetMapping(value="/matchSchedule")
    public String addMatch(Model model){
        model.addAttribute("match",new MatchModel());
        return "matchSchedule";
    }
    @RequestMapping(value="/SaveMatch",method = RequestMethod.POST)
    public String saveMatch(@ModelAttribute("matches") MatchModel match){
        matchService.save(match);
        return "redirect:viewMatch";
    }


}

