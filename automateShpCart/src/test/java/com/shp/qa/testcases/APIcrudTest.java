package com.shp.qa.testcases;

import com.shp.qa.base.TestBase;
import com.shp.qa.base.pages.ReqResPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APIcrudTest extends TestBase {

    public APIcrudTest() {
        super();
    }

    // GET
    @Test(priority = 4)
    public void successfulgetTest() {
        ReqResPage reqrespage = new ReqResPage();
        int g;
        //GET 200
        System.out.println("This is a Successful GET returns 200");
        g = reqrespage.testGet(prop.getProperty("urlG"));
        Assert.assertEquals(g, 200);

    }

    @Test(priority = 5)
    public void unsucfulgetTest() {
        ReqResPage reqrespage = new ReqResPage();
        int g4;
        System.out.println("This is a UnSuccessful GET returns 404:");
        //GET 404
        g4 = reqrespage.testGet(prop.getProperty("urlG404"));
        Assert.assertEquals(g4, 404);
    }

    @Test(priority = 6)
    public void patchTest() {
        ReqResPage reqrespage = new ReqResPage();
        int pa;
        System.out.println("This is a Patch test returns 200");
        //PATCH-200
        pa = reqrespage.testsPatch(prop.getProperty("urlPa"));
        Assert.assertEquals(pa, 200);
    }

    @Test(priority = 7)
    public void putTest() {
        ReqResPage reqrespage = new ReqResPage();
        int pu;
        System.out.println("This is a PUT test returns 200");
        //PUT-200
        pu = reqrespage.testPut(prop.getProperty("urlPut"));
        Assert.assertEquals(pu, 200);
    }

    @Test(priority = 8)
    public void deleteTest() {
        ReqResPage reqrespage = new ReqResPage();
        int d;
        System.out.println("This is a Delete returns 204");
        //DELETE-204
        d = reqrespage.testsDelete(prop.getProperty("urlDel"));
        Assert.assertEquals(d, 204);
    }

    @Test(priority = 9)
    public void postTest() {
        ReqResPage reqrespage = new ReqResPage();
        int po;
        System.out.println("This is a POST 201");
        //Post-201
        po = reqrespage.testPost(prop.getProperty("urlPo"));
        Assert.assertEquals(po, 201);
    }

}



