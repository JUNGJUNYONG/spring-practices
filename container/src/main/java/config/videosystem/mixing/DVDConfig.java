package config.videosystem.mixing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.BlankDisc;
import com.douzone.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDConfig {
	@Bean(name="avengersInfinityWar")
	public DigitalVideoDisc blankDisc() {
		BlankDisc blankdisc = new BlankDisc();
		blankdisc.setTitle("Avengers Infinity War");
		blankdisc.setStudio("MAVEL");
		return blankdisc;
	}

}
