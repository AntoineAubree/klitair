/**
 * 
 */
package fr.diginamic.klitair.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	DiscussionThreadRepository discussionThreadRepository;

	public DiscussionThread create(DiscussionThread discussionThread) {
		checkIfDiscussionThreadIsAvailable(discussionThread);
		return discussionThreadRepository.save(discussionThread);
	}

	public List<DiscussionThread> findByIdSection(Long id) {
		return discussionThreadRepository.findByIdSection(id);
	}

	public DiscussionThread update(@Valid DiscussionThread discussionThread) {
		if (discussionThread.getId() == null || discussionThreadRepository.findById(discussionThread.getId()).isEmpty()) {
			throw new BadRequestException();
		}
		checkIfDiscussionThreadIsAvailable(discussionThread);
		return discussionThreadRepository.save(discussionThread);
	}

	public void deleteById(Long id) {
		if (id == null || discussionThreadRepository.findById(id).isEmpty()) {
			throw new BadRequestException();
		}
		discussionThreadRepository.deleteById(id);
	}
	
	public boolean checkTitle(String title) {
		boolean titleAvailable = false;
		if (discussionThreadRepository.findByTitle(title).isEmpty()) {
			titleAvailable = true;
		}
		return titleAvailable;
	}
	
	/**
	 * @param discussionThread
	 */
	private void checkIfDiscussionThreadIsAvailable(DiscussionThread discussionThread) {
		if (!checkTitle(discussionThread.getTitle())) {
			throw new AlreadyExistException("Title not available");
		}
	}


}
