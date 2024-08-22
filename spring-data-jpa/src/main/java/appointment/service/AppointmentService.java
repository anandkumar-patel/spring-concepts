package appointment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appointment.entity.Appointment;
import appointment.entity.Slot;
import appointment.repository.AppointmentRepository;
import appointment.repository.SlotRepository;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private SlotRepository slotRepository;

    public Appointment bookAppointment(Long slotId, String patientName) {
        Slot slot = slotRepository.findById(slotId).orElseThrow(() -> new RuntimeException("Slot not found"));
        if (slot.isBooked()) {
            throw new RuntimeException("Slot is already booked");
        }

        slot.setBooked(true);
        slotRepository.save(slot);

        Appointment appointment = new Appointment();
        appointment.setPatientName(patientName);
        appointment.setSlot(slot);
        return appointmentRepository.save(appointment);
    }
}