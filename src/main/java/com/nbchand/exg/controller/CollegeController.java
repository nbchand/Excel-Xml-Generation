package com.nbchand.exg.controller;

import com.nbchand.exg.pojo.CollegeListPojo;
import com.nbchand.exg.pojo.CollegePojo;
import com.nbchand.exg.pojo.Response;
import com.nbchand.exg.service.CollegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-05-31
 */
@RestController
@RequestMapping("/college")
@RequiredArgsConstructor
public class CollegeController {

    private final CollegeService collegeService;

    @PostMapping
    public ResponseEntity<Response> save(@RequestBody CollegePojo collegePojo) {
        return ResponseEntity.ok(new Response("College created successfully!", collegeService.save(collegePojo)));
    }

    @GetMapping(value = "/all",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    public ResponseEntity<Response> findAll() {
        return ResponseEntity.ok(new Response("List of colleges fetched successfully!", collegeService.findAll()));
    }

    @GetMapping("/xml/all")
    public ResponseEntity<Response> createCollegeXml() throws JAXBException {
        CollegeListPojo collegeListPojo = new CollegeListPojo(collegeService.findAll());
        JAXBContext jaxbContext = JAXBContext.newInstance(CollegeListPojo.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File("src\\main\\resources\\colleges.xml");
        marshaller.marshal(collegeListPojo, file);
        return ResponseEntity.ok(new Response("College list xml created successfully!", collegeListPojo.getCollegePojoList()));
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadXml() throws IOException {
        File file = new File("src\\main\\resources\\colleges.xml");
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=collegeData.xml");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
