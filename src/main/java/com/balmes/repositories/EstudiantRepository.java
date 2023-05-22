package com.balmes.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.balmes.model.Estudiant;
import org.springframework.stereotype.Repository;
@Repository
public interface EstudiantRepository extends JpaRepository<Estudiant, Integer> {
}
