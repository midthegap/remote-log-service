package it.midthegap.remotelogger.controller;

import it.midthegap.remotelogger.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogsController {

    @Autowired
    private LoggerService loggerService;

    @PostMapping(value = "/api/log", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> logs(
            @RequestParam int priority,
            @RequestParam @Nullable String tag,
            @RequestParam String message) {

        loggerService.logit(priority, tag, message);

        return ResponseEntity.ok().build();
    }

}
