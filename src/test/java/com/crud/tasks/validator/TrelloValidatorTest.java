package com.crud.tasks.validator;
import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloValidatorTest {
    @Autowired
    TrelloValidator trelloValidator;
//    @Autowired
//    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloValidator.class);
    @Test
    public void testValidateCard(){
        //Given
        TrelloValidator trelloValidator = new TrelloValidator();
        TrelloCard trelloCard = new TrelloCard( "test", "testing lists", "top", "6");
        //When
        boolean isProperUser = trelloValidator.validateCard(trelloCard);
        //Then
        assertEquals(false, isProperUser);

    }
    @Test
    public void testValidateTrelloBoard(){
        //Given
        TrelloValidator trelloValidator = new TrelloValidator();
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("5", "anything", new ArrayList<>()));
        //When
        List<TrelloBoard> resultBoard = trelloValidator.validateTrelloBoard(trelloBoards);
        //Then
        assertEquals(1,resultBoard.size());
    }
}
