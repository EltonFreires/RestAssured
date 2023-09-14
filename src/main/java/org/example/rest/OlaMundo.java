package org.example.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class OlaMundo {
    public static void main(String[] args) {
        Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/ola");
        System.out.println(response.getBody().asString());
        System.out.println(response.statusCode());

        System.out.println(response.getBody().asString().equals("Ola Mundo!"));
        System.out.println(response.statusCode() == 200);

        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);
    }

    public void solucoesProblemas() {
        // caso ocorra erro de acesso no modelo abaixo
        // Response response = RestAssured.request(Method.GET, "https://localhost/api");
        // Possíveis soluções
        // Response response = RestAssured.request(Method.GET, "https://localhost:80/api");
        // ping no servidor "ping localhost", depois coloca o endereço
        //      Response response = RestAssured.request(Method.GET, "https://127.0.0.1/api");
    }
}
