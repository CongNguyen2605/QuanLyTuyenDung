package org.example.quanlytuyendung.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.quanlytuyendung.dto.request.WorkTypeRequest;
import org.example.quanlytuyendung.dto.response.ApiResponse;
import org.example.quanlytuyendung.dto.response.LevelResponse;
import org.example.quanlytuyendung.dto.response.PageableResponse;
import org.example.quanlytuyendung.dto.response.WorkTypeResponse;
import org.example.quanlytuyendung.entity.WorkTypeEntity;
import org.example.quanlytuyendung.mapper.WorkTypeMapper;
import org.example.quanlytuyendung.repository.WorkTypeRepository;
import org.example.quanlytuyendung.service.WorkTypeService;
import org.example.quanlytuyendung.specification.BaseSpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WorkTypeServiceImpl implements WorkTypeService {
    private final WorkTypeRepository workTypeRepository;
    private final WorkTypeMapper workTypeMapper;

    @Override
    public ApiResponse<PageableResponse<WorkTypeResponse>> getWorkTypeList(int page, int size, String search, String sort ) {
        String [] sortParam = sort.split(":");
        String sortField = sortParam[0];
        Sort.Direction sortDirection = sortParam.length > 1 && sortParam[1].equalsIgnoreCase("ASC") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort orders = Sort.by(sortDirection, sortField);
        Pageable pageable = PageRequest.of(page, size, orders);
        Map<String,Object> filters = new HashMap<>();
     if (search != null && !search.isEmpty()) {
         filters.put("name", search);
         filters.put("code", search);
     }
        Specification<WorkTypeEntity> specification = new BaseSpecification<>(filters);
        var result = workTypeRepository.findAll(specification,pageable);
        PageableResponse<WorkTypeResponse> pageableResponse = PageableResponse.<WorkTypeResponse>builder()
                .page(page)
                .size(size)
                .sort(orders.toString())
                .totalPages(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .numberOfElements(result.getNumberOfElements())
                .content(result.getContent().stream().map(workTypeMapper::toResponse).toList())
                .build();

        return new ApiResponse<>(pageableResponse);
    }

    @Override
    public ApiResponse<WorkTypeResponse> addWorkType(WorkTypeRequest workTypeRequest) {
        WorkTypeEntity workTypeEntity = workTypeMapper.toEntity(workTypeRequest);
        workTypeEntity = workTypeRepository.save(workTypeEntity);
        return new ApiResponse<>(new WorkTypeResponse(workTypeEntity.getId()));
    }

    @Override
    public ApiResponse<WorkTypeResponse> updateWorkType(WorkTypeRequest workTypeRequest) {
        WorkTypeEntity workType = workTypeRepository.findById(workTypeRequest.getId()).get();
        workType.setName(workTypeRequest.getName());
        workType.setCode(workTypeRequest.getCode());
        workType.setDescription(workTypeRequest.getDescription());
        workType.setIsActive(workTypeRequest.getIsActive());
        workTypeRepository.save(workType);
        return new ApiResponse<>(new WorkTypeResponse(workType.getId()));
    }

    @Override
    public ApiResponse<WorkTypeResponse> getWorkType(int id) {
        WorkTypeEntity workType = workTypeRepository.findById(id).get();
        return new ApiResponse<>(workTypeMapper.toResponse(workType));
    }

    @Override
    public WorkTypeEntity deleteWorkType(int id) {
       WorkTypeEntity workType = workTypeRepository.findById(id).get();
       workTypeRepository.delete(workType);
        return null;
    }
}
