package com.ada.aulajunit;

import com.ada.aulajunit.Calculadora;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    // Casos de teste do método somar
    // 1. Dados 2 numeros positivos, quando o primeiro for maior que o segundo, então a soma deve ser positiva
    // 2. 2 numeros positivos, sendo o primeiro menor que o segundo
    // 3. numeros positivos iguais
    // 4. primeiro negativo, segundo positivo
    // 5. primeiro positivo, segundo negativo
    // 6. 2 números de mesmo valor absoluto, mas sinais diferentes
    // 7. zero e um numero positivo
    // 8. zero e um numero negativo
    // 9. um numero positivo e zero
    // 10. um numero negativo e e zero
    // 11. 2 numeros negativos, sendo o primeiro maior que o segundo
    // 12. 2 numeros negativos, sendo o primeiro menor que o segundo
    // 13. numeros negativos iguais

    // Gherkin

    private Calculadora calc;

    @BeforeAll
    public static void init(){
        System.out.println("Começando os testes");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Encerrando os testes");
    }

    @BeforeEach
    public void before(){
        System.out.println("Instanciando a calculadora");
        calc = new Calculadora();
    }

    @AfterEach
    public void after(){
        System.out.println("Acabou um caso de teste");
    }

    @Test
    public void dados2NumerosPositivos_quandoPrimeiroMaiorQueSegundo_entaoResultadoDeveSerPositivo(){
        // Antes
        int primeiro = 10;
        int segundo = 3;
        assertTrue(primeiro > segundo);

        // Durante
        int result = calc.somar(primeiro, segundo);

        // Depois
        assertEquals(13, result);

    }

    @Test
    public void dadoZeroEPositivo_entaoResultadoDeveSerOSegundo(){
        int primeiro = 0;
        int segundo = 8;

        int result = calc.somar(primeiro, segundo);

        assertEquals(segundo, result);
    }

    @Test
    public void dados2Negativos_quandoXMaiorQueY_entaoResultadoNegativo(){
        int x = -3;
        int y = -7;

        int soma = calc.somar(x ,y);

        assertEquals(-10, soma);
    }

    @Test
    public void quandoDivisaoPorZero(){
        int x = 3;
        int y = 0;

        Exception e = assertThrows(ArithmeticException.class, () -> {
           calc.dividir(x, y);
        });

        String msgEsperada = "/ by zero";
        assertEquals(msgEsperada, e.getMessage());
    }
}