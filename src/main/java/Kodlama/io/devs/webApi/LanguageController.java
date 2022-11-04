package Kodlama.io.devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.devs.business.abstracts.LanguageService;
import Kodlama.io.devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	
	private LanguageService languageService;
	
	@Autowired
	public LanguageController(LanguageService langaugeService) {
		super();
		this.languageService = langaugeService;
	}
	
	 @GetMapping("/getall")
	    public List<Language> getAll(){
	        return languageService.getAll();
	    }
	
	 @GetMapping("/{id}")
	    public Language getById(@PathVariable() int id) throws Exception{
	        return languageService.getById(id);
	    }
	 
	 @PostMapping("/add")
	    public void create(@RequestBody Language language) throws Exception {
	        languageService.add(language);
	    }

	    @PutMapping("/update")
	    public void update(@RequestBody String name,@PathVariable int id) throws Exception {
	        languageService.update(id,name);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable(name = "id") int id) throws Exception {
	        languageService.delete(id);
	    }
}
