//package com.masai.service;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.masai.exception.AdminException;
//import com.masai.exception.UserException;
//import com.masai.model.Admin;
//import com.masai.model.CurrentSession;
//import com.masai.model.LoginDto;
//import com.masai.model.User;
//import com.masai.repository.AdminDao;
//import com.masai.repository.SessionDao;
//import com.masai.repository.UserDao;
//
//import net.bytebuddy.utility.RandomString;
//@Service
//public class LoginServiceImpl implements LoginService{
//
//	@Autowired
//	private SessionDao sDao;
//
//	@Autowired
//	private UserDao uDao;
//
//	@Autowired
//	private AdminDao aDao;
//
//	@Override
//	public User loginUser(LoginDto credential) throws UserException {
//
//
//		System.out.println(credential.toString());
//		User existingUser =  uDao.findByUserName(credential.getName());
//
//
//		if(existingUser !=null) {
//
//
////		Optional<CurrentSession> curruser = sDao.findById(existingUser.getUserLoginId());
////
////
////		if(curruser.isPresent()) {
////
////			throw new UserException("User Already login");
////
////		}
//
////		else {
//
//
//			if(credential.getPassword().equals(existingUser.getPassword())) {
//
//				String key= RandomString.make(6);
//
//				CurrentSession active = new CurrentSession(existingUser.getUserLoginId(), "user",key, LocalDateTime.now());
//
//				 sDao.save(active);
//
//				 return existingUser;
//			}
//
//			else
//
//				throw new UserException("Password is wrong");
//
//
////		}
//
//
//
//		}
//		else
//			throw new UserException("User name is wrong");
//
//
//	}
//
//	@Override
//	public String logoutUser(String key) throws UserException {
//
//		 CurrentSession cs  =    sDao.findByUuid(key);
//
//		 if(cs !=null) {
//
//			 sDao.delete(cs);
//
//			 return "logoutSuccesfull";
//		 }
//		 else
//			 throw new UserException("Invalid uuid");
//	}
//
//
//
//
///************************************************** ADMIN *************************************************************************/
//
//
//	@Override
//	public Admin loginAdmin(LoginDto credential) throws AdminException {
//
//		Admin ad =   aDao.findByAdminName(credential.getName());
//
//		if(ad !=null) {
//
////		CurrentSession  cs = 	sDao.findByIdAndType(ad.getAdminId(), "admin");
////
////		if(cs == null) {
////
//
//			if(credential.getPassword().equals(ad.getAdminPassword())) {
//
//
//				String key= RandomString.make(6);
//
//				CurrentSession makingonline = new CurrentSession(ad.getAdminId(), "admin", key, LocalDateTime.now());
//
//				sDao.save(makingonline);
//
//				return ad;
//
//
//			}
//			else
//				throw new AdminException("Password is wrong");
//
//
////		}
////		else
////
////			throw new AdminException("Admin alredy login");
////
////
//
//
//		}
//		else
//
//			throw new AdminException("Admin name is wrong");
//
//
//	}
//
//	@Override
//	public String logoutAdmin(String key) throws AdminException {
//
//		CurrentSession cs = sDao.findByUuid(key);
//
//		if(cs != null && cs.getType().equals("admin") ) {
//
//			sDao.delete(cs);
//
//			return "Logout Succesfully";
//
//		}
//		else
//			throw new AdminException("key is invalid");
//
//	}
//
//}
