package appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import appointment.entity.Appointment;
import appointment.entity.Slot;
import appointment.repository.SlotRepository;
import appointment.service.AppointmentService;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    
    @Autowired
    private SlotRepository slotRepository;

    @PostMapping("/book")
    public Appointment bookAppointment(@RequestParam Long slotId, @RequestParam String patientName) {
    	return null;
    }
}