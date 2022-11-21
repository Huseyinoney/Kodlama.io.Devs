package Kodlama.io.devs.business.abstracts;

import java.util.List;

import Kodlama.io.devs.business.requests.technologies.CreateTechnologyRequest;
import Kodlama.io.devs.business.requests.technologies.DeleteTechnologyRequest;
import Kodlama.io.devs.business.requests.technologies.UpdateTechnologyRequest;
import Kodlama.io.devs.business.responses.GetAllTechnologyResponse;

public interface TechnologyService {
	List<GetAllTechnologyResponse> getAll();
	
	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	
	void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception;
	
	void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception;
}

