package kodlama.io.Devs.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	
	private LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Language language) throws Exception {
		languageService.add(language);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody Language language) {
		languageService.delete(language);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Language language, @RequestParam String name) throws Exception {
		languageService.update(language, name);
	}
	
	@GetMapping("/getall")
	public List<Language> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getid/{id}")
	public Language getById(@PathVariable int id) {
		return languageService.getById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
