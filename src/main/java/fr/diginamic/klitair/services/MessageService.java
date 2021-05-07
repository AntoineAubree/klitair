/**
 * 
 */
package fr.diginamic.klitair.services;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.dto.MessageDto;
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
	private MessageRepository messageRepository;

	@Autowired
	private ModelMapper modelMapper;

	public MessageDto create(MessageDto messageDto) {
		checkIfUserValide(messageDto);
		return saveDiscussionThread(messageDto);
	}

	public MessageDto update(MessageDto messageDto) {
		checkIfUserValide(messageDto);
		checkIfMessageExist(messageDto.getId());
		return saveDiscussionThread(messageDto);
	}

	private MessageDto saveDiscussionThread(MessageDto messageDto) {
		Message message = modelMapper.map(messageDto, Message.class);
		if (message.getDate() == null) {
			message.setDate(LocalDateTime.now());
		}
		message = messageRepository.save(message);
		return modelMapper.map(message, MessageDto.class);
	}

	public Page<MessageDto> findByDiscussionThread(Long id, int index, int limit) {
		Page<Message> messages = messageRepository.findByDiscussionThread_Id(id,
				PageRequest.of(index, limit));
		return new PageImpl<MessageDto>(
				messages.stream()
						.map(message -> modelMapper.map(message, MessageDto.class))
						.collect(Collectors.toList()),
						messages.getPageable(), messages.getTotalElements());
	}

	public Page<MessageDto> findByUser(Long id, int index, int limit) {
		Page<Message> messages = messageRepository.findByUser_Id(id,
				PageRequest.of(index, limit));
		return new PageImpl<MessageDto>(
				messages.stream()
						.map(message -> modelMapper.map(message, MessageDto.class))
						.collect(Collectors.toList()),
						messages.getPageable(), messages.getTotalElements());
	}

	public void deleteById(Long id) {
		checkIfMessageExist(id);
		messageRepository.deleteById(id);
	}

	private void checkIfUserValide(MessageDto messageDto) {
		if (messageDto.getUserId() == null) {
			throw new BadRequestException();
		}
		messageRepository.findById(messageDto.getUserId());
	}

	private void checkIfMessageExist(Long id) {
		if (id == null || messageRepository.findById(id).isEmpty()) {
			throw new BadRequestException();
		}
	}

}
