package com.formacion.block7crudvalidationparte1.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFullOutputDto {

    private Integer idPerson;
    private String usuario;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private boolean active;
    private Date createdDate;
    private String imageUrl;
    private Date terminationDate;

    public void setIdStudent(Integer idStudent) {
    }

    public void setNumHoursWeek(int numHoursWeek) {
    }

    public void setComments(String comments) {
    }
}
