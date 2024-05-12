package com.Assistants.repository;

import com.Assistants.entity.Assistants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistantsRepository extends JpaRepository<Assistants, String> {

}
