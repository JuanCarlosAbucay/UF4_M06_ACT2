package com.balmes.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.balmes.model.Curs;
import org.springframework.stereotype.Repository;
@Repository
public interface CursRepository extends JpaRepository<Curs, Integer> {

}
