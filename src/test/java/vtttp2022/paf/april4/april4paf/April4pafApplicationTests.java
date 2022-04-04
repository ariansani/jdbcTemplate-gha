package vtttp2022.paf.april4.april4paf;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vtttp2022.paf.april4.april4paf.models.Game;
import vtttp2022.paf.april4.april4paf.repositories.GameRepository;

@SpringBootTest
class April4pafApplicationTests {

	@Autowired
	private GameRepository gameRepo;

	@Test
	void contextLoads() {

	}

	@Test
	void shouldReturnAGame() {
		Optional<Game> opt = gameRepo.getGameByGid(10);
		assertTrue(opt.isPresent(), "gid = 10");
	}

	@Test
	void shouldReturnEmpty() {
		Optional<Game> opt = gameRepo.getGameByGid(10000);
		assertFalse(opt.isPresent(), "gid=10000");
	}

}
