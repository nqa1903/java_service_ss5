package com.rikkeiedu.ss4.repository;

import com.rikkeiedu.ss4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// repository la noi giao tiep voi db
// giup : lay , them , xoa , cap nhat du lieu
public interface ProductRepository extends JpaRepository<Product , Long> {
}
