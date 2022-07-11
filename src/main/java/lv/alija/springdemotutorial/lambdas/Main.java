package lv.alija.springdemotutorial.lambdas;

import java.util.List;
import java.util.function.Predicate;

public class Main {



    public static void printPersonOlderThen(List<Person> people, int age){
        for(Person p:people){
            if(p.getAge() >=age){
                p.printPerson();
            }
        }
    }


    public static void printPersonWithinAgeRange(
            List<Person> people, int low, int high){

        for(Person p: people){
            if(low <=p.getAge() && p.getAge() <high) {
                p.printPerson();
            }
        }
    }

    public static void printPeople(List<Person> people, CheckPerson tester){

        for(Person p: people){
            if(tester.test(p)) {
                p.printPerson();
            }
        }

    }

    public static void printPeopleWithPredicate(List<Person> people, Predicate<Person> tester){

        for(Person p: people){
            if(tester.test(p)) {
                p.printPerson();
            }
        }

    }

    public static void main(String[] args) {

        List<Person> people = Person.generatedDefaultList();
      //  printPersonOlderThen(people, 23);
     //   printPersonWithinAgeRange(people, 20, 40);
      //  printPeople(people, new CheckPersonEligibleForSelectiveSearch());



        //use anonymous class--> new CheckPerson() that implements interface and interfaces methods
        printPeople(people, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.gender ==Person.Sex.FEMALE &&
                        p.getAge() >= 18 &&
                        p.getAge() <= 25;
            }
        });


        //lambdas expressions


          // if only one variable and Person is in abstract method also as parameter:  printPeople(people,  p -> {
             //also if more than one variable:   printPeople(people, (p, secondVariable) -> {
            printPeople(people, (Person p) -> {
                return p.gender ==Person.Sex.FEMALE &&
                        p.getAge() >= 18 &&
                        p.getAge() <= 25;

        });
            //java also know about return, so no need to write it, if there is only one statement in implementation
        printPeople(people, (p) -> p.gender == Person.Sex.FEMALE &&
                    p.getAge() >= 18 && p.getAge() <= 25
        );
        printPeopleWithPredicate(people, (p) -> p.gender == Person.Sex.FEMALE &&
                p.getAge() >= 18 && p.getAge() <= 25
        );
    }

}
