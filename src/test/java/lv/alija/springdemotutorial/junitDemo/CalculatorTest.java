package lv.alija.springdemotutorial.junitDemo;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CalculatorTest {

    Calculator c;
    CalculatorService service = Mockito.mock(CalculatorService.class);

    @BeforeEach
    public void setUp(){
        c=new Calculator(service);
    }

    @Test
    void perform() {
        when(service.add(2,3)).thenReturn(5);
        assertEquals(10, c.perform(2,3));
        verify(service).add(2,3); //to check if you are using mockito


    }
}