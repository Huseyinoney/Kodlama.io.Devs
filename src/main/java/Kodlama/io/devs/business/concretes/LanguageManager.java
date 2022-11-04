package Kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.devs.business.abstracts.LanguageService;
import Kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	
	
	private LanguageRepository languageRepository;
	
	
	public LanguageManager(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {
		
		return languageRepository.getAll();
	}

	@Override
	public void add(Language language) {
		
		languageRepository.add(language);
		
	}

	@Override
	public void delete(int id) {
		
		languageRepository.delete(id);
	}

	@Override
	public void update(int id, String name) {
		
		languageRepository.update(id, name);
	}

	@Override
	public Language getById(int id) throws Exception {
		
		return languageRepository.getById(id);
		
	}
	
}
