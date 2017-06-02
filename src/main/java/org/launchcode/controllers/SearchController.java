package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    @RequestMapping(value = "results")
    public String search (Model model, @RequestParam String searchType , @RequestParam String searchTerm) {
        model.addAttribute("columns", ListController.columnChoices);

        // finds the data using existing method and loads it into an arraylist of hashmaps called "jobs" //
        // ListController as reference //

        ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        model.addAttribute("jobs", jobs);
        return  "search";
    }

}
