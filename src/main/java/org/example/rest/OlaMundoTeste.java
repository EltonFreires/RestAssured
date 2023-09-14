package org.example.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class OlaMundoTeste {
    @Test
    public void OlaMundo1() {
        Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/ola");
        Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
        Assert.assertTrue(response.statusCode() == 200);

        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);
    }

    @Test
    public void OlaMundo2() {
        get("http://restapi.wcaquino.me/ola").then().statusCode(200);
    }

    @Test
    public void OlaMundo3() {
        // Given/When/Then
        given()
        .when()
            .get("http://restapi.wcaquino.me/ola")
        .then()
            .statusCode(200);
    }

    @Test
    public void ExFalha01() {
        // Falha: erro na validação
        System.out.println("2 falhas, e não diz o aconteceu, só aponta onde ocorreu o erro!");
        Assert.assertTrue(200 == 201);
        Assert.assertTrue("200".equals("201"));
    }

    @Test
    public void ExFalha02() {
        // Falha: erro na validação
        System.out.println("2 falhas, informando manualmente o que aconteceu!");
        int statusEsperado = 200;
        int statusRetornado = 201;
        Assert.assertTrue("Status esperado:" + statusEsperado + ", Status retornado:" + statusRetornado, 200 == 201);
    }

    @Test
    public void ExFalha03() {
        // Falha: erro na validação
        System.out.println("2 erros, informando automaticamente o que aconteceu!");
        Assert.assertEquals(200, 201);
    }

    @Test
    public void ExErro() {
        System.out.println("Erro de execução!");
        Assert.assertTrue(201 == 201);

        if (1 == 1) {
            throw new RuntimeException();
        }

        Assert.assertTrue(201 == 201);
    }
}
