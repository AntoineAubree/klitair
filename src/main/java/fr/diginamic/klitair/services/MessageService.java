/**
 * 
 */
package fr.diginamic.klitair.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.entity.Message;
import fr.diginamic.klitair.exceptions.BadRequestException;
import fr.diginamic.klitair.repository.MessageRepository;

/**
 * @author StephanieMC
 *
 */
@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepository;

	public Message create(Message message) {
		return messageRepository.save(message);
	}

	public List<Message> findByDiscussionThread(Long id) {
		return messageRepository.findByDiscussionThread_Id(id);
	}
	
	public List<Message> findByUser(Long id) {
		return messageRepository.findByUser_Id(id);
	}


	public Message update(Message message) {
		if (message.getId() == null || messageRepository.findById(message.getId()).isEmpty()) {
			throw new BadRequestException();
		}
		return messageRepository.save(message);
	}

	public void deleteById(Long id) {
		if (id == null || messageRepository.findById(id).isEmpty()) {
			throw new BadRequestException();
		}
		messageRepository.deleteById(id);
	}



}
