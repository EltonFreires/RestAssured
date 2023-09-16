package org.example.rest;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserJsonTest {
    String pathApi = "http://restapi.wcaquino.me";
    @Test
    public void verificandoPrimeiroNivel1(){
        given()
                .when()
                .get(pathApi+"/users/1")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("name", containsString("Silva"))
                .body("name", is("João da Silva"))
                .body("age", is(30))
                .body("age", greaterThan(18));

    }

    @Test
    public void verificandoPrimeiroNivel2(){
        Response response = request(Method.GET, pathApi+"/users/1");

        Assert.assertEquals(new Integer(1), response.path("id"));
        Assert.assertEquals(new Integer(1), response.path("%s","id"));

        JsonPath jsonPath = new JsonPath(response.asString());
        Assert.assertEquals(1, jsonPath.getInt("id"));

        int id = JsonPath.from(response.asString()).getInt("id");
        Assert.assertEquals(1, id);
    }

    @Test
    public void verificandoSegundoNivel(){
        given()
                .when()
                .get(pathApi+"/users/2")

                .then()
                .statusCode(200)
                .body("name", containsString("Joaquina"))
                .body("endereco.rua", is("Rua dos bobos"));
    }

    @Test
    public void verificandoSegundoNivelLista(){
        given()
                .when()
                .get(pathApi+"/users/3")

                .then()
                .statusCode(200)
                .body("name", containsString("Ana"))
                .body("filhos", hasSize(2))
                .body("filhos[0].name", is("Zezinho"))
                .body("filhos[1].name", is("Luizinho"))
                .body("filhos.name", hasItem("Luizinho"));
    }
}