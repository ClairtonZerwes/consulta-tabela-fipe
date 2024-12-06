package br.com.alura.ConsultaTabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VeiculosDetalhes(@JsonAlias("TipoVeiculo") Integer tipoVeiculo,
                               @JsonAlias("Valor") String valorFipe,
                               @JsonAlias("Marca") String marcaVeiculo,
                               @JsonAlias("Modelo") String modeloVeiculo,
                               @JsonAlias("AnoModelo") Integer anoModelo,
                               @JsonAlias("Combustivel") String tipoCombustivel,
                               @JsonAlias("CodigoFipe") String codigoFipe,
                               @JsonAlias("MesReferencia") String mesRefenciaValorFipe
) {
}
