package ku.cs.kafe.controller;


import ku.cs.kafe.model.SignupRequest_Kantanop_6210451063;
import ku.cs.kafe.service.SignupService_Kantanop_6210451063;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SignupController_Kantanop_6210451063 {


    @Autowired
    private SignupService_Kantanop_6210451063 signupServiceKantanop6210451063;


    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup"; // return หน้าฟอร์ม signup.html
    }


    @PostMapping("/signup")
    public String signupUser(@ModelAttribute SignupRequest_Kantanop_6210451063 user,
                             Model model) {
        if (signupServiceKantanop6210451063.isUsernameAvailable(user.getUsername())) {
            signupServiceKantanop6210451063.createUser(user);
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", "Username not available");
        }
        return "signup";
    }
}
