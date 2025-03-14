package org.example.quanlytuyendung.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.quanlytuyendung.dto.request.LineRequest;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JobPositionResponse {
    private Integer id;
    private String code;
    private String name;
    private IndustryResponse industry;
    private List<LineResponse> lines;
    private String description;
    private Boolean isActive;

    public JobPositionResponse(int id) {
        this.id = id;
    }
}
