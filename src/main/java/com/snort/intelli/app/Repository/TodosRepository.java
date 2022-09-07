package com.snort.intelli.app.Repository;

import com.snort.intelli.app.Entities.Todos;
import org.springframework.data.repository.CrudRepository;

public interface TodosRepository extends CrudRepository<Todos,Long> {
}
