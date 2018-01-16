package com.coviam.service;

import com.coviam.entity.UserDetail;
import com.coviam.util.RandomGenerator;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserManager {

    private String SUCCESS = "Success";
    private String FAILURE = "Failure";
    @Autowired RandomGenerator randomGenerator;

    public String getUserDetails(HttpServletRequest request) throws JSONException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        JSONObject userDetailObj = new JSONObject();
        Criteria criteria = session.createCriteria(UserDetail.class)
                .add(Restrictions.eq("userId", Integer.parseInt(request.getParameter("userId"))));
        List<UserDetail> userDetailVal = (List<UserDetail>)criteria.list();
        session.getTransaction().commit();
        session.close();
        userDetailObj.put("user_detail", userDetailVal);
        if(userDetailObj.getJSONArray("user_detail").length() !=0 ){
            userDetailObj.put("resCode", "200");
            userDetailObj.put("resMessage", SUCCESS);
            System.out.println("User Detail response got successfully");
            return userDetailObj.toString().replaceAll("\\\\", "");
        }
        userDetailObj.put("resCode", "301");
        userDetailObj.put("resMessage", FAILURE);
        return userDetailObj.toString().replaceAll("\\\\", "");
    }

    public void saveUserDetails(UserDetail userDetail) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetail);
        session.getTransaction().commit();
        session.close();
    }

    private UserDetail getUserDetailReqParams(HttpServletRequest request) {
        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(Integer.parseInt(request.getParameter("userId")));
        userDetail.setFirstName(request.getParameter("firstName"));
        userDetail.setLastName(request.getParameter("lastName"));
        userDetail.setEmailId(request.getParameter("emailId"));
        userDetail.setDob(request.getParameter("DOB"));
        userDetail.setAge(request.getParameter("age"));
        userDetail.setContactNumber(request.getParameter("contactNumber"));
        return userDetail;
    }

    public void updateUserDetails(UserDetail userDetail) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(userDetail);
        session.getTransaction().commit();
        session.close();
    }
}
