package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public void add(Language language) throws Exception {
		boolean empty = language.getName().isEmpty();
		if( empty == true) {
			throw new Exception("Program ismi yazilmalidir.");
		}else if(languageRepository.getAll().contains(language)) {
			throw new Exception("Bu dil daha once kaydedilmistir.");
		}else {
			languageRepository.add(language);
		}
	}

	@Override
	public void delete(Language language) {
		languageRepository.delete(language);
		
	}

	@Override
	public void update(Language language, String name) throws Exception {
		if(languageRepository.getAll().contains(language)) {
			throw new Exception("Bu dil daha once kaydedilmistir.");
		}
		languageRepository.update(language, name);
		
	}

	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public Language getById(int id) {
		return languageRepository.getById(id);
	}

}
