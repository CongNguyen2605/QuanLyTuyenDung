package org.example.quanlytuyendung.service;

import org.example.quanlytuyendung.dto.request.TagRequest;
import org.example.quanlytuyendung.dto.response.ApiResponse;
import org.example.quanlytuyendung.dto.response.PageableResponse;
import org.example.quanlytuyendung.dto.response.TagResponse;
import org.example.quanlytuyendung.entity.TagEntity;

public interface TagService {
    ApiResponse<PageableResponse<TagResponse>> getAllTag(int page, int size,String search,String sort);

    ApiResponse<TagResponse> addTagg(TagRequest tagRequest);

    ApiResponse<TagResponse> updateTag(TagRequest tagRequest);

    ApiResponse<TagResponse> getTag(int id);

    TagEntity deleteTag(int id);
}
