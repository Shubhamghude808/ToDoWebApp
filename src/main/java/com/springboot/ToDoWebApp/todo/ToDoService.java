package com.springboot.ToDoWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ToDoService {
	private static List<ToDo> toDos = new ArrayList<>();

	private static int todoCount = 0;
	static {
		toDos.add(new ToDo(++todoCount, "Shubham", "Learn AWS 1", LocalDate.now().plusYears(1), false));
		toDos.add(new ToDo(++todoCount, "Anish", "Learn Stack 1", LocalDate.now().plusYears(2), false));
		toDos.add(new ToDo(++todoCount, "Shubham", "Learn Azure 1", LocalDate.now().plusYears(3), false));
	}

	public List<ToDo> findByUsername(String username) {
		Predicate<? super ToDo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return toDos.stream().filter(predicate).toList();
	}

	public void addTodo(String username, String description, LocalDate targetdDate, Boolean done) {
		ToDo toDo = new ToDo(++todoCount, username, description, targetdDate, done);
		toDos.add(toDo);
	}

	public void deleteById(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		toDos.removeIf(predicate);
	}

	public ToDo findById(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		ToDo toDo = toDos.stream().filter(predicate).findFirst().get();
		return toDo;
	}

	public void updatetoDo(@Valid ToDo toDo) {
		deleteById(toDo.getId());
		toDos.add(toDo);
	}
}
