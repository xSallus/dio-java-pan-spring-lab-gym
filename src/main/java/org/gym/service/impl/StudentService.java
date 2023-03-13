package org.gym.service.impl;

import java.util.List;

import org.gym.entity.PhysicalAvaliation;
import org.gym.entity.Student;
import org.gym.entity.form.StudentCreateForm;
import org.gym.entity.form.StudentUpdateForm;
import org.gym.repository.StudentsRepository;
import org.gym.service.IStudentService;

import org.springframework.stereotype.Service;

import net.bytebuddy.matcher.SubTypeMatcher;

@Service
public class StudentService implements IStudentService {
	private final StudentsRepository repository;

	public StudentService(final StudentsRepository repository) {
		this.repository = repository;
	}

	@Override
	public Student create(StudentCreateForm form) {
		Student student = new Student();
		student.setName(form.getName());
		student.setCpf(form.getCpf());
		student.setNeighborhood(form.getNeighborhood());
		student.setBirthDate(form.getBirthDate());
		return repository.save(student);
	}

	@Override
	public Student get(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Student> getAll() {
		return repository.findAll();
	}

	@Override
	public List<PhysicalAvaliation> getAllAvaliationById(Long id) {
		return null;
	}

	@Override
	public Student update(Long id, StudentUpdateForm form) {
		return null;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
