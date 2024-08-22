package appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import appointment.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
