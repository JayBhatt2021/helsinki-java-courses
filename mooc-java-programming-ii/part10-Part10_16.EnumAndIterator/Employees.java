/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JayBh
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Employees {
    private ArrayList<Person> employees;
    
    public Employees() {
        this.employees = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        this.employees.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        Iterator<Person> iterator = peopleToAdd.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
    }
    
    public void print() {
        Iterator<Person> iterator = this.employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = this.employees.iterator();
        while (iterator.hasNext()) {
            Person currentPerson = iterator.next();
            if (currentPerson.getEducation() == education) {
                System.out.println(currentPerson);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = this.employees.iterator();
        while (iterator.hasNext()) {
            Person currentPerson = iterator.next();
            if (currentPerson.getEducation() == education) {
                iterator.remove();
            }
        }
    }
}
