package Kodlama.io.devs.business.responses;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageResponse {

	
	private int id;
	private String name;
	private List<GetAllTechnologyResponse> technologies;
	
}
