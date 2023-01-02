package com.example.events.dao;

import com.example.events.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingJpa extends JpaRepository<BookingModel, Long> {
}
