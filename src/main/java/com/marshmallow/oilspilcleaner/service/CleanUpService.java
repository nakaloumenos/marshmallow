package com.marshmallow.oilspilcleaner.service;

import com.marshmallow.oilspilcleaner.resource.CleanUpInstructions;
import com.marshmallow.oilspilcleaner.resource.CleanUpResult;

public interface CleanUpService {
    CleanUpResult run(CleanUpInstructions cleanUpInstructions);
}
