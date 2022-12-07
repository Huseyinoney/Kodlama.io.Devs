package Kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.devs.business.abstracts.TechnologyService;
import Kodlama.io.devs.business.requests.technologies.CreateTechnologyRequest;
import Kodlama.io.devs.business.requests.technologies.DeleteTechnologyRequest;
import Kodlama.io.devs.business.requests.technologies.UpdateTechnologyRequest;
import Kodlama.io.devs.business.responses.GetAllTechnologyResponse;
import Kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.devs.entities.concretes.Language;
import Kodlama.io.devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyRepository technologyRepository;
	private LanguageRepository languageRepository;
	
	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
		super();
		this.technologyRepository = technologyRepository;
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponse> technologyResponses = new ArrayList<GetAllTechnologyResponse>();
		
		for(Technology technology : technologies) {
			GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
			
			responseItem.setId(technology.getTechnologyId());
			responseItem.setTechnologyName(technology.getTechnologyName());
			responseItem.setLanguageName(technology.getLanguage().getName());
			technologyResponses.add(responseItem);
		}
		return technologyResponses;
	}
	

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		
		Technology technology = new Technology();
		
		Language language =languageRepository.findById(createTechnologyRequest.getLanguageId()).get();
		
		//System.out.println(language);
		technology.setTechnologyName(createTechnologyRequest.getTechnologyName());
		technology.setLanguage(language);
		technologyRepository.save(technology);
		
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
		
		technologyRepository.deleteById(deleteTechnologyRequest.getId());
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		
		Technology technology = new Technology();
		technologyRepository.findById(updateTechnologyRequest.getTechnologyId());
		technology.setTechnologyName(updateTechnologyRequest.getName());
		
		technologyRepository.save(technology);
	}

}
