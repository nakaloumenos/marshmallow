package com.marshmallow.oilspilcleaner.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marshmallow.oilspilcleaner.resource.CleanUpInstructions;
import com.marshmallow.oilspilcleaner.resource.CleanUpResult;
import com.marshmallow.oilspilcleaner.service.impl.CleanUpServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest
public class CleanUpServiceTest {

    private CleanUpInstructions cleanUpInstructions;

    @Before
    public void setup() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CleanUpInstructions cleanUpInstructions = objectMapper.readValue(new File("src/test/resources/CleanUpInstructions.json"), CleanUpInstructions.class);
    }

    @Test
    public void canRun() {
        CleanUpService cleanUpService = new CleanUpServiceImpl();
        CleanUpResult cleanUpResult = cleanUpService.run(cleanUpInstructions);
        Assert.assertEquals(1, cleanUpResult.getOilPatchesCleaned());
    }

}
