package org.example.quanlytuyendung.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CandicateSourceResponse {
    private Integer id;
    private String name;
    private String code;
    private Boolean isActive;
    private String description;
    public CandicateSourceResponse(Integer id) {
        this.id = id;
    }

    public CandicateSourceResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
