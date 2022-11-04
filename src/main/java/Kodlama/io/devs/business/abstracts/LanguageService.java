package Kodlama.io.devs.business.abstracts;

import java.util.List;

import Kodlama.io.devs.entities.concretes.Language;

public interface LanguageService {
	
	List<Language> getAll();
	void add(Language language);
	void delete(int id);
	void update(int id,String name);
	Language getById(int id) throws Exception;
}
