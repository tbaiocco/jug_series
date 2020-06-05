package com.sap.jugSession;

import com.sap.jugSession.model.Musician;
import com.sap.jugSession.repository.MusicianRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class JugSessionApplicationTests {

	@Autowired
	private MusicianRepository musicianRepository;

	@Test
	public void whenFindingMusicianById_thenCorrect() {
		Assertions.assertThat(musicianRepository.findById(1)).isInstanceOf(Optional.class);
	}
	@Test
	public void whenSavingNewMusicianById_thenCorrect() {
		musicianRepository.save(new Musician("John", "Lennon"));
		Assertions.assertThat(musicianRepository.findById(4)).isInstanceOf(Optional.class);
	}
	@Test
	public void whenFindingAllMusicians_thenCorrect() {
		musicianRepository.save(new Musician("John", "john@domain.com"));
		Assertions.assertThat(musicianRepository.findAll()).isInstanceOf(List.class);
		assert musicianRepository.findAll().iterator().hasNext();
	}
	@Test
	public void whenDeletingAllMusicians_thenCorrect() {
		musicianRepository.deleteAll();
		Assertions.assertThat(musicianRepository.findAll()).isInstanceOf(List.class);
		assert !musicianRepository.findAll().iterator().hasNext();
	}
	@Test
	void contextLoads() {
	}

}
