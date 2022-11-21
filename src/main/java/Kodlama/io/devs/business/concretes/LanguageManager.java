package Kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Kodlama.io.devs.business.abstracts.LanguageService;
import Kodlama.io.devs.business.requests.languages.CreateLanguageRequest;
import Kodlama.io.devs.business.requests.languages.UpdateLanguageRequest;
import Kodlama.io.devs.business.responses.GetAllLanguageResponse;
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
	public List<GetAllLanguageResponse> getAll() {
		
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponse> languageResponse=new ArrayList<GetAllLanguageResponse>();
		
		for(Language language: languages)
		{
			GetAllLanguageResponse responseItem=new GetAllLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languageResponse.add(responseItem);
		}
		
		return languageResponse;
	}


	@Override
	public Optional<Language> getById(int id) throws Exception {
		try {
			 	return  languageRepository.findById(id);
			}
		
		catch(Exception e) 
		{	
			System.out.println(e);
			return null;
			 
		}
			
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception{
		
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		
		languageRepository.save(language);
	}

	@Override
	public void delete(int id)throws Exception {
		
		languageRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest)throws Exception {
		
		Language language=languageRepository.findById(updateLanguageRequest.getId()).get();
		
		language.setName(updateLanguageRequest.getName());
		languageRepository.save(language);	
		
		
	}
	
}
