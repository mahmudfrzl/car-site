package com.me.carsite.repositories;

import com.me.carsite.dtos.ModelDto;
import com.me.carsite.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ModelRepo extends JpaRepository<Model,Long> {


    @Query("Select new com.me.carsite.dtos.ModelDto(m.id,m.name,m.marka.id ) From Model m where m.marka.id=:markaId")//marka id-sine gore getir
    List<ModelDto> getByMarkaId(Long markaId);
}
