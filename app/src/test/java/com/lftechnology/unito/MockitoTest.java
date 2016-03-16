package com.lftechnology.unito;

import com.lftechnology.unito.testing.Person;
import com.lftechnology.unito.testing.PersonChecker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/16/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    private Person person;

    @Spy
    private Person person2;

    @Test
    public void checkPerson() {
//        Person person = Mockito.mock(Person.class);
//        Mockito.when(person.getAge()).thenReturn(30);
//        person.setAge(20);
//        System.out.println(person.getAge());
        PersonChecker personChecker = new PersonChecker();
//        personChecker.checkAge(person);

        System.out.println(person2.getAge());
        person2.setAge(100);
        System.out.println(person2.getAge());

        Mockito.when(person2.getAge()).thenReturn(90).thenReturn(10).thenReturn(40).thenReturn(1200);
//        personChecker.checkAge(person2);
//        System.out.println(person2.getAge());
        Mockito.verify(person2).setAge(Matchers.anyInt());
        person2.setAge(100);
        Mockito.verify(person2, Mockito.atLeast(2)).setAge(Matchers.anyInt());
    }
}