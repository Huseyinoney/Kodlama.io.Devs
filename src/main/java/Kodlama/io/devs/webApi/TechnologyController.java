package Kodlama.io.devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.devs.business.abstracts.TechnologyService;
import Kodlama.io.devs.business.requests.technologies.CreateTechnologyRequest;
import Kodlama.io.devs.business.requests.technologies.DeleteTechnologyRequest;
import Kodlama.io.devs.business.requests.technologies.UpdateTechnologyRequest;
import Kodlama.io.devs.business.responses.GetAllTechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
	
	private TechnologyService technologyService;
	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getall")
    public List<GetAllTechnologyResponse> getAll(){
        return technologyService.getAll();
    }

	
	 @PostMapping("/add")
	    public void create(@RequestBody() CreateTechnologyRequest createTechnologyRequest) throws Exception {
	        technologyService.add(createTechnologyRequest);
	}
	 
	 
	 @PutMapping("/update")
	    public void update(@RequestBody() UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
	        technologyService.update(updateTechnologyRequest);
	    }
	 
	 
	 @DeleteMapping("/id")
	    public void delete(@RequestBody() DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
	        technologyService.delete(deleteTechnologyRequest);
	    }
	 
	 
}