//package test.services;
//
//import static org.junit.Assert.*; 
//import org.junit.Test;
//import org.junit.runner.RunWith; 
//import org.mockito.Spy;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import com.stackroute.github.domain.SearchResultsModel;
//import com.stackroute.github.repository.ApiRepository;
//import com.stackroute.github.services.ApiServiceImpl;
//import org.mockito.Mock;
//import org.mockito.Mockito; 
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ApiServiceImplTest {
//	
//    @Spy
//    private ApiServiceImpl userServiceSpy;
//    
//    @Mock
//    private ApiRepository userRepository;
//    
//    @Mock
//    private SearchResultsModel user;
//
//   @Test(expected=NullPointerException.class)
//   public void shouldThrowNullPointerException_whenFetchUrlWithoutContext() throws Exception {
//        //Arrange
//        Mockito.doReturn(user).when(userRepository).save(user);
//        //Act
//        String savedProduct = userServiceSpy.fetchUrls();
//        //Assert
//        assertThat(savedProduct, is(equalTo(user)));
//    } 
//   
//   @Test
//    public void shouldVerifyThatFetchUrlIsCalled() throws Exception {
//        //Arrange
//        Mockito.doReturn(user).when(userServiceSpy).fetchUrls();
//        //Act
//        String retrievedProduct = userServiceSpy.fetchUrls();
//        //Assert
//        Mockito.verify(userServiceSpy).fetchUrls();
//    }
//
//}