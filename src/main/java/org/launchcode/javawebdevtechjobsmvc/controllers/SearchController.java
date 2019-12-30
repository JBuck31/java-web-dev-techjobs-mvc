package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.Job;
import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.columnChoices;
import static org.launchcode.javawebdevtechjobsmvc.models.JobData.findAll;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
//   ANY AND ALL OF THIS CAN BE CHANGED! Go back and read/re-watch the chapter!
    @RequestMapping(value = "results")
    public String displaySearchResults(@RequestParam String searchType, @RequestParam String searchTerm, Model model) {
        ArrayList<Job> jobs;
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchTerm", searchTerm);

        if (searchTerm.toLowerCase().equals("all")) {
            jobs = JobData.findAll();
            model.addAttribute("title", "All Jobs");
            }
        return "search";
    }

}
