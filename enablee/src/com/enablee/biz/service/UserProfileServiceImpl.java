package com.enablee.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enablee.db.bo.UserProfile;
import com.enablee.db.dao.UserProfileDAO;


@Service
public class UserProfileServiceImpl implements UserProfileService{
	@Autowired
    private UserProfileDAO userProfileDAO;
	
    @Transactional
    public void addUser(UserProfile userProfile) throws Exception {
    	userProfileDAO.create(userProfile);
    }
 
    @Transactional
    public List<UserProfile> listUser() throws Exception {
 
        return userProfileDAO.findAll(UserProfile.class);
    }
 
    @Transactional
    public void removeUser(Long id) throws Exception {
    	UserProfile userProfile = userProfileDAO.find(UserProfile.class, id);
    	userProfileDAO.delete(UserProfile.class, id);
    }

	@Override
	@Transactional
	public UserProfile getUser(Long id) throws Exception {
		return userProfileDAO.find(UserProfile.class, id);
	}

	@Override
	@Transactional
	public void updateUser(UserProfile userProfile) throws Exception {
		userProfileDAO.update(userProfile);
	}

	@Override
	@Transactional
	public List<UserProfile> listUsers() throws Exception {
		return userProfileDAO.findAll(UserProfile.class);
	}
}
