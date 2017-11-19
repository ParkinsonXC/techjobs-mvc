package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value="results")
    public String results(Model model, @RequestParam String searchType, @RequestParam String searchTerm){

        ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        Integer resultSize = jobs.size();//Results found header
        String results =resultSize.toString() + " result(s) found"; //Results found header
        String newSearch = searchTerm; //Used to save the search field

        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("jobs", jobs);
        model.addAttribute("results", results);
        model.addAttribute("newSearch", newSearch);

        return "search";
    }

}
