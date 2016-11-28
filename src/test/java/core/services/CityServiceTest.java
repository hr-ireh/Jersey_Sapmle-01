package core.services;

import ir.hri.core.entities.City;
import ir.hri.core.services.CityService;
import ir.hri.core.util.SpringUtil;
import org.junit.Assert;
import org.junit.Test;

public class CityServiceTest {
    @Test
    public void findByIdTest() {
        CityService cityServiceImpl = (CityService) SpringUtil.getApplicationContext().getBean("cityServiceImpl");
        City city = null;
        try {
            city = cityServiceImpl.findById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(city);
    }
}
