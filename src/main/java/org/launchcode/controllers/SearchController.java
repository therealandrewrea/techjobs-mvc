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

    // TODO #1 - Create handler to process search request and display results //
    @RequestMapping(value = "")
    public String search (Model model, @RequestParam String column  , @RequestParam String searchTerm) {
        model.addAttribute("columns", ListController.columnChoices);

        // finds the data using existing method and loads it into an arraylist of hashmaps called "jobs" //
        // ListController as reference //

        ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(column, searchTerm);
        model.addAttribute("column", column);
        model.addAttribute("jobs", jobs);
        return  "search";
        // this should return our query based on the searchTerm, right? //
    }

}
