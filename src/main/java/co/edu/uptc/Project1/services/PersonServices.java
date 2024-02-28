package co.edu.uptc.Project1.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import co.edu.uptc.Project1.models.Person;
import co.edu.uptc.Project1.persistence.Persistence;
import co.edu.uptc.UptcList.services.dinamic.SimpleList;

public class PersonServices {
    private List<Person> list;
    private Persistence persistence;

    public PersonServices() {
        list = new SimpleList<Person>();
        persistence = new Persistence("data/persons.json");
        persistence.fillPersons(list);
    }

    public List<Person> getPersons() {
        return list;
    }

    public List<Person> getPersonsByName() {
        Collections.sort(list);
        for (Person person : list) {
            System.out.println("1111 " + person.getName());
        }
        return list;
    }

    public void postPerson(@RequestBody Person requestBody) {
        Person person = requestBody;
        list.add(person);
        persistence.addPerson(list);
    }

}
