package io.github.jibhaine.smtp.rest;

import static org.junit.Assert.*;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by blegrand on 08/09/2015.
 */
//@RunWith(CdiRunner.class)
@Ignore
public class MailResourceTest {

    //@Inject
    MailResource mailResource;

    @Test
    public void testMailResourceIsInjected() {
        assertNotNull("MailResource should not be null", mailResource);
    }

    @Test
    public void testMailResource_getMethodReturnsAJSONList(){
        //TODO
    }
}
