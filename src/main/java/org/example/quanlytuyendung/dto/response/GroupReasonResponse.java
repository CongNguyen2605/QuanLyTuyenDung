package org.example.quanlytuyendung.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupReasonResponse {
    private Integer id;
    private String code;
    private String name;
    private String description;
    private Boolean isActive;

    public GroupReasonResponse(Integer id) {
        this.id = id;
    }

    public GroupReasonResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
