package rest.controller;

import ir.hri.rest.controller.BaseInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class BaseInfoTest {

    @Test
    public void cities() {
        BaseInfo baseInfo = new BaseInfo();
        Assert.assertNotNull(baseInfo.cities());
    }
}
