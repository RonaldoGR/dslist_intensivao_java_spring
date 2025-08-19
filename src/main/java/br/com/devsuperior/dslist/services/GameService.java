package br.com.devsuperior.dslist.services;

import br.com.devsuperior.dslist.dto.GameMinDTO;
import br.com.devsuperior.dslist.entities.Game;
import br.com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        return games.stream().map(game -> new GameMinDTO(game)).toList();
    }
}
