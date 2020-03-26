package config.videosystem.mixing;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

/*
 *  Explicit Configuration :Java Configuration
 *  
 *  JavaConfig <------ {JavaConfig1, JavaConfig2, ....}
 *  			import
 *  JavaConfig1 + JavaConfig2
 */

@Import({DVDConfig.class})
@Configuration
public class DVDPlayerConfig {
	
	@Bean
	public DigitalVideoDisc avengers() {
		return new Avengers();
	}
	
	
	@Bean
	public DVDPlayer dvdPlayer(@Qualifier("avengersInfinityWar")DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}

}
