package appointment.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import appointment.entity.Slot;
import appointment.service.SlotService;

@RestController
@RequestMapping("/slots")
public class SlotController {
    @Autowired
    private SlotService slotService;

    @PostMapping("/configure-weekly")
    public List<Slot> configureWeeklySlots(@RequestParam Long doctorId, @RequestParam String startDate) {
        LocalDate start = LocalDate.parse(startDate); // Format: yyyy-MM-dd
        return slotService.configureWeeklySlots(doctorId, start);
    }

    // Existing endpoints...
}