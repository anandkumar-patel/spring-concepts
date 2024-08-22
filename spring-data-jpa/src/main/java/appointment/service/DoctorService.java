package appointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anand.exception.ResourceNotFoundException;
import appointment.entity.Doctor;
import appointment.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	public Doctor save(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	public Doctor getDoctorById(Long id) {
		return doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id " + id));
	}

	public Doctor update(Long id, Doctor updated) {
		return doctorRepository.findById(id).map(doctor -> {
			doctor.setName(updated.getName());
			doctor.setSpecialty(updated.getSpecialty());
			return doctorRepository.save(doctor);
		}).orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id " + id));
	}

	public void deleteDoctor(Long id) {
		doctorRepository.deleteById(id);
	}
}
