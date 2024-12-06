# Consulta Tabela FIPE

## Descrição
Este projeto Java é um cliente para a API da Tabela FIPE, permitindo a consulta de valores de veículos de forma automatizada. O usuário pode pesquisar por marcas, modelos e obter informações detalhadas sobre os veículos, incluindo valor de mercado e ano de fabricação.

## Funcionalidades
* Consulta de veículos por marca, modelo e ano.
* Exibição dos resultados em formato tabular.
* Utilização da API da Tabela FIPE para obter os dados.

## Tecnologias Utilizadas

* Spring Boot: Framework para desenvolvimento rápido de aplicações Java.
* Spring Boot Starter Web: Módulo do Spring Boot para desenvolvimento de aplicações web.
* Jackson: Biblioteca para trabalhar com JSON (opcional, caso a API retorne dados em JSON).
* dotenv-java: Biblioteca para gerenciar variáveis de ambiente (opcional).
* Gson: Biblioteca para trabalhar com JSON (opcional, caso a API retorne dados em JSON).

## Estrutura do Projeto
* **model:** Contém as classes que representam os dados da veículos, modelos e detalhes dos veículos.
* **service:** Contém a lógica para consumir a API e converter os dados.
* **principal:** Classe principal com a interface do usuário.
* **utils:** Contém classes utilitárias, como a classe `CodificarURL`.

## Como Usar
### Pré-Requisitos
* Java 17.
* Maven.
### 1. **Clone o repositório:**
   ```bash
   git clone https://[seu_repositorio]
   ``` 

## Licença
Este projeto está licenciado sob a licença [MIT License]

MIT License

Copyright (c) [2024] [Clairton Zerwes]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## Autor
* Clairton Zerwes - Desenvolvedor principal
