package com.controller;

import com.model.PointModel;
import com.model.TeamModel;
import com.service.resultservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PointControoler {
    @Autowired
    private resultservice resultservic;

    @GetMapping("/")
    public String viewHome(final Model model) {

        List<PointModel> pointlist = resultservic.getPoint();
        model.addAttribute("pointlist", pointlist);

        return "index";
    }

}
