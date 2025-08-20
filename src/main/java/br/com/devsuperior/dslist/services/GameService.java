package br.com.devsuperior.dslist.services;

import br.com.devsuperior.dslist.dto.GameDTO;
import br.com.devsuperior.dslist.dto.GameMinDTO;
import br.com.devsuperior.dslist.entities.Game;
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
        return games.stream().map(game -> new GameMinDTO(game)).toList();
    }

    public GameDTO findById(Long id) {
        // fazer tratamento de exceção
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
}
