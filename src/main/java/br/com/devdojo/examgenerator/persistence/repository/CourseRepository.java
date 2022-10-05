package br.com.devdojo.examgenerator.persistence.repository;

import br.com.devdojo.examgenerator.persistence.model.Course;
import br.com.devdojo.examgenerator.persistence.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select c from Course c where c.id =?1 and c.professor = ?#{principal.professor}")
    Course findOne(Long id);

    @Query("select c from Course  c where c = ?1 and c.professor = ?#{principal.professor}")
    Course findOne(Course course);

    @Query("select c from Course c where c.name like %?1% and " +
            "c.professor = ?#{principal.professor}")
    List<Course> listCourses(String name);

}
