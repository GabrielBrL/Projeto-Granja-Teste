package com.api.granjacontrol.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CicleDto {

    @NotBlank
    @Size(max = 100)
    private String raca;
    @NotBlank
    @Size(max = 100)
    private String peso;
    private Integer quantidade;

}
