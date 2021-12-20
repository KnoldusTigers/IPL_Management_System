
package com.controller;
import com.model.TeamModel;
import com.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


/**
 * The type Team controller.
 */
@Controller
public class TeamController {
    /**
     * Autowired TeamService service
     */
    @Autowired
    private TeamService service;
    /**
     * Add string.
     *
     * @param model the model
     * @return the string
     */
//open add team page
    @GetMapping("/addTeam")
    public String add(final Model model) {
        model.addAttribute("Team", new TeamModel());
        return "addTeam";
    }

    /**
     * Save team string.
     *
     * @param teamObj     the tm
     * @param result the result
     * @return the string
     */
//check validations and save team in database
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTeam(@Valid @ModelAttribute("Team") final TeamModel teamObj, final BindingResult result) {
        if (service.teamNameExists(teamObj.getTeamname())) {
            result.addError(new FieldError("pm", "teamname", "name already exists"));
        }
        if (result.hasErrors()) {
            return "addTeam";
        } else {
            service.save(teamObj);
            return "redirect:Admin";
        }
    }

    /**
     * View teams page string.
     *
     * @param model the model
     * @return the string
     */
//return/show Teams page
    @GetMapping("/Teams")
    public String viewTeamsPage(final Model model) {

            final List<TeamModel> teamList = service.listAll();
            model.addAttribute("teamList", teamList);
            return "Teams";
    }

    /**
     * View teams 1 string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/Admin")
    public String viewTeams1(final Model model) {
        final List<TeamModel> teamList = service.listAll();
        model.addAttribute("teamList", teamList);

        return "Admin";
    }

}
