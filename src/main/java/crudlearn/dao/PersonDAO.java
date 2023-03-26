package crudlearn.dao;

import crudlearn.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {

    private static int COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++COUNT, "Tom"));
        people.add(new Person(++COUNT, "Som"));
        people.add(new Person(++COUNT, "Vova"));
        people.add(new Person(++COUNT, "Ahmed"));
    }

    public List<Person> index(){
        return  people;
    }
    public Person show(int id){
        return  people.stream()
                .filter(person -> person.getId() ==id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person){
        person.setId(++COUNT);
        people.add(person);
    }
}
