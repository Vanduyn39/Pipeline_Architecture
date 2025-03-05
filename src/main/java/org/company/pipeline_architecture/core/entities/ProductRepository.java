package org.company.pipeline_architecture.core.entities;

import org.company.pipeline_architecture.core.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
