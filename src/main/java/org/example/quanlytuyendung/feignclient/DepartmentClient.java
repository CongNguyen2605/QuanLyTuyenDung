package org.example.quanlytuyendung.feignclient;

import org.example.quanlytuyendung.dto.response.ApiResponse;
import org.example.quanlytuyendung.dto.response.DepartmentResponse;
import org.example.quanlytuyendung.config.FeignClientConfiguration;
import org.example.quanlytuyendung.dto.response.PageableResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "resource-service", url = "https://resources-service.dev.apusplatform.com/api/v1/department")
public interface DepartmentClient {
    @GetMapping("/list")
    ApiResponse<PageableResponse<DepartmentResponse>> getDepartmentsByIds(@RequestParam("ids") List<Integer> ids);
}


