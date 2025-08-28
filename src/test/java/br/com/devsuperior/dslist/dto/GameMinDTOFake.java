package br.com.devsuperior.dslist.dto;

import br.com.devsuperior.dslist.entities.Game;
import br.com.devsuperior.dslist.projections.GameMinProjection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameMinDTOFake extends GameMinDTO implements GameMinProjection {

    public GameMinDTOFake(Game game) {
        super(game);
    }

    @Override
    public Integer getGameYear() {
        return super.getYear();
    }
}
