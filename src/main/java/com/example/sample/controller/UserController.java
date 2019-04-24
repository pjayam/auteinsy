package com.example.sample.controller;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.entity.User;
import com.example.sample.repository.UserRepository;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public @ResponseBody Object getList() throws IOException {
		return null;
	}

	@Autowired
	UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getAllNotes() {
		return userRepository.findAll();
	}

	@PostMapping("/users")
	public User createNote(@Valid @RequestBody User note) {
		TreeMap tm = new TreeMap();
		return userRepository.save(note);
	}

//	@GetMapping("/notes/{id}")
//	public User getNoteById(@PathVariable(value = "id") Long noteId) {
//		return userRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//	}
//
//	@PutMapping("/notes/{id}")
//	public User updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Note noteDetails) {
//
//		User note = userRepository.findById(noteId)
//				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//
//		note.setTitle(noteDetails.getTitle());
//		note.setContent(noteDetails.getContent());
//
//		User updatedNote = userRepository.save(note);
//		return updatedNote;
//	}
//
//	@DeleteMapping("/notes/{id}")
//	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
//		User note = userRepository.findById(noteId)
//				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//
//		userRepository.delete(note);
//
//		return ResponseEntity.ok().build();
//	}

}
