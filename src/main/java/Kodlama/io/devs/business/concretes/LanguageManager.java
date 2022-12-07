package Kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.devs.business.abstracts.LanguageService;
import Kodlama.io.devs.business.requests.languages.CreateLanguageRequest;
import Kodlama.io.devs.business.requests.languages.UpdateLanguageRequest;
import Kodlama.io.devs.business.responses.GetAllLanguageResponse;
import Kodlama.io.devs.business.responses.GetAllTechnologyResponse;
import Kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.devs.entities.concretes.Language;
import Kodlama.io.devs.entities.concretes.Technology;

@Service
public class LanguageManager implements LanguageService {
	
	
	private LanguageRepository languageRepository;
	private TechnologyRepository technologyRepository;
	
	
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository,TechnologyRepository technologyRepository) {
		super();
		this.languageRepository = languageRepository;
		this.technologyRepository =technologyRepository;
		
	}

	@Override
	public List<GetAllLanguageResponse> getAll() {
		
		List<Language> languages = languageRepository.findAll();
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllLanguageResponse> getAllLanguageResponse = new ArrayList<GetAllLanguageResponse>();
		
		for(Language language :languages ) {
			List<GetAllTechnologyResponse> technologyResponses = new ArrayList<GetAllTechnologyResponse>();
			GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			
			
			for(Technology technology : technologies) {
				
				if(language.getId() == technology.getLanguage().getId()) {
					 GetAllTechnologyResponse addItem = new GetAllTechnologyResponse();
					 
					 addItem.setId(technology.getTechnologyId());
					 addItem.setTechnologyName(technology.getTechnologyName());
					 addItem.setLanguageName(technology.getLanguage().getName());
					 
					 technologyResponses.add(addItem);
					responseItem.setTechnologies(technologyResponses);
					getAllLanguageResponse.add(responseItem);
				}
				else {
					//getAllLanguageResponse.add(responseItem);
				}
			}
			
		}
		
		
		return getAllLanguageResponse;
	}


	@Override
	public Language getById(int id) throws Exception {
		List<Language> languages = languageRepository.findAll();
		Language languageFound = new Language();
		for(Language language: languages)
		{
			if(language.getId()== id) {
			
			languageFound.setId(language.getId());
			languageFound.setName(language.getName());
			languageFound.setTechnologies(language.getTechnologies());
			return languageFound;
		}
		
		}
		return null;
	
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
