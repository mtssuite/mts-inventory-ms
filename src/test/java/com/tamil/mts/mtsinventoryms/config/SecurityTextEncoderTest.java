/*
 * Created on 29-Nov-2020
 * Created by murugan
 * Copyright � 2020 MTS [murugan425]. All Rights Reserved.
 */
package com.tamil.mts.mtsinventoryms.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import lombok.extern.slf4j.Slf4j;

/**
 * @author murugan
 *
 */
@Slf4j
@SpringBootTest
@ActiveProfiles("test")
public class SecurityTextEncoderTest {

	@Autowired
	public SecurityTextEncoder textEncoder;
	
	@Test
	public void logMd5EncodersHashValues() {
		//Log multiple times to make sure the same hash value is returned
		log.info(textEncoder.md5Hashing("murugan"));
		log.info(textEncoder.md5Hashing("murugan"));
		log.info(textEncoder.md5HashingWithSalt("murugan"));
		log.info(textEncoder.md5HashingWithSalt("murugan"));
		log.info(textEncoder.md5HashingWithSalt("murugan", "testsalt"));
		log.info(textEncoder.md5HashingWithSalt("murugan", "testsalt"));
		assertTrue(true);
	}
	
	@Test
	public void testMd5Encoders() {
		assertEquals(textEncoder.md5Hashing("murugan"), textEncoder.md5Hashing("murugan"),
				"md5Hashing - encoder test failed");
		assertEquals(textEncoder.md5HashingWithSalt("murugan"), textEncoder.md5HashingWithSalt("murugan"),
				"md5Hashing - default Salt test failed");
		assertEquals(textEncoder.md5HashingWithSalt("murugan", "testsalt"),
				textEncoder.md5HashingWithSalt("murugan", "testsalt"), "md5Hashing - custom Salt test failed");
	}

}
