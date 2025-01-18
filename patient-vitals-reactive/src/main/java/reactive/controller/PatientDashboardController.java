package reactive.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientDashboardController {

    @GetMapping("/patient-dashboard")
    public String showDashboard(Model model) {
        // Any initial data can be passed here (if needed)
        return "dashboard"; // Refers to 'dashboard.html' Thymeleaf template
    }
}
