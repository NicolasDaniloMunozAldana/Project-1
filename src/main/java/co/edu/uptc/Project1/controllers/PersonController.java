package co.edu.uptc.Project1.controllers;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties.Simple;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.Project1.models.Person;
import co.edu.uptc.Project1.services.PersonServices;
import co.edu.uptc.UptcList.services.dinamic.SimpleList;

@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonServices personServices = new PersonServices();

    @GetMapping("/getPersons")
    public List<Person> getPersons() throws IOException {
        return personServices.getPersons();
    }

    @GetMapping("/getPersonsByName")
    public List<Person> getPersonsByName() {
        return personServices.getPersonsByName();
    }

    @PostMapping(value = "/postPerson", consumes = "application/json")
    public void postPerson(@RequestBody Person requestBody) {
        personServices.postPerson(requestBody);
    }
}
