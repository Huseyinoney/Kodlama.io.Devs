package Kodlama.io.devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.devs.entities.concretes.Language;

public interface LanguageRepository {
	
	
	List<Language> getAll();
	Language getById(int id) throws Exception;
	void add(Language language);
	void delete(int id);
	void update(int id, String name);

}
