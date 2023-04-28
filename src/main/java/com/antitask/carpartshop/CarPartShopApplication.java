package com.antitask.carpartshop;

import com.antitask.carpartshop.data.PartDataSource;
import com.antitask.carpartshop.logic.PartService;
import com.antitask.carpartshop.model.Part;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@Log4j
public class CarPartShopApplication {
	static {
		Logger.getRootLogger().addAppender(new ConsoleAppender(new PatternLayout("[%p]  %m%n")));
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CarPartShopApplication.class, args);

		PartService partService = PartService.with(new PartDataSource().getParts());

		List<Part> partsById = partService.getPartsById(1);
		log.info("Result by id: " + partsById.size());

		List<Part> partsByName = partService.getPartsByName("roof");
		log.info("Results by name: " + partsByName.size());

		List<Part> partsByUsage = partService.getPartsByUsage(false);
		log.error("Results by usage: " + partsByUsage.size());

		List<Part> partsByDateProduced = partService.getPartsByDateProduced(LocalDate.of(2020, 1, 1));
		log.info("Results by date produced: " + partsByDateProduced.size());

		List<Part> partsByAfterDateProduced = partService.getPartsAfterDatesProduced(LocalDate.of(2022, 5, 1));
		log.debug("Results after date produced: " + partsByAfterDateProduced.size());

		List<Part> partsByBeforeDateProduced = partService.getPartsBeforeDatesProduced(LocalDate.of(2023, 5, 1));
		log.info("Results before date produced: " + partsByBeforeDateProduced.size());

		List<Part> partsBetweenDateProduced = partService.getPartsBetweenDatesProduced(LocalDate.of(2020, 1, 1), LocalDate.of(2024, 1, 1));
		log.warn("Results between dates produced: " + partsBetweenDateProduced.size());
	}

}
