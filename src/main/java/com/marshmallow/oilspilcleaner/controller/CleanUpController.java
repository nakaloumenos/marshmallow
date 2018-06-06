package com.marshmallow.oilspilcleaner.controller;

import com.marshmallow.oilspilcleaner.resource.CleanUpInstructions;
import com.marshmallow.oilspilcleaner.resource.CleanUpResult;
import com.marshmallow.oilspilcleaner.service.CleanUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class CleanUpController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CleanUpController.class);

    private final CleanUpService cleanUpService;

    public CleanUpController(CleanUpService cleanUpService) {
        this.cleanUpService = cleanUpService;
    }

    @PostMapping("/cleanup")
    public ResponseEntity sendCleanUpInstructions(@RequestBody CleanUpInstructions cleanUpInstructions) {
        LOGGER.info("Starting Clean Up Request");
        CleanUpResult cleanUpResult = cleanUpService.run(cleanUpInstructions);
        return new ResponseEntity<>(cleanUpResult, HttpStatus.OK);
    }


}
