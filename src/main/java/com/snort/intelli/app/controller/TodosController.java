package com.snort.intelli.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.snort.intelli.app.Repository.TodosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.snort.intelli.app.Entities.Todos;

@RestController
//@RequestMapping("/todos") : in case of common http like todos/delete, todos update, todos findall etc
public class TodosController {
	@Autowired
	TodosRepository todosRepository;

	private Logger log = LoggerFactory.getLogger(TodosController.class);

	@PostMapping("/todos/create")
	public Todos createTask(@RequestBody Todos todos) {
		log.info("TodosController : createTask executed!");
		return todosRepository.save(todos);
	}



	@GetMapping("/todos")
	public List<Todos> findAll() {
		log.info("Todos controller : Findall Task executed");
		return (List<Todos>) todosRepository.findAll();

	}

	@GetMapping("/todos/{id}")
	public Todos findOneTodo(@PathVariable Long id) {
		log.info("Todos controller : FindOne Task executed");
		Optional<Todos> todos=todosRepository.findById(id);
		//return todos.get(); //to return system defined exception if id not found
	//	return todos.orElse(new Todos());   //if failed the empty object will be created
		return todos.orElseThrow(() ->{
			return  new RuntimeException("no Todos found in given id : "+id);
		});
	}

	@DeleteMapping("/todos/delete/{id}")
	public String deleteOneTodo(@PathVariable Long id) {
		log.info("Todos controller : deleteOne Task executed");
		try {
			todosRepository.deleteById(id);
			return  "Todos successfully deleted with id:"+id;
		}catch (Exception e){
			return "Todos with id-->"+id+" failed to delete";
		}

	}

	@PutMapping("/todos/update/{id}")
	public Todos updateOneTodos(@PathVariable Long id, @RequestBody Todos newtodos) {
		log.info("Todos controller : update  Task executed");
		newtodos.setTaskId(id);
		newtodos.setUpdatedDate(new Date());
		if (todosRepository.existsById(id)){
				return todosRepository.save(newtodos);

		}return new Todos();

	}
	@PatchMapping("/todos/update/{id}")
	public Todos Update(@PathVariable Long id, @RequestBody Todos newtodos) {
		log.info("Todos controller : update  Task executed");
		newtodos.getTaskId();
		newtodos.setUpdatedDate(new Date());
		if (todosRepository.existsById(id)){
			return todosRepository.save(newtodos);

		}return new Todos();

	}

}
