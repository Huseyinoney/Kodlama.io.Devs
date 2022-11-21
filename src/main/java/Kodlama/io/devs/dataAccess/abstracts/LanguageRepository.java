package Kodlama.io.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.devs.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
	
	
}
