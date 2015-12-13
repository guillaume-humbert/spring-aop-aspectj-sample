package org.ghumbert.sample;

import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SpringConfigurationTest {

    @Test
    public void departmentAccessAspect_whenTypical() {

        SpringConfiguration testObject = new SpringConfiguration();

        assertThat(testObject.departmentAccessAspect(), notNullValue());
    }
}
