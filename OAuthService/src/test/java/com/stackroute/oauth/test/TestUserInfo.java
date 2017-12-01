//package com.stackroute.oauth.test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//import java.util.Set;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.omg.PortableInterceptor.USER_EXCEPTION;
//
//import com.stackroute.oauth.model.UserInfo;
//import com.stackroute.oauth.model.UserRole;
//
//public class TestUserInfo {
//	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//	private Validator validator = factory.getValidator();
//	
//	private UserInfo user;
//	private UserRole role;
//	private boolean truth;
//	
//	@Before
//	public void before() throws Exception {
//		user = new UserInfo();
//		role = new UserRole();
//		truth = false;
//	}
//	
//	@After
//    public void after() throws Exception {
//        user = null;
//        role = null;
//        assertNull(user);
//        assertNull(role);
//        truth = false;
//    }
//
//	
//	@Test
//	public void testPsaid() {	
////		user.setPsaid(111111);
////		Integer actual = user.getPsaid();
//		user.setUsername("user");
//		String actual =user.getUsername();
//		assertNotNull(actual);
//		assertEquals((Integer)111111, actual);
//	}
//	
//	
//	@Test
//	public void testEmail() {
//		user.setEmail("p.b@cgi.com");
//		String actual = user.getEmail();
//		
//		assertNotNull(actual);
//		assertEquals("p.b@cgi.com", actual);
//	}
//	
//	
//	@Test
//	public void testPassword() {	
//		user.setPassword("P@ssw0rd");
//		String actual = user.getPassword();
//		
//		assertNotNull(actual);
//		assertEquals("P@ssw0rd", actual);
//	}
//	
//	
//	@Test
//	public void testUsername() {	
//		user.setUsername("username");
//		String actual = user.getUsername();
//		
//		assertNotNull(actual);
//		assertEquals("username", actual);
//	}
//	
//	
//	@Test
//	public void testRole() {
//		role.setRolename("ROLE_USER");
//		String actual = role.getRolename();
//		
//		assertNotNull(actual);
//		assertEquals("ROLE_USER", actual);
//	}
//	
//	
//	/*
//	psaid cannot be null
//	*/
//	@Test
//	public void testPsaidNull() {
//		String actual = null;
//		boolean truth = false;
//		
////		user.setPsaid(null);
//		user.setEmail("p.b@cgi.com");
//		user.setPassword("P@ssw0rd");
//		user.setUsername("bob the builder");
//		Set<ConstraintViolation<UserInfo>> violations = validator.validate(user);
//		for(ConstraintViolation<UserInfo> violation : violations) {
//			actual = violation.getMessage();
//			if(actual.compareTo("psaid cannot be null")==0) {
//				truth=true;
//			}
//		}
//		
//		assert(truth);
//	}
//	
//	
//	/*
//	email cannot be null
//	*/
//	@Test
//	public void testEmailNull() {
//		String actual = null;
//		
////		user.setPsaid(111111);
//		user.setEmail(null);
//		user.setPassword("P@ssw0rd");
//		user.setUsername("bob the builder");
//		Set<ConstraintViolation<UserInfo>> violations = validator.validate(user);
//		for(ConstraintViolation<UserInfo> violation : violations) {
//			actual = violation.getMessage();
//		}
//		
//		assertEquals("email cannot be null", actual);
//	}
//	
//	
//	/*
//	email cannot be empty
//	*/
//	@Test
//	public void testEmailEmpty() {
//		String actual = null;
//		
////		user.setPsaid(111111);
//		user.setEmail("");
//		user.setPassword("P@ssw0rd");
//		user.setUsername("bob the builder");
//		Set<ConstraintViolation<UserInfo>> violations = validator.validate(user);
//		for(ConstraintViolation<UserInfo> violation : violations) {
//			actual = violation.getMessage();
//			if(actual.compareTo("email must be @cgi.com domain")==0) {
//				truth=true;
//			}
//		}
//		assert(truth);
//	}
//	
//	/*
//	email id cannot be empty
//	*/
//	@Test
//	public void testEmailEmptyId() {
//		String actual = null;
//		
////		user.setPsaid(111111);
//		user.setEmail("@cgi.com");
//		user.setPassword("P@ssw0rd");
//		user.setUsername("bob the builder");
//		Set<ConstraintViolation<UserInfo>> violations = validator.validate(user);
//		for(ConstraintViolation<UserInfo> violation : violations) {
//			actual = violation.getMessage();
//			if(actual.compareTo("email must be @cgi.com domain")==0) {
//				truth=true;
//			}
//		}
//		
//		assert(truth);
//	}
//	
//	
//	/*
//	email must be of @cgi domain
//	*/
//	@Test
//	public void testEmailPattern() {
//		String actual = null;
//		
////		user.setPsaid(111111);
//		user.setEmail("p.b@gmail.com");
//		user.setPassword("P@ssw0rd");
//		user.setUsername("bob the builder");
//		Set<ConstraintViolation<UserInfo>> violations = validator.validate(user);
//		for(ConstraintViolation<UserInfo> violation : violations) {
//			actual = violation.getMessage();
//			if(actual.compareTo("email must be @cgi.com domain")==0) {
//				truth=true;
//			}
//		}
//		
//		assert(truth);
//	}
//	
//	
//	
//	
//	/*
//	password cannot be null
//	*/
//	@Test
//	public void testPasswordNull() {
//		String actual = null;
//		
////		user.setPsaid(111111);
//		user.setEmail("p.b@cgi.com");
//		user.setPassword(null);
//		user.setUsername("bob the builder");
//		Set<ConstraintViolation<UserInfo>> violations = validator.validate(user);
//		for(ConstraintViolation<UserInfo> violation : violations) {
//			actual = violation.getMessage();
//			if(actual.compareTo("password cannot be null")==0) {
//				truth=true;
//			}
//		}
//		
//		assert(truth);
//	}
//	
//	
//	/*
//	password cannot be empty
//	*/
////	@Test
////	public void testPasswordEmpty() {
////		String actual = null;
////		
////		user.setPsaid(111111);
////		user.setEmail("p.b@cgi.com");
////		user.setPassword("");
////		user.setUsername("bob the builder");
////		Set<ConstraintViolation<UserInfo>> violations = validator.validate(user);
////		for(ConstraintViolation<UserInfo> violation : violations) {
////			actual = violation.getMessage();
////			if(actual.compareTo("password must have atleast one uppercase, atleast one lowercase, atleast one numeric digit and atleast one special character")==0) {
////				truth=true;
////			}
////		}
////		
////		assert(truth);
////	}
//	
//	
//	/*
//	password must be atleast 8 characters
//	*/
////	@Test
////	public void testPasswordSize() {
////		String actual = null;
////		
////		user.setPsaid(111111);
////		user.setEmail("p.b@cgi.com");
////		user.setPassword("P@s4");
////		user.setUsername("bob the builder");
////		Set<ConstraintViolation<UserInfo>> violations = validator.validate(user);
////		for(ConstraintViolation<UserInfo> violation : violations) {
////			actual = violation.getMessage();
////			if(actual.compareTo("password must have atleast one uppercase, atleast one lowercase, atleast one numeric digit and atleast one special character")==0) {
////				truth=true;
////			}
////		}
////		
////		assert(truth);
////	}
//	
//	
//	/*
//	password must have numerical digit, lowercase, uppercase, special character
//	*/
////	@Test
////	public void testPasswordPattern() {
////		String actual = null;
////		truth = false;
////		
////		user.setPsaid(111111);
////		user.setEmail("p.b@cgi.com");
////		user.setPassword("pppppppppppPPP");
////		user.setUsername("bob the builder");
////		Set<ConstraintViolation<UserInfo>> violations = validator.validate(user);
////		for(ConstraintViolation<UserInfo> violation : violations) {
////			actual = violation.getMessage();
////			if(actual.compareTo("password must have atleast one uppercase, atleast one lowercase, atleast one numeric digit and atleast one special character")==0) {
////				truth=true;
////			}
////		}
////		
////		assert(truth);
////	}
//	
//	
//	
//	
//	/*
//	username cannot be null
//	*/
//	@Test
//	public void testUsernameNull() {
//		String actual = null;
//		
////		user.setPsaid(111111);
//		user.setEmail("p.b@cgi.com");
//		user.setPassword("P@ssw0rd");
//		user.setUsername(null);
//		Set<ConstraintViolation<UserInfo>> violations = validator.validate(user);
//		for(ConstraintViolation<UserInfo> violation : violations) {
//			actual = violation.getMessage();
//		}
//		
//		assertEquals("username cannot be null", actual);
//	}
//	
//	/*
//	username cannot be empty
//	*/
//	@Test
//	public void testUsernameSize() {
//		String actual = null;
//		
////		user.setPsaid(111111);
//		user.setEmail("p.b@cgi.com");
//		user.setPassword("P@ssw0rd");
//		user.setUsername("");
//		Set<ConstraintViolation<UserInfo>> violations = validator.validate(user);
//		for(ConstraintViolation<UserInfo> violation : violations) {
//			actual = violation.getMessage();
//			if(actual.compareTo("username cannot be empty")==0) {
//				truth=true;
//			}
//		}
//		
//		assert(truth);
//	}
//	
//	/*
//	rolename cannot be null
//	*/
//	@Test
//	public void testRoleNull() {
//		String actual=null;
//		
//		role.setRolename(null);
//		Set<ConstraintViolation<UserRole>> violations = validator.validate(role);
//		for(ConstraintViolation<UserRole> violation : violations) {
//			actual = violation.getMessage();
//		}
//		
//		assertEquals("user role cannot be null", actual);
//	}
//	
//	/*
//	rolename cannot be empty
//	*/
//	@Test
//	public void testRoleEmpty() {
//		String actual=null;
//		
//		role.setRolename("");
//		Set<ConstraintViolation<UserRole>> violations = validator.validate(role);
//		for(ConstraintViolation<UserRole> violation : violations) {
//			actual = violation.getMessage();
//		}
//		
//		assertEquals("role must have ROLE_ prefix", actual);
//	}
//	
//	/*
//	role must have prefix of ROLE_
//	*/
//	@Test
//	public void testRolePattern() {
//		String actual=null;
//		
//		role.setRolename("User");
//		Set<ConstraintViolation<UserRole>> violations = validator.validate(role);
//		for(ConstraintViolation<UserRole> violation : violations) {
//			actual = violation.getMessage();
//		}
//		
//		assertEquals("role must have ROLE_ prefix", actual);
//	}
//	
//	/*
//	userrole cannot be null
//	*/
//	@Test
//	public void testUserRoleNull() {
//		String actual=null;
//		
//		user.setRoles(null);
//		Set<ConstraintViolation<UserInfo>> violations = validator.validate(user);
//		for(ConstraintViolation<UserInfo> violation : violations) {
//			actual = violation.getMessage();
//			if(actual.compareTo("roles cannot be empty")==0) {
//				truth=true;
//			}
//		}
//		
//		assert(truth);
//	}
//}
