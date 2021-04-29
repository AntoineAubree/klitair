package fr.diginamic.klitair.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.entity.PostCode;
import fr.diginamic.klitair.exceptions.BadRequestException;
import fr.diginamic.klitair.repository.PostCodeRepository;

@Service
public class PostCodeService {

	@Autowired
	private PostCodeRepository postCodeRepository;

	public PostCode insert(String postCode) {
		Optional<PostCode> postCodeOptional = postCodeRepository.findByCode(postCode);
		if (postCodeOptional.isEmpty()) {
			return postCodeRepository.save(new PostCode(postCode));
		} else {
			return postCodeOptional.orElseThrow();
		}
	}

	public PostCode findByCode(String postCode) {
		return postCodeRepository.findByCode(postCode).orElseThrow(() -> new BadRequestException());
	}

}
