package com.springboot.ToDoWebApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class ToDoControllerJpa {
	// list-todos
	private ToDoRepository toDoRepository;

	public ToDoControllerJpa(ToDoRepository toDoRepository) {
		super();
		this.toDoRepository = toDoRepository;
	}

	@RequestMapping("list-todos")
	public String listAlltodos(ModelMap model) {
		String username = getLoggedinUsername(model);
		List<ToDo> toDos = toDoRepository.findByUsername(username);
		model.addAttribute("toDos", toDos);
		return "listTodos";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedinUsername(model);
		ToDo toDo = new ToDo(0, username, "", LocalDate.now(), false);
		model.put("toDo", toDo);
		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid ToDo toDo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		String username = getLoggedinUsername(model);
		toDo.setUsername(username);
		toDoRepository.save(toDo);
//		toDoService.addTodo(username, toDo.getDescription(), toDo.getTargetDate(), false);
		return "redirect:list-todos";
	}

	@RequestMapping("delete-todo")
	public String deletetoDo(@RequestParam int id) {
		toDoRepository.deleteById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdatetoDo(@RequestParam int id, ModelMap model) {
		ToDo toDo = toDoRepository.findById(id).get();
		model.addAttribute("toDo", toDo);
		return "todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updatetoDo(ModelMap model, @Valid ToDo toDo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		String username = getLoggedinUsername(model);
		toDo.setUsername(username);
		toDoRepository.save(toDo);
		return "redirect:list-todos";
	}

	private String getLoggedinUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
