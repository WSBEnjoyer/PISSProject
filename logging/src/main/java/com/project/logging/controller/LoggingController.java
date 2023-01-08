package com.project.logging.controller;

import com.project.logging.config.Constants;
import com.project.logging.model.LogMessage;
import com.project.logging.model.LogResponseMessage;
import com.project.logging.service.LoggingService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class LoggingController {
    private final LoggingService loggingService;

    public LoggingController(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @MessageMapping(Constants.LOGGING_ENDPOINT)
    @SendTo(Constants.LOGGING_RESPONSE_ENDPOINT)
    public LogResponseMessage log(LogMessage logMessage) {
        loggingService.log(logMessage);

        return new LogResponseMessage("Logging successful");
    }
}
