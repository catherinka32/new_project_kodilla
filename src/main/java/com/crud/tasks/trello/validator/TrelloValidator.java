package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;
@Component
public class TrelloValidator {
    Logger LOGGER = LoggerFactory.getLogger(TrelloValidator.class);

    public boolean validateCard(final TrelloCard trelloCard) {
        if (trelloCard.getName().contains("test")) {
            LOGGER.info("Someone is testing my application");
            return false;
        } else {
            LOGGER.info("Seems that my application is used in proper way");
            return true;
        }
    }
    public List<TrelloBoard> validateTrelloBoard(final List<TrelloBoard> trelloBoards) {
        LOGGER.info("Starting filtering boards...");
        List<TrelloBoard> filteredBoards = trelloBoards.stream()
                .filter(trelloBoard -> !trelloBoard.getName().equalsIgnoreCase("test"))
                .collect(toList());
        LOGGER.info("Boards has been filtered. Current list size:" + filteredBoards.size());
        return filteredBoards;
    }
}