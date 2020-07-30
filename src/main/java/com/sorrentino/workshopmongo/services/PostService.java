package com.sorrentino.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorrentino.workshopmongo.domain.Post;
import com.sorrentino.workshopmongo.repository.PostRepository;
import com.sorrentino.workshopmongo.repository.UserRepository;
import com.sorrentino.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Post user = repo.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}

}
