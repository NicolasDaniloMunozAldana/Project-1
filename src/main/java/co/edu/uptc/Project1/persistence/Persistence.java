package co.edu.uptc.Project1.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import co.edu.uptc.Project1.models.City;
import co.edu.uptc.Project1.models.Person;
import co.edu.uptc.UptcList.services.dinamic.SimpleList;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Persistence {
    private String pathJSON;

    public void fillPersons(List<Person> list) {
        try {
            JSONObject jsonObject = new JSONObject(new String(Files.readAllBytes(Paths.get(pathJSON))));
            JSONArray jsonArray = jsonObject.getJSONArray("persons");
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(parsePerson(jsonArray.getJSONObject(i)));
            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    public void addPerson(List<Person> persons) {
        try {
            JSONArray jsonArray = new JSONArray(persons);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("persons", jsonArray);
            writeJSON(jsonObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeJSON(JSONObject jsonObject) throws FileNotFoundException {
        try {
            Files.write(Paths.get("data/persons.json"),jsonObject.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Person parsePerson(JSONObject jsonObject) {
        Person person = new Person();
        City city = new City();
        person.setTypeID(jsonObject.getString("typeID"));
        person.setID(jsonObject.getLong("ID"));
        person.setName(jsonObject.getString("name"));
        person.setLastName(jsonObject.getString("lastName"));
        person.setGender(jsonObject.getString("gender"));
        person.setBirthdate(jsonObject.getString("birthdate"));
        JSONObject birthdateCity = jsonObject.getJSONObject("cityOfBirth");
        city.setName(birthdateCity.getString("name"));
        city.setDaneCode(birthdateCity.getInt("daneCode"));
        person.setCityOfBirth(city);
        return person;
    }
}
