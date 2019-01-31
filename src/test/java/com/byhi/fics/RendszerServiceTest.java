package com.byhi.fics;

import com.byhi.fics.domain.Rendszer;
import com.byhi.fics.repository.RendszerRepository;
import com.byhi.fics.service.RendszerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {FicsApplication.class})
public class RendszerServiceTest {
    @TestConfiguration
    static class RendszerServiceImplTestContextConfiguration {

        @Bean
        public RendszerServiceImpl rendszerService() {
            return new RendszerServiceImpl();
        }
    }

    @Autowired
    private RendszerServiceImpl rendszerService;

    @MockBean
    private RendszerRepository rendszerRepository;

    @Test
    public void givenCountMethodMocked_WhenCountInvoked_ThenMockValueReturned() {
        Mockito.when(rendszerService.getAllRendszer()).thenReturn(new ArrayList<Rendszer>());
        //call the main method you want to test
        List result = rendszerService.getAllRendszer();

        //verify null result was returned
        assertEquals(new ArrayList<Rendszer>(), result);

    }
}
