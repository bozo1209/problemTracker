package com.bozo.problemtracker.controllers;

import com.bozo.problemtracker.forms.NoteForm;
import com.bozo.problemtracker.services.MarketService;
import com.bozo.problemtracker.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private NoteService noteService;
    private MarketService marketService;

    @Autowired
    public HomeController(NoteService noteService, MarketService marketService){
        this.noteService = noteService;
        this.marketService = marketService;
    }

    @GetMapping(path = "/")
    public String getHome(Model model){
        model.addAttribute("NoteForm", new NoteForm());
        model.addAttribute("noteList", noteService.getNotesForPresentationByUserId(1));
        model.addAttribute("marketNameList", marketService.getMarketNames());
        return "home.html";
    }

//    @PostMapping(path = "/addnote")
//    public void addNote(
//            @RequestParam("market") String market,
//            @RequestParam("outsideNumber") String outsideNumber,
//            @RequestParam("description") String description,
//            @RequestParam("status") String status,
//            @RequestParam("year") int year,
//            @RequestParam("month") int month,
//            @RequestParam("day") int day,
//            @RequestParam("users") String users,
//            Model model
//    ){
////        noteService.addNote(note);
//    }

}
