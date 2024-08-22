package appointment.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appointment.entity.Doctor;
import appointment.entity.Slot;
import appointment.repository.DoctorRepository;
import appointment.repository.SlotRepository;

@Service
public class SlotService {
    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Slot> configureWeeklySlots(Long doctorId, LocalDate startDate) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        List<Slot> slots = new ArrayList<>();

        // Define the time ranges and duration
        LocalTime morningStart = LocalTime.of(10, 0);
        LocalTime morningEnd = LocalTime.of(12, 0);
        LocalTime eveningStart = LocalTime.of(16, 0);
        LocalTime eveningEnd = LocalTime.of(18, 0);
        int durationMinutes = 20;

        // Generate slots for 7 days
        for (int day = 0; day < 7; day++) {
            LocalDate currentDate = startDate.plusDays(day);
            slots.addAll(generateSlotsForDay(doctor, currentDate, morningStart, morningEnd, durationMinutes));
            slots.addAll(generateSlotsForDay(doctor, currentDate, eveningStart, eveningEnd, durationMinutes));
        }

        return slotRepository.saveAll(slots);
    }

    private List<Slot> generateSlotsForDay(Doctor doctor, LocalDate date, LocalTime startTime, LocalTime endTime, int durationMinutes) {
        List<Slot> slots = new ArrayList<>();
        LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
        LocalDateTime endDateTime = LocalDateTime.of(date, endTime);

        while (startDateTime.isBefore(endDateTime)) {
            Slot slot = new Slot();
            slot.setDoctor(doctor);
            slot.setTime(startDateTime.toString());
            slot.setBooked(false);
            slots.add(slot);

            startDateTime = startDateTime.plusMinutes(durationMinutes);
        }

        return slots;
    }

    // Existing methods...
}