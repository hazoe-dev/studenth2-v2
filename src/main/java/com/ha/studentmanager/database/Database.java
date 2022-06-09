package com.ha.studentmanager.database;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ha.studentmanager.model.Student;
import com.ha.studentmanager.repository.StudentRepository;

@Configuration
public class Database {
	private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);

	@Bean
	CommandLineRunner initDatabaseUser(StudentRepository studentRepository) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				
				Student studentA = new Student("18130111", "Nguyen Van A", true, getCalendar(1999, 1, 12), "Hanoi", "17 pho hien", "Anh văn");
				Student studentB = new Student("18130222", "Nguyen Van Ba", true, getCalendar(2000, 0, 5), "Hcm", "200 Dien Bien Phu", "Tin học");
				Student studentC = new Student("18130333", "Nguyen Thi Hai", false, getCalendar(2000, 5, 22), "Danang", "45 Nam Ki", "Vật lý");

				LOGGER.info("insert data: " + studentRepository.save(studentA));
				LOGGER.info("insert data: " + studentRepository.save(studentB));
				LOGGER.info("insert data: " + studentRepository.save(studentC));

			}
		};
	}
	
	private Calendar getCalendar(int year, int month, int day) {
	    Calendar c = Calendar.getInstance();
	    c.set(Calendar.YEAR, year);
	    c.set(Calendar.MONTH, month);
	    c.set(Calendar.DAY_OF_MONTH, day);
	    return c;
	}
}
