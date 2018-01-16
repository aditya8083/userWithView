package com.coviam.controller;


import com.coviam.entity.UserDetail;
import com.coviam.service.UserManager;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;

@RestController
public class UserController {
    @Autowired UserManager userManager;

    @RequestMapping(value = "/user/getUserDetails", method = RequestMethod.GET)
    public String getUserDetails(HttpServletRequest request) throws JSONException {
        System.out.println("get user Details");
        String getUser = userManager.getUserDetails(request);
        return getUser;
    }

    @RequestMapping(value = "/user/saveUserDetails", method = RequestMethod.POST)
    public String saveUserDetails(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                  @RequestParam("age") String age, @RequestParam("dob") String dob,
                                  @RequestParam("emailId") String emailId, @RequestParam("contactNumber") String contactNumber,
                                  Model model) {
        System.out.println("save User Details");
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("age", age);
        model.addAttribute("dob", dob);
        model.addAttribute("emailId", emailId);
        model.addAttribute("contactNumber", contactNumber);
        userManager.saveUserDetails(mapParamToUserClassObj(firstName,lastName,age,dob,emailId,contactNumber));
        return "Your information is submitted successfully!!!";
    }

    private UserDetail mapParamToUserClassObj(String firstName, String lastName, String age, String dob, String emailId, String contactNumber) {
       UserDetail userDetail = new UserDetail();
       userDetail.setFirstName(firstName);
       userDetail.setLastName(lastName);
       userDetail.setAge(age);
       userDetail.setDob(dob);
       userDetail.setEmailId(emailId);
       userDetail.setContactNumber(contactNumber);
       return userDetail;
    }

    @RequestMapping(value = "/user/updateUserDetails", method = RequestMethod.PUT)
    public String updateUserDetails(@RequestBody UserDetail userDetail) {
        System.out.println("Update User Details");
        userManager.updateUserDetails(userDetail);
        return "User Data updated correctly";
    }

}

