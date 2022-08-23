package com.examen.nach.crud.interfaces;
import com.examen.nach.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenderRepository extends JpaRepository<GenderEntity,Long> {

}
