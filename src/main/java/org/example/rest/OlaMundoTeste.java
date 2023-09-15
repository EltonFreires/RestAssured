package org.example.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class OlaMundoTeste {
    @Test
    public void olaMundo1() {
        Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/ola");
        assertTrue(response.getBody().asString().equals("Ola Mundo!"));
        assertTrue(response.statusCode() == 200);

        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);
    }

    @Test
    public void olaMundo2() {
        get("http://restapi.wcaquino.me/ola").then().statusCode(200);
    }

    @Test
    public void olaMundo3() {
        // Given/When/Then
        given()
        .when()
            .get("http://restapi.wcaquino.me/ola")
        .then()
            .statusCode(200);
    }

    @Test
    public void exFalha01() {
        // Falha: erro na validação
        System.out.println("2 falhas, e não diz o aconteceu, só aponta onde ocorreu o erro!");
        assertTrue(200 == 201);
        assertTrue("200".equals("201"));
    }

    @Test
    public void exFalha02() {
        // Falha: erro na validação
        System.out.println("2 falhas, informando manualmente o que aconteceu!");
        int statusEsperado = 200;
        int statusRetornado = 201;
        assertTrue("Status esperado:" + statusEsperado + ", Status retornado:" + statusRetornado, 200 == 201);
    }

    @Test
    public void exFalha03() {
        // Falha: erro na validação
        System.out.println("2 erros, informando automaticamente o que aconteceu!");
        assertEquals(200, 201);
    }

    @Test
    public void exErro() {
        System.out.println("Erro de execução!");
        assertTrue(201 == 201);

        if (1 == 1) {
            throw new RuntimeException();
        }

        assertTrue(201 == 201);
    }

    @Test
    public void matcherHamcrest(){
        assertThat("maria", is("maria"));
        assertThat(12, is(12));
        assertThat(12, isA(Integer.class));
        assertThat(12, lessThan(13));

        List<Integer> impares = Arrays.asList(1,3,5,7);
        assertThat(impares, hasSize(4));
        assertThat(impares, contains(1,3,5,7));
        assertThat(impares, containsInAnyOrder(1,3,7,5));
        assertThat(impares, hasItem(3));
        assertThat(impares, hasItems(3,7));

        assertThat("maria", is(not("joão")));
        assertThat("maria", not("joão"));
        assertThat("maria", anyOf(is("joão"), is("maria")));
        assertThat("joaquina", allOf(startsWith("joa"), endsWith("ina"), containsString("qui")));


    }
}
