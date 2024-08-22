package appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import appointment.entity.Doctor;
import appointment.service.DoctorService;


@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	@PostMapping
	public ResponseEntity<Doctor> create(@RequestBody Doctor doctor) {
		return ResponseEntity.ok(doctorService.save(doctor));
	}
	
	@GetMapping
	public ResponseEntity<List<Doctor>> readAll() {
		List<Doctor> doctors = doctorService.getAllDoctors();
		return ResponseEntity.ok(doctors);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
		Doctor doctor = doctorService.getDoctorById(id);
		return ResponseEntity.ok(doctor);
	}
	
	@PutMapping
	public ResponseEntity<Doctor> update(@RequestBody Doctor updated, @RequestParam Long id) {
		Doctor doctor = doctorService.update(id, updated);
		return ResponseEntity.ok(doctor);
	}
	
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestParam Long id) {
		doctorService.deleteDoctor(id);
		return ResponseEntity.ok("deleted");
	}

}
