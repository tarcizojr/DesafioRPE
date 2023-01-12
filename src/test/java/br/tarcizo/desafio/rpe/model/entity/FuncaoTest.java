package br.tarcizo.desafio.rpe.model.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.tarcizo.desafio.rpe.business.service.FuncaoService;

@SpringBootTest
class FuncaoTest {
	
	@Autowired
	private Funcao funcao;
	
	@Autowired
	private FuncaoService funcaoService;

	@BeforeEach
	void setUp() throws Exception {
			
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		funcao = new Funcao();
		funcao.setNome("Tarcizo");
		
		assertDoesNotThrow(() -> funcaoService.save(funcao));
	}

}
