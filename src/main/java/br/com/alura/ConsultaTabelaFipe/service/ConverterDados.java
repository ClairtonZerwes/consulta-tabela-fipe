package br.com.alura.ConsultaTabelaFipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConverterDados implements IConverterDados{

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            //System.out.println("ERRO obterDados(): " + e.getOriginalMessage());
            //System.out.println("ERRO obterDados(): " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> obterLista(String json, Class<T> classe) {
        CollectionType listaVeiculos = mapper.getTypeFactory().constructCollectionType(List.class, classe);

        try {
            return mapper.readValue(json, listaVeiculos);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
