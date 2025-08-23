package br.com.devsuperior.dslist.services;

import br.com.devsuperior.dslist.dto.GameListDTO;
import br.com.devsuperior.dslist.entities.GameList;
import br.com.devsuperior.dslist.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAllLists() {
        List<GameList> list = gameListRepository.findAll();
        return list.stream().map(game -> new GameListDTO(game)).toList();
    }



}
