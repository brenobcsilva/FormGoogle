package br.com.devdojo.examgenerator.endpoint.v1.course;

import br.com.devdojo.examgenerator.exception.ResourceNotFoundException;
import br.com.devdojo.examgenerator.persistence.model.Course;
import br.com.devdojo.examgenerator.persistence.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void throwResourceNotFoundIfCourseDoesNotExists(Course course){
        if(course == null || course.getId() == null || courseRepository.findOne(course.getId())==null)
            throw new ResourceNotFoundException("Course not found");
    }

    public void throwResourceNotFoundIfCourseDoesNotExists(long courseId){
        if(courseId == 0 || courseRepository.findOne(courseId)==null)
            throw new ResourceNotFoundException("Course not found");
    }

}
