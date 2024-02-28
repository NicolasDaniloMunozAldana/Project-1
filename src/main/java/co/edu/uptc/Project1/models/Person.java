package co.edu.uptc.Project1.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Comparable<Person> {
    private String typeID;
    private long ID;
    private String name;
    private String lastName;
    private String gender;
    private String birthdate;
    private City cityOfBirth;

    @Override
    public int compareTo(Person o) {
        System.out.println("AAAAAAAAA");
        return this.name.compareTo(o.getName());
    }
}
