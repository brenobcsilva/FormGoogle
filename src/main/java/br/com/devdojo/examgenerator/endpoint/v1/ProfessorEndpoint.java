package br.com.devdojo.examgenerator.endpoint.v1;

import br.com.devdojo.examgenerator.persistence.model.Professor;
import br.com.devdojo.examgenerator.persistence.repository.ProfessorRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("v1/professor")

public class ProfessorEndpoint {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorEndpoint(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @GetMapping
    public ResponseEntity<?> hi(){
        return new ResponseEntity<>("Hi", HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    @ApiOperation(value = "Find professor by his ID", notes = "We have to method better", response = Professor.class)
    public ResponseEntity<?> getProfessorById(@PathVariable long id){
        Professor professor = professorRepository.findOne(id);
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }

}
