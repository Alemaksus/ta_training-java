package com.epam.training.student_aleksandr_maksakov.beware_of_dogs.residents.dogs;

public class Puppy extends Dog {

    public Puppy(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Puppy " + name;
    }
}
