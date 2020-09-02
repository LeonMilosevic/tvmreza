package com.tvmreza.api.services.post;

import com.tvmreza.api.controller.post.dto.PostDtoRequest;
import com.tvmreza.api.entities.Post;

public interface PublicPostService {

	Post createPost(PostDtoRequest postDtoRequest) throws Exception;

}
