package com.crud.tasks.mapper;


import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.*;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTest {
    @Autowired
    TrelloMapper trelloMapper;

    @Test
    public void testMappingBoards() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("7", "to do", trelloLists));

        //When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);
        List<TrelloBoard> resultBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        //Then
        assertEquals(trelloBoards.get(0).getId(), resultBoards.get(0).getId());
        assertEquals(trelloBoards.get(0).getName(), resultBoards.get(0).getName());
        assertEquals(trelloBoards.get(0).getLists(), resultBoards.get(0).getLists());
    }

    @Test
    public void testMappingList() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("5", "The list", true));
        //When
        List<TrelloListDto> trelloListsDto = trelloMapper.mapToListDto(trelloLists);
        List<TrelloList> resultLists = trelloMapper.mapToList(trelloListsDto);
        //Then
        assertEquals(trelloLists.get(0).getId(), resultLists.get(0).getId());
        assertEquals(trelloLists.get(0).getName(), resultLists.get(0).getName());
        assertEquals(trelloLists.get(0).isClosed(), resultLists.get(0).isClosed());
    }

    @Test
    public void testMappingCard() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCard trelloCard = new TrelloCard("Card1", "Sth", "top", "5");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        TrelloCard resultCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals(trelloCard.getName(), resultCard.getName());
        assertEquals(trelloCard.getDescription(), resultCard.getDescription());
        assertEquals(trelloCard.getPos(), resultCard.getPos());
        assertEquals(trelloCard.getListId(), resultCard.getListId());
    }
}


