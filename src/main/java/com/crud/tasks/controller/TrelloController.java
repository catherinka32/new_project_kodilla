package com.crud.tasks.controller;



import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloFacade trelloFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/fetchTrelloBoards")

    public  List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloFacade.fetchTrelloBoards();
    }
    @RequestMapping(method =RequestMethod.POST, value = "/createTrelloCard")

    public CreatedTrelloCardDto createTrelloCard(@RequestBody TrelloCardDto trelloCardDto){
        return trelloFacade.createCard(trelloCardDto);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
//
//    public  List<TrelloBoardDto> getTrelloBoards() {
//        return trelloService.fetchTrelloBoards();
//    }
//    @RequestMapping(method =RequestMethod.POST, value = "createTrelloCard")
//
//    public CreatedTrelloCardDto createTrelloCard(@RequestBody TrelloCardDto trelloCardDto){
//        return trelloService.createTrelloCard(trelloCardDto);
//    }
}