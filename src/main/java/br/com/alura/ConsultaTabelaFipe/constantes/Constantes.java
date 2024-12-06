package br.com.alura.ConsultaTabelaFipe.constantes;

import io.github.cdimascio.dotenv.Dotenv;

public class Constantes {
    private static Dotenv dotenv = Dotenv.load();
    //public static final String CODIGO_API_KEY = dotenv.get("API_KEY");
    public static final String ENDERECO_API = "https://parallelum.com.br/fipe/api/v1/";
}
