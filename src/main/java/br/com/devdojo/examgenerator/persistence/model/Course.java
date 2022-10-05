package br.com.devdojo.examgenerator.persistence.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Course extends AbstractEntity{

    @NotEmpty(message = "The field name cannot be emtpy")
    @ApiModelProperty(notes = "The name of the couse")
    private String name;
    @ManyToOne(optional = false)
    private Professor professor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
