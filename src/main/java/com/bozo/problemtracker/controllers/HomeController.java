package com.bozo.problemtracker.controllers;

import com.bozo.problemtracker.enums.NoteStatus;
import com.bozo.problemtracker.forms.NoteForm;
import com.bozo.problemtracker.services.MarketService;
import com.bozo.problemtracker.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    private NoteService noteService;
    private MarketService marketService;

    private List<String> statusList;

    @Autowired
    public HomeController(NoteService noteService, MarketService marketService){
        this.noteService = noteService;
        this.marketService = marketService;
        statusList = Arrays.asList(NoteStatus.OPEN.name(), NoteStatus.READY.name(), NoteStatus.CLOSED.name(), NoteStatus.REOPEN.name());
    }

    @GetMapping(path = "/")
    public String getHome(Model model){
        model.addAttribute("NoteForm", new NoteForm());
        model.addAttribute("noteList", noteService.getNotesForPresentationByUserId(1));
        model.addAttribute("marketNameList", marketService.getMarketNames());
        model.addAttribute("statusList", statusList);
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
