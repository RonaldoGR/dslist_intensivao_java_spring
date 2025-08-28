package br.com.devsuperior.dslist.services;


import br.com.devsuperior.dslist.entities.Game;
import br.com.devsuperior.dslist.dto.GameMinDTOFake;
import br.com.devsuperior.dslist.exceptions.GameListNotFoundException;
import br.com.devsuperior.dslist.exceptions.GameNotFounException;
import br.com.devsuperior.dslist.exceptions.NotExistGamesException;
import br.com.devsuperior.dslist.projections.GameMinProjection;
import br.com.devsuperior.dslist.repository.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class GameServiceTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private GameRepository gameRepository;

    @Test
    public void findAllWhenExists() {
        Game game1 = new Game();
        game1.setId(1L);
        game1.setTitle("The Legend of Mock");
        game1.setYear(2023);
        game1.setGenre("Adventure");
        game1.setPlatforms("PC, PS5");
        game1.setScore(9.2);
        game1.setImgUrl("https://example.com/game1.jpg");
        game1.setShortDescription("Uma aventura épica de teste.");
        game1.setLongDescription("Uma descrição longa detalhando toda a história, mecânicas e ambiente do jogo de teste.");

        Game game2 = new Game();
        game2.setId(2L);
        game2.setTitle("Mock Racer");
        game2.setYear(2022);
        game2.setGenre("Racing");
        game2.setPlatforms("PC, Xbox Series X");
        game2.setScore(8.5);
        game2.setImgUrl("https://example.com/game2.jpg");
        game2.setShortDescription("Corridas intensas e divertidas de teste.");
        game2.setLongDescription("Uma descrição longa detalhando os modos de corrida, carros, pistas e funcionalidades do jogo de teste.");

        List<Game> games = Arrays.asList(game1, game2);
        when(gameRepository.findAll()).thenReturn(games);
    }

    @Test
    public void findAllWhenNotExists() {
        when(gameRepository.findAll()).thenThrow(new NotExistGamesException("There are no games found"));
        NotExistGamesException ex = assertThrows(NotExistGamesException.class, () -> {
            gameRepository.findAll();
        });

        assertEquals("There are no games found", ex.getMessage());
    }

    @Test
    public void findByIdWhenExists() {
        Game game1 = new Game();
        game1.setId(1L);
        game1.setTitle("The Legend of Mock");
        game1.setYear(2023);
        game1.setGenre("Adventure");
        game1.setPlatforms("PC, PS5");
        game1.setScore(9.2);
        game1.setImgUrl("https://example.com/game1.jpg");
        game1.setShortDescription("Uma aventura épica de teste.");
        game1.setLongDescription("Uma descrição longa detalhando toda a história, mecânicas e ambiente do jogo de teste.");
        when(gameRepository.findById(1L)).thenReturn(Optional.of(game1));

    }

    @Test
    public void findByIdWhenNotExists() {
        when(gameRepository.findById(1L)).thenThrow(new GameNotFounException("There are no games found"));
        GameNotFounException ex = assertThrows(GameNotFounException.class, () -> {
            gameRepository.findById(1L);
        });
        assertEquals("There are no games found", ex.getMessage());
    }



    @Test
    public void findByListWhenExists() {

        Game game1 = new Game();
        game1.setId(1L);
        game1.setTitle("The Legend of Mock");
        game1.setYear(2023);
        game1.setGenre("Adventure");
        game1.setPlatforms("PC, PS5");
        game1.setScore(9.2);
        game1.setImgUrl("https://example.com/game1.jpg");
        game1.setShortDescription("Uma aventura épica de teste.");
        game1.setLongDescription("Uma descrição longa detalhando toda a história, mecânicas e ambiente do jogo de teste.");

        Game game2 = new Game();
        game2.setId(2L);
        game2.setTitle("Mock Racer");
        game2.setYear(2022);
        game2.setGenre("Racing");
        game2.setPlatforms("PC, Xbox Series X");
        game2.setScore(8.5);
        game2.setImgUrl("https://example.com/game2.jpg");
        game2.setShortDescription("Corridas intensas e divertidas de teste.");
        game2.setLongDescription("Uma descrição longa detalhando os modos de corrida, carros, pistas e funcionalidades do jogo de teste.");

        GameMinDTOFake gameMinDTO1 = new GameMinDTOFake(game1);
        GameMinDTOFake gameMinDTO2 = new GameMinDTOFake(game2);

        List<GameMinProjection> games = Arrays.asList(
                gameMinDTO1,
                gameMinDTO2
        );
        when(gameRepository.searchByList(1L)).thenReturn(games);

    }

    @Test
    public void findByListWhenNotExists() {
        when(gameRepository.searchByList(1L)).thenThrow(new GameListNotFoundException("No GameList found"));
        GameListNotFoundException ex = assertThrows(GameListNotFoundException.class, () -> {
            gameRepository.searchByList(1L);
        });
        assertEquals("No GameList found", ex.getMessage());
    }
}
