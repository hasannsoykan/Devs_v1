package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {
	void add(Language language) throws Exception;
	void delete(Language language);
	void update(Language language, String name) throws Exception;
	List<Language> getAll();
	Language getById(int id);
}
