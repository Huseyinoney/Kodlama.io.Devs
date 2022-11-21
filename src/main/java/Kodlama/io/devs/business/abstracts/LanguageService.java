package Kodlama.io.devs.business.abstracts;

import java.util.List;
import java.util.Optional;

import Kodlama.io.devs.business.requests.languages.CreateLanguageRequest;
import Kodlama.io.devs.business.requests.languages.UpdateLanguageRequest;
import Kodlama.io.devs.business.responses.GetAllLanguageResponse;
import Kodlama.io.devs.entities.concretes.Language;

public interface LanguageService {
	
	List<GetAllLanguageResponse> getAll();
	void add(CreateLanguageRequest createLanguageRequest) throws Exception;
	void delete(int id) throws Exception;
	void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
	Optional<Language> getById(int id) throws Exception;
}
