package com.douzone.container.videosystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.videosystem.DVDPlayerConfig;



public class DVDPlayerJavaConfigTest {
		@Rule
		public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
		
		@Autowired
		private DigitalVideoDisc dvd;
		
		@Autowired
		@Qualifier("player04") // 클래스 이름으로 Bean 받아오기 혹은 Bean 네임으로 받아오기 
		private DVDPlayer player;
		
		
		@Test
		public void testDVDNotNull() {
			assertNotNull(dvd);
		}
		
		@Test
		public void testPlayerNotNull() {
			assertNotNull(player);
		}
		
		@Test
		public void testPlay() {
			player.play();
			assertEquals("Playing Movie : MARVEL's Avengers", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
		}
		
}
