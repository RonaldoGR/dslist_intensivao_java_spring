package br.com.devsuperior.dslist.services;

import br.com.devsuperior.dslist.dto.GameListDTO;
import br.com.devsuperior.dslist.entities.GameList;
import br.com.devsuperior.dslist.exceptions.GameListNotFoundException;
import br.com.devsuperior.dslist.repository.GameListRepository;
import br.com.devsuperior.dslist.repository.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


public class GameListServiceTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private GameListRepository gameListRepository;

    @Mock
    private GameRepository gameRepository;

    @Test
    public void findAllListsWhenExists() {
        List<GameList> gameLists = Arrays.asList(new GameList(1L,"Aventura"),new GameList(2L, "RPG"));
        when(gameListRepository.findAll()).thenReturn(gameLists);

    }

    @Test
    public void findAllListsWhenNotExists() {
        when(gameListRepository.findAll()).thenThrow(new GameListNotFoundException("No GameList found"));
        GameListNotFoundException ex = assertThrows(GameListNotFoundException.class, () -> {
            gameListRepository.findAll();
        });

        assertEquals("No GameList found", ex.getMessage());

    }



    }
