package br.com.devsuperior.dslist.services;

import br.com.devsuperior.dslist.dto.GameListDTO;
import br.com.devsuperior.dslist.entities.GameList;
import br.com.devsuperior.dslist.exceptions.GameListNotFoundException;
import br.com.devsuperior.dslist.projections.GameMinProjection;
import br.com.devsuperior.dslist.repository.GameListRepository;
import br.com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAllLists() {
        List<GameList> list = gameListRepository.findAll();
        if (list.isEmpty()) {
            throw new GameListNotFoundException("No GameList found");
        }
        return list.stream().map(game -> new GameListDTO(game)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection game = list.remove(sourceIndex);
        list.add(destinationIndex, game);

        int minIndex = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int maxIndex = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;

        for (int i = minIndex; i <= maxIndex; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }


    }



}
