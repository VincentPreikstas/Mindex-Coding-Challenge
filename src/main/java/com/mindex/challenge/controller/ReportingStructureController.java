package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private ReportingStructureService reportingStructureService;

    @GetMapping("/reportingstructure")
    public String hello(){
        LOG.debug("Called my testing function");

        return reportingStructureService.hello();
    }

    @GetMapping("/reportingstructure/{id}")
    public ReportingStructure read(@PathVariable String id){
        LOG.debug("Received Reporting Structure request for id [{}]", id);

        return reportingStructureService.read(id);
    }

}
