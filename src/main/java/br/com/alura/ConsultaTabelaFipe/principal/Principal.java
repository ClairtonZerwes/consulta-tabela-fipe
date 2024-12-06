package br.com.alura.ConsultaTabelaFipe.principal;

import br.com.alura.ConsultaTabelaFipe.constantes.Constantes;
import br.com.alura.ConsultaTabelaFipe.model.DadosVeiculos;
import br.com.alura.ConsultaTabelaFipe.model.Modelos;
import br.com.alura.ConsultaTabelaFipe.model.VeiculosDetalhes;
import br.com.alura.ConsultaTabelaFipe.service.ConsumirDadosApi;
import br.com.alura.ConsultaTabelaFipe.service.ConverterDados;
import br.com.alura.ConsultaTabelaFipe.uteis.CodificarURL;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private static Scanner ler = new Scanner(System.in);
    private static ConsumirDadosApi consumirDadosApi = new ConsumirDadosApi();
    private ConverterDados converterDados = new ConverterDados();
    private static DateTimeFormatter formatoDataIMDB = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static DateTimeFormatter formatarDataBR = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));

    public static void main(String[] args) {

    }

        public void exiberMenu() {
            var opcaoMenu = "";
            var descricaoMenu = "";

            while (!opcaoMenu.equalsIgnoreCase("sair")) {
                descricaoMenu = """
                        
                        =====  Menu  Opções  -  Consulta  Tabela  FIPE  =====
                            Carro
                            Moto
                            Caminhão
                            Sair
                            Digite uma das opções para consultar ou (sair): 
                        =====================================================
                        """;
                System.out.print(descricaoMenu);
                opcaoMenu = ler.nextLine();
                String urlCompletaParaConsulta = Constantes.ENDERECO_API;

                if (opcaoMenu.toLowerCase().contains("car")) {
                    urlCompletaParaConsulta = urlCompletaParaConsulta + "carros/marcas";
                } else if (opcaoMenu.toLowerCase().contains("mot")) {
                    urlCompletaParaConsulta = urlCompletaParaConsulta + "motos/marcas";
                } else if (opcaoMenu.toLowerCase().contains("cam")) {
                    urlCompletaParaConsulta = urlCompletaParaConsulta + "caminhao/marcas";
                } else {
                    System.out.println("Digite sair ou outra opção do menu.");
                }
                //System.out.println(urlCompletaParaConsulta);

                var json = consumirDadosApi.obterDados(urlCompletaParaConsulta);
                // System.out.println(json);
                var marcas = converterDados.obterLista(json, DadosVeiculos.class);
                marcas.stream()
                        .sorted(Comparator.comparing(DadosVeiculos::nome))
                        //.sorted(Comparator.comparing(DadosVeiculos::codigo))
                        .forEach(System.out::println);

                System.out.println("\nDigite o código númerico da marca para consultar seus modelos de veículos: ");
                var codigoMarca = ler.nextLine();
                urlCompletaParaConsulta = urlCompletaParaConsulta + "/" + CodificarURL.codificarStringParaURL(codigoMarca) +"/modelos";
                //System.out.println(urlCompletaParaConsulta);

                var jsonMarca = consumirDadosApi.obterDados(urlCompletaParaConsulta);
                //System.out.println("JSON da Marca: " + jsonMarca);
                Modelos listaModelosVeiculosPorMarca;

                try {
                    listaModelosVeiculosPorMarca = converterDados.obterDados(jsonMarca, Modelos.class);
                    System.out.println("Lista Veículos por Marca:  " + listaModelosVeiculosPorMarca);
                } catch (NullPointerException e) {
                    //catch (JsonProcessingException e) {
                    System.out.println("ERRO converter json na lista ModelosVeiculos: " + e.getMessage());
                    return;
                }

                listaModelosVeiculosPorMarca.modelos().stream()
                        .sorted(Comparator.comparing(DadosVeiculos::nome))
                        .forEach(System.out::println);

                System.out.println("\nInforme o código do modelo do veículo para consultar anos de fabricação: ");
                var modeloVeiculo = ler.nextLine();
                //System.out.println(modeloVeiculo);
                urlCompletaParaConsulta = urlCompletaParaConsulta + "/" + CodificarURL.codificarStringParaURL(modeloVeiculo) + "/anos";
                //System.out.println("URL modelos/anos: " + urlCompletaParaConsulta);
                var jsonModelosVeiculo = consumirDadosApi.obterDados(urlCompletaParaConsulta);
                List<DadosVeiculos> anosVeiculo = converterDados.obterLista(jsonModelosVeiculo, DadosVeiculos.class);
                //System.out.println(anosVeiculo);
                List<VeiculosDetalhes> detalhesDosVeiculos = new ArrayList<>();

                //Montar json com detalhes de veículos somente com anos do modelo consultado
                String finalUrlCompletaParaConsulta = urlCompletaParaConsulta;
                List<VeiculosDetalhes> veiculosTabelaFipe = anosVeiculo.stream()
                        .map(a -> {
                            String urlAnosVeiculo = finalUrlCompletaParaConsulta + "/" + a.codigo();
                            String jsonAnos = consumirDadosApi.obterDados(urlAnosVeiculo);
                            return converterDados.obterDados(jsonAnos, VeiculosDetalhes.class);
                        })
                        .collect(Collectors.toList());

                System.out.println("\nTabela FIPE por ano do modelo de veículo: ");
                veiculosTabelaFipe.forEach(System.out::println);
            }
        }
}
