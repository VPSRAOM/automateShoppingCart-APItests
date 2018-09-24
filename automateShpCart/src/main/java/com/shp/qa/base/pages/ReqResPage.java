package com.shp.qa.base.pages;

import com.shp.qa.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.support.PageFactory;

public class ReqResPage extends TestBase {

    public int testGet(String path) {
        Response resp = RestAssured.get(path);
        int code = resp.getStatusCode();
        System.out.println("URL IS" + path);
        System.out.println("status code is:" + code);
        return code;
    }

    public int testPut(String path) {
        Response resp = RestAssured.put(path);
        int code = resp.getStatusCode();
        System.out.println("URL IS" + path);
        System.out.println("status code is:" + code);
        return code;
    }

    public int testPost(String path) {
        Response resp = RestAssured.post(path);
        int code = resp.getStatusCode();
        System.out.println("URL IS" + path);
        System.out.println("status code is:" + code);
        return code;
    }

    public int testsPatch(String path) {
        Response resp = RestAssured.patch(path);
        int code = resp.getStatusCode();
        System.out.println("URL IS" + path);
        System.out.println("status code is:" + code);
        return code;
    }

    public int testsDelete(String path) {
        Response resp = RestAssured.delete(path);
        int code = resp.getStatusCode();
        System.out.println("URL IS" + path);
        System.out.println("status code is:" + code);
        return code;
    }

    public ReqResPage() {
        PageFactory.initElements(driver, this);
    }
}


