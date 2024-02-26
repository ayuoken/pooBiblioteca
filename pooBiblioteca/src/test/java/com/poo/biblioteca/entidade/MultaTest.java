package com.poo.biblioteca.entidade;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poo.biblioteca.model.Multa;
import com.poo.biblioteca.model.Multa.StatusMulta;
import com.poo.biblioteca.service.MultaService;

@SpringBootTest
public class MultaTest {

	@Autowired
    private MultaService multaService;

    @Test
    public void testAtualizarMulta() {
      
        Multa multa = new Multa();
        multa.setValor(10.0);
        multa.setStatus(StatusMulta.PENDENTE);
        
        multaService.atualizarMulta(multa);

        assertEquals(StatusMulta.PAGA, multa.getStatus());
        assertEquals(12.0, multa.getValor(), 0.001);
        
    }
}