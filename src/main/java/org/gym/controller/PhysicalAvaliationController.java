package org.gym.controller;

import java.util.List;

import org.gym.entity.PhysicalAvaliation;
import org.gym.entity.form.PhysicalAvaliationForm;
import org.gym.entity.form.PhysicalAvaliationUpdateForm;
import org.gym.handler.PhysicalAvaliationNotFoundException;
import org.gym.handler.StudentNotFoundException;
import org.gym.service.impl.PhysicalAvaliationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliations")
public class PhysicalAvaliationController {
	private final PhysicalAvaliationService service;

	public PhysicalAvaliationController(
			final PhysicalAvaliationService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Object> avaliate(
			PhysicalAvaliationForm form) {
		try {
		  return ResponseEntity.ok(service.create(form));
		} catch(StudentNotFoundException e) {
			System.out.println(e);
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public List<PhysicalAvaliation> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> get(@RequestParam Long id) {
		try {
			return ResponseEntity.ok(service.get(id));
		} catch (PhysicalAvaliationNotFoundException e) {
			System.out.println(e);
			return ResponseEntity.notFound().build();
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Object> update(
			@RequestParam Long id,
			@RequestBody PhysicalAvaliationUpdateForm form) {
		try {
		  return ResponseEntity.ok(service.update(id, form));
		} catch(PhysicalAvaliationNotFoundException e) {
			System.out.println(e);
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@RequestParam Long id) {
		try {
			service.delete(id);
			return ResponseEntity.ok(null);
		} catch(PhysicalAvaliationNotFoundException e) {
			System.out.println(e);
			return ResponseEntity.notFound().build();
		}
	}
}
