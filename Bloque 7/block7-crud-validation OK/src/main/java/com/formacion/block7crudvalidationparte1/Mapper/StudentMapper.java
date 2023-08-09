package com.formacion.block7crudvalidationparte1.Mapper;

import com.formacion.block7crudvalidationparte1.Entity.Person;
import com.formacion.block7crudvalidationparte1.Entity.Profesor;
import com.formacion.block7crudvalidationparte1.Entity.Student;
import com.formacion.block7crudvalidationparte1.Excepciones.EntityNotFoundException;
import com.formacion.block7crudvalidationparte1.Repository.ProfesorRepository;
import com.formacion.block7crudvalidationparte1.Servicios.PersonService;
import com.formacion.block7crudvalidationparte1.dto.PersonInputDto;
import com.formacion.block7crudvalidationparte1.dto.ProfesorInputDto;
import com.formacion.block7crudvalidationparte1.dto.StudentInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StudentMapper {

        @Autowired
        private PersonService personService;
        @Autowired
        private ProfesorRepository profesorRepository;

        public Student toEntity(StudentInputDto studentInputDto) {
            Student student = new Student();
            student.setIdStudent(studentInputDto.getIdStudent());


            Person person = personService.searchById(studentInputDto.getIdPerson());
            student.setPerson(person);

            student.setNumHoursWeek(studentInputDto.getNumHoursWeek());
            student.setComments(studentInputDto.getComments());


            if (studentInputDto.getIdProfesor() != null) {
                Profesor profesor = profesorRepository.findById(studentInputDto.getIdProfesor())
                        .orElseThrow(() -> new EntityNotFoundException("Profesor with id " + studentInputDto.getIdProfesor() + " not found"));
                student.setProfesor(profesor);
            }

            student.setBranch(studentInputDto.getBranch());

            return student;
        }

        public StudentInputDto toDTO(Student student) {
            StudentInputDto studentInputDto = new StudentInputDto();
            studentInputDto.setIdStudent(student.getIdStudent());
            studentInputDto.setIdPerson(student.getPerson().getIdPerson());
            studentInputDto.setNumHoursWeek(student.getNumHoursWeek());
            studentInputDto.setComments(student.getComments());

            // Mapear el ID del profesor a StudentDTO
            if (student.getProfesor() != null) {
                studentInputDto.setIdProfesor(student.getProfesor().getIdProfesor());
            }

            studentInputDto.setBranch(student.getBranch());

            return studentInputDto;
        }

        private PersonInputDto convertToDTO(Person person) {
            PersonInputDto personInputDto = new PersonInputDto();
            personInputDto.setIdPerson(person.getIdPerson());
            personInputDto.setUsuario(person.getUsuario());
            personInputDto.setPassword(person.getPassword());
            personInputDto.setName(person.getName());
            personInputDto.setSurname(person.getSurname());
            personInputDto.setCompanyEmail(person.getCompanyEmail());
            personInputDto.setPersonalEmail(person.getPersonalEmail());
            personInputDto.setCity(person.getCity());
            personInputDto.setActive(person.isActive());
            personInputDto.setCreatedDate(Date.from(person.getCreatedDate()));
            personInputDto.setImageUrl(person.getImageUrl());
            personInputDto.setTerminationDate(Date.from(person.getTerminationDate()));

            return personInputDto;
        }

        private ProfesorInputDto convertToDTO(Profesor profesor) {
            ProfesorInputDto profesorInputDto = new ProfesorInputDto();
            if (profesor != null) {
                profesorInputDto.setIdProfesor(profesor.getIdProfesor());
                profesorInputDto.setIdPerson(profesor.getPerson().getIdPerson());
                profesorInputDto.setComments(profesor.getComments());
                profesorInputDto.setBranch(profesor.getBranch());
            }
            return profesorInputDto;
        }

}
