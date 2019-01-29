package com.byhi.fics;

import com.byhi.fics.domain.Modul;
import com.byhi.fics.repository.ModulRepository;
import com.byhi.fics.service.ModelServiceImpl;
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
@ContextConfiguration(classes = { FicsApplication.class })
public class ModulServiceTest {

    @TestConfiguration
    static class ModelServiceImplTestContextConfiguration {

        @Bean
        public ModelServiceImpl modelService() {
            return new ModelServiceImpl();
        }
    }

    @Autowired
    private ModelServiceImpl modelService;

    @MockBean
    private ModulRepository modulRepository;

    @Test
    public void givenCountMethodMocked_WhenCountInvoked_ThenMockValueReturned() {
        Mockito.when(modelService.getAllModul()).thenReturn(new ArrayList<Modul>());
        //call the main method you want to test
        List result = modelService.getAllModul();

        //verify null result was returned
        assertEquals(new ArrayList<Modul>(),result);

    }
}
