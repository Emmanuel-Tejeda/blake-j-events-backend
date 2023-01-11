package com.example.events.dao;

import com.example.events.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventJpa extends JpaRepository<EventModel, Long> {
}
