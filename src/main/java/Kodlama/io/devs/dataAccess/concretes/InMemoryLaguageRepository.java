package Kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.devs.entities.concretes.Language;

@Repository
public class InMemoryLaguageRepository implements LanguageRepository {
	List<Language> languages;

	public InMemoryLaguageRepository() {
        languages = new ArrayList<Language>();
        languages.add(new Language(1,"Java"));
        languages.add(new Language(2,"JavaScript"));
        languages.add(new Language(3,"C#"));
        languages.add(new Language(4,"Python"));
        languages.add(new Language(5, "Go"));
    }
	
	@Override
	public List<Language> getAll() {
		
		return languages;
	}

	@Override
	public void add(Language language) {
		languages.add(language);
		
	}

	@Override
	public void delete(int id) {
		
		for(Language  language: languages) {
			if(language.getId()==id) {
				
				languages.remove(id);
			}
			else {
				System.out.println("Böyle bir kayıt bulunamadı");
			}
			
		}
		
	}

	@Override
	public void update(int id, String name) {
		
		for(Language  language: languages) {
			if(language.getId()==id) {
				
				language.setName(name);
			}
			else {
				System.out.println("Böyle bir kayıt bulunamadı");
			}
			
		}
		
		
	}

	@Override
	public Language getById(int id) throws Exception {
		
		for(Language language : languages) {
			if(language.getId()==id) {
				
				return language;
			}
			else {
				throw new Exception("Böyle bir kayıt bulunamadı");
			}
			}
			
		throw new Exception("Böyle bir kayıt bulunamadı");
		
	}
	
}
