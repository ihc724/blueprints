package stl.lab.sample1.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import stl.lab.sample1.model.Content;
import stl.lab.sample1.repository.ContentRepository;
import stl.lab.sample1.stats.ResourceConsumption;

@RestController
public class Controller {

	private ContentRepository contentRepository;

	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	public static void main(String[] args) {
	}

	public Controller(ContentRepository contentRepository) {
		this.contentRepository = contentRepository;
	}

	@PostMapping("/content")
	@ResponseStatus(HttpStatus.CREATED)
	public void addContent(@RequestBody Content content) {
		Content storedContent = contentRepository.save(content);
		logger.info("add(id=" +storedContent.getId() + ",name=" + storedContent.getName() + ")");
	}

	@GetMapping("/content")
	public List<Content> getContent() {
		List<Content> list = contentRepository.findAll();
		logger.info(Arrays.toString(list.toArray()));
		return list;
	}

	@GetMapping("/status")
	public String getStatus() {
		String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String lineSeparator = System.getProperty("line.separator");
		StringBuffer log = new StringBuffer(lineSeparator);
		log.append(this.getClass().getName() + " - invoked at: " + time).append(lineSeparator);
		log.append(ResourceConsumption.printResourceReport());
		logger.info(log.toString());

		return log.toString();
	}
}
