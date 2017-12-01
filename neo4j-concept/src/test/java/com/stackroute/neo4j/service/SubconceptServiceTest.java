package com.stackroute.neo4j.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.never;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.domain.Subconcept;
import com.stackroute.neo4j.repository.SubconceptRepository;

@RunWith(MockitoJUnitRunner.class)
public class SubconceptServiceTest {
	
    @Spy
    private SubconceptService userServiceSpy;
    
    @Mock
    private SubconceptRepository userRepository;
    
    @Mock
    private Subconcept user;
    
    @Mock
    private Concept2 user1;
   @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerException_whenGetProductByIdIsCalledWithoutContext() throws Exception {
        //Act
	   Concept2 retrievedMovie = userServiceSpy.findlevelbyname("vinay");
        //Assert
        assertThat(retrievedMovie, is(equalTo(user)));
    }
   
//   @Test(expected=NullPointerException.class)
//   public void shouldThrowNullPointerException_whenSaveProductIsCalledWithoutContext() throws Exception {
//        //Arrange
//        Mockito.doReturn(user).when(userRepository).save(user);
//        //Act
//        Subconcept savedProduct = userServiceSpy.postnode(user);
//        //Assert
//        assertThat(savedProduct, is(equalTo(user)));
//    } 
   
   @Test
    public void shouldVerifyThatGetProductByIdIsCalled() throws Exception {
        //Arrange
        Mockito.doReturn(user1).when(userServiceSpy).findlevelbyname("vinay");
        //Act
        Concept2 retrievedProduct = userServiceSpy.findlevelbyname("vinay");
        //Assert
        Mockito.verify(userServiceSpy).findlevelbyname("vinay");
    }
    @Test
    public void shouldVerifyThatSaveProductIsNotCalled() throws Exception {
        //Arrange
        Mockito.doReturn(user1).when(userServiceSpy).findlevelbyname("vinay");
        //Act
        Concept2 retrievedProduct = userServiceSpy.findlevelbyname("vinay");
        //Assert
        Mockito.verify(userServiceSpy,never()).postnode(user);
    }
}