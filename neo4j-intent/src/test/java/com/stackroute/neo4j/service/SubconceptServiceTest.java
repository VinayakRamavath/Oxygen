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

import com.stackroute.neo4j.domain.Indicator;
import com.stackroute.neo4j.domain.Level;
import com.stackroute.neo4j.repository.IndicatorRepository;


@RunWith(MockitoJUnitRunner.class)
public class SubconceptServiceTest {
	
    @Spy
    private IndicatorService userServiceSpy;
    
    @Mock
    private IndicatorRepository userRepository;
    
    @Mock
    private Indicator user;
    
    @Mock
    private Level user1;
   @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerException_whenGetProductByIdIsCalledWithoutContext() throws Exception {
        //Act
	   Level retrievedMovie = userServiceSpy.findlevelbyname("vinay");
        //Assert
        assertThat(retrievedMovie, is(equalTo(user)));
    }
   
   @Test(expected=NullPointerException.class)
   public void shouldThrowNullPointerException_whenSaveProductIsCalledWithoutContext() throws Exception {
        //Arrange
        Mockito.doReturn(user).when(userRepository).save(user);
        //Act
        Indicator savedProduct = userServiceSpy.postnode(user);
        //Assert
        assertThat(savedProduct, is(equalTo(user)));
    } 
   
   @Test
    public void shouldVerifyThatGetProductByIdIsCalled() throws Exception {
        //Arrange
        Mockito.doReturn(user1).when(userServiceSpy).findlevelbyname("vinay");
        //Act
        Level retrievedProduct = userServiceSpy.findlevelbyname("vinay");
        //Assert
        Mockito.verify(userServiceSpy).findlevelbyname("vinay");
    }
    @Test
    public void shouldVerifyThatSaveProductIsNotCalled() throws Exception {
        //Arrange
        Mockito.doReturn(user1).when(userServiceSpy).findlevelbyname("vinay");
        //Act
        Level retrievedProduct = userServiceSpy.findlevelbyname("vinay");
        //Assert
        Mockito.verify(userServiceSpy,never()).postnode(user);
    }
}