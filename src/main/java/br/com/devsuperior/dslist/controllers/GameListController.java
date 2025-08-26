package br.com.devsuperior.dslist.controllers;

import br.com.devsuperior.dslist.dto.GameListDTO;
import br.com.devsuperior.dslist.dto.GameMinDTO;
import br.com.devsuperior.dslist.dto.ReplacementDTO;
import br.com.devsuperior.dslist.services.GameListService;
import br.com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

@Autowired
private GameListService gameListService;

@Autowired
private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAllLists() {
        return gameListService.findAllLists();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findAllGamesByIdList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping("/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO replacementDTO) {
        gameListService.move(listId, replacementDTO.getSourceIndex(), replacementDTO.getDestinationIndex());
    }
}
