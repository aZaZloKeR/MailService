package com.azazland.mailservice.db.repository;

import com.azazland.mailservice.db.model.MailingData;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;

@PersistenceContext(unitName = "mailService")
public interface MailingDataRepo extends CrudRepository<MailingData, Integer> {
    Iterable<MailingData> findAllByMessageId(int MessageId);
}
