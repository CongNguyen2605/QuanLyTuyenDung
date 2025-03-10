package org.example.quanlytuyendung.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailTemplateResponse {
    private Integer id;
    private String name;

    private String title;
    private String content;

    public EmailTemplateResponse(Integer id) {
        this.id = id;
    }
}
