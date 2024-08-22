package appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import appointment.entity.Slot;

public interface SlotRepository extends JpaRepository<Slot, Long> {

}
