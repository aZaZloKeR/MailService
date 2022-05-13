package com.azazland.mailservice.db.repository;

import com.azazland.mailservice.db.model.Messages;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;

public interface MessagesRepo extends CrudRepository<Messages,Integer> {

}
