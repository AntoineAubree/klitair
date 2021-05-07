/**
 * 
 */
package fr.diginamic.klitair.services;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.dto.DiscussionThreadDto;
import fr.diginamic.klitair.entity.DiscussionThread;
import fr.diginamic.klitair.exceptions.AlreadyExistException;
import fr.diginamic.klitair.exceptions.BadRequestException;
import fr.diginamic.klitair.repository.DiscussionThreadRepository;

/**
 * @author StephanieMC
 *
 */
@Service
public class DiscussionThreadSrevice {

	@Autowired
	private DiscussionThreadRepository discussionThreadRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	public DiscussionThreadDto create(@Valid DiscussionThreadDto discussionThreadDto) {
		checkIfDiscussionThreadIsAvailable(discussionThreadDto);
		checkIfUserValide(discussionThreadDto);
		return saveDiscussionThread(discussionThreadDto);
	}

	public DiscussionThreadDto update(@Valid DiscussionThreadDto discussionThreadDto) {
		checkIfDiscussionThreadExist(discussionThreadDto.getId());
		checkIfDiscussionThreadIsAvailable(discussionThreadDto);
		checkIfUserValide(discussionThreadDto);
		return saveDiscussionThread(discussionThreadDto);
	}

	private DiscussionThreadDto saveDiscussionThread(DiscussionThreadDto discussionThreadDto) {
		DiscussionThread discussionThread = modelMapper.map(discussionThreadDto, DiscussionThread.class);
		discussionThread = discussionThreadRepository.save(discussionThread);
		return modelMapper.map(discussionThread, DiscussionThreadDto.class);
	}

	public Page<DiscussionThreadDto> findByIdSection(Long id, int index, int limit) {
		Page<DiscussionThread> discussionThreads = discussionThreadRepository.findBySection_Id(id,
				PageRequest.of(index, limit));
		return new PageImpl<DiscussionThreadDto>(
				discussionThreads.stream()
						.map(discussionThread -> modelMapper.map(discussionThread, DiscussionThreadDto.class))
						.collect(Collectors.toList()),
				discussionThreads.getPageable(), discussionThreads.getTotalElements());
	}

	public void deleteById(Long id) {
		checkIfDiscussionThreadExist(id);
		discussionThreadRepository.deleteById(id);
	}

	public boolean checkTitle(DiscussionThreadDto discussionThread) {
		boolean titleAvailable = false;
		if (discussionThreadRepository.findByTitle(discussionThread.getTitle()).isEmpty()) {
			titleAvailable = true;
		}
		if (discussionThread.getId() != null && discussionThreadRepository.findById(discussionThread.getId()).orElseThrow().getTitle()
				.equals(discussionThread.getTitle())) {
			titleAvailable = true;
		}
		return titleAvailable;
	}

	private void checkIfDiscussionThreadIsAvailable(DiscussionThreadDto discussionThreadDto) {
		if (!checkTitle(discussionThreadDto)) {
			throw new AlreadyExistException("Title not available");
		}
	}

	private void checkIfUserValide(DiscussionThreadDto discussionThreadDto) {
		if (discussionThreadDto.getUserId() == null) {
			throw new BadRequestException();
		}
		userService.findById(discussionThreadDto.getUserId());
	}

	private void checkIfDiscussionThreadExist(Long id) {
		if (id == null || discussionThreadRepository.findById(id).isEmpty()) {
			throw new BadRequestException();
		}
	}

}
