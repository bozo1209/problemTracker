package com.bozo.problemtracker.controllers;

import com.bozo.problemtracker.forms.NoteForm;
import com.bozo.problemtracker.models.NotePresentation;
import com.bozo.problemtracker.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class HomeRestController {

    private HomeService homeService;
    private MarketService marketService;
    private MarketGroupService marketGroupService;
    private NoteService noteService;
    private UsersService usersService;

    @Autowired
    public HomeRestController(HomeService homeService, MarketService marketService, MarketGroupService marketGroupService, NoteService noteService, UsersService usersService) {
        this.homeService = homeService;
        this.marketService = marketService;
        this.marketGroupService = marketGroupService;
        this.noteService = noteService;
        this.usersService = usersService;
    }

    @GetMapping(path = "/marketgroup")
    public String getMarketGroupNameById(@RequestParam long id){
//        System.out.println(id);
        return marketGroupService.findNameById(id);
    }

    @GetMapping(path = "/marketgroup/{id}")
    public String getMarketGroupNameById2(@PathVariable long id){
        return marketGroupService.findNameById(id);
    }

    @GetMapping(path = "/market")
    public List<String> marketGroupNameFromMarket(){
        return marketService.marketGroupNamesFromMarket();
    }

    @GetMapping(path = "/market2")
    public String marketGroupNameFromMarketByMarketGroupId(@RequestParam long id){
        return marketService.marketGroupNameFromMarketByMarketGroupId(id);
    }

    @GetMapping(path = "/notes")
    public List<NotePresentation> getNotesPresentation(){
        return noteService.getNotesPresentation();
    }

    @GetMapping(path = "/notesbyuser")
    public List<NotePresentation> getNotesForPresentationByUserId(@RequestParam long id){
        return noteService.getNotesForPresentationByUserId(id);
    }

    @PostMapping(path = "/addnote")
    public RedirectView addNote(
            @RequestParam("market") String market,
            @RequestParam("outsideNumber") String outsideNumber,
            @RequestParam("description") String description,
            @RequestParam("status") String status,
            @RequestParam("year") int year,
            @RequestParam("month") int month,
            @RequestParam("day") int day,
            @RequestParam("users") String users,
            Model model
//            @RequestParam("NoteForm") NoteForm noteForm
            ){
//        noteService.addNote(note);
        System.out.println("tutaj");
        NoteForm noteForm = new NoteForm();
        noteForm.setMarket(market);
        noteForm.setOutsideNumber(outsideNumber);
        noteForm.setDescription(description);
        noteForm.setStatus(status);
        noteForm.setYear(year);
        noteForm.setMonth(month);
        noteForm.setDay(day);

        noteService.addNote(noteForm);

//        return "redirect:/home";
        System.out.println("redirect");
        return new RedirectView("/");
    }

    @PostMapping(path = "/editnote")
//    public RedirectView editNote(
    public void editNote(
            @RequestParam("id") long id,
            @RequestParam("market") String market,
            @RequestParam("outsideNumber") String outsideNumber,
            @RequestParam("description") String description,
            @RequestParam("status") String status,
            @RequestParam("year") int year,
            @RequestParam("month") int month,
            @RequestParam("day") int day,
            @RequestParam("users") String users
    ){
        NoteForm noteForm = new NoteForm();
        noteForm.setId(id);
        noteForm.setMarket(market);
        noteForm.setOutsideNumber(outsideNumber);
        noteForm.setDescription(description);
        noteForm.setStatus(status);
        noteForm.setYear(year);
        noteForm.setMonth(month);
        noteForm.setDay(day);

        noteService.updateNote(noteForm);

//        return new RedirectView("/");
    }

}
