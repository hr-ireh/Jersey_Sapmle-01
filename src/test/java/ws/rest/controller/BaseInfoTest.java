package ws.rest.controller;

import ir.hri.rest.controller.BaseInfo;
import org.junit.Assert;
import org.junit.Test;

public class BaseInfoTest {

    @Test
    public void cities() {
        BaseInfo baseInfo = new BaseInfo();
        Assert.assertNotNull(baseInfo.cities());
    }
}
