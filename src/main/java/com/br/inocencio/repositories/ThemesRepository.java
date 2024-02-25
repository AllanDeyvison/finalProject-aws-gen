package com.br.inocencio.repositories;

import com.br.inocencio.models.Themes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemesRepository extends JpaRepository<Themes, Integer> {
}
