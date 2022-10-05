package br.com.devdojo.examgenerator.endpoint.v1.course;

import br.com.devdojo.examgenerator.persistence.model.ApplicationUser;
import br.com.devdojo.examgenerator.persistence.model.Course;
import br.com.devdojo.examgenerator.persistence.repository.CourseRepository;
import br.com.devdojo.examgenerator.util.EndpointUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/professor/course")
@Api(description = "Operatations related to professors course")
public class CourseEndpoint {

    private final CourseRepository courseRepository;
    private final EndpointUtil endpointUtil;

    private final CourseService courseService;
    @Autowired
    public CourseEndpoint(CourseRepository courseRepository, EndpointUtil endpointUtil, CourseService courseService) {
        this.courseRepository = courseRepository;
        this.endpointUtil = endpointUtil;
        this.courseService = courseService;
    }

    @ApiOperation(value = "Return a course based on its id", response = Course.class)
    @GetMapping(path = "{id}")
    public ResponseEntity<?> getCourseById(@PathVariable long id){
        return endpointUtil.returnObjectOrNotFound(courseRepository.findOne(id));
    }

    @ApiOperation(value = "Return a list of courses related to professor", response = Course.class)
    @GetMapping(path = "list")
    public ResponseEntity<?> listCourses(@ApiParam("Course name") @RequestParam(value = "name", defaultValue = "") String name){
        return endpointUtil.returnObjectOrNotFound(courseRepository.listCourses(name));
    }

    @ApiOperation(value = "Delete a specific course and return 200 ok with no body")
    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        courseService.throwResourceNotFoundIfCourseDoesNotExists(id);
        courseRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Update a specific course and return 200 ok with no body")
    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody Course course){
        courseService.throwResourceNotFoundIfCourseDoesNotExists(course);
        courseRepository.save(course);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Create course and return the course created")
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Course course){
        course.setProfessor(endpointUtil.extractProfessorFromToken());
        return new ResponseEntity<>(courseRepository.save(course), HttpStatus.OK);
    }

}
