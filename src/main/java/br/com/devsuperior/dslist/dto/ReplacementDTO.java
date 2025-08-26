package br.com.devsuperior.dslist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReplacementDTO {
    private int sourceIndex;
    private int destinationIndex;


}
