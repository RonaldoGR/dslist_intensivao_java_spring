package br.com.devsuperior.dslist.services;

import br.com.devsuperior.dslist.dto.GameDTO;
import br.com.devsuperior.dslist.dto.GameMinDTO;
import br.com.devsuperior.dslist.entities.Game;
import br.com.devsuperior.dslist.exceptions.GameListNotFoundException;
import br.com.devsuperior.dslist.exceptions.GameNotFounException;
import br.com.devsuperior.dslist.exceptions.NotExistGamesException;
import br.com.devsuperior.dslist.projections.GameMinProjection;
import br.com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        if (games.isEmpty()) throw new NotExistGamesException("There are no games found");
        return games.stream().map(game -> new GameMinDTO(game)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFounException("Game not found"));
        return new GameDTO(result);

    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> gamesList = gameRepository.searchByList(listId);
        if (gamesList.isEmpty()) throw new GameListNotFoundException("No GameList found");
        return gamesList.stream().map(projection -> new GameMinDTO(projection)).toList();
    }
}
