package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
