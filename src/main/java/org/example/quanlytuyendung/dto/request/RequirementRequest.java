package org.example.quanlytuyendung.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequirementRequest {
    private Integer id;
    private String name;
    private String description;
    private Boolean isActive;
    private DepartmentRequest department;

}
