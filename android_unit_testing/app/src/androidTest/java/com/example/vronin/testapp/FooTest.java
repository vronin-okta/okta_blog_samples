package com.example.vronin.testapp;

/**
 * Created by vronin on 1/6/15.
 */
import junit.framework.Assert;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.easymock.EasyMock.expect;

@RunWith(RobolectricTestRunner.class)
public class FooTest extends EasyMockSupport {
    Foo sut;

    // Mocks
    Bar barMock;

    @Before
    public void setUp() {
        sut = new Foo();

        // Create mocks
        barMock = createMock(Bar.class);

        // Inject mock
        InjectHelper.injectMock(sut, barMock);
    }

    @Test
    public void testGetFoo_returns4() {
        // Arrange
        expect(barMock.getBar()).andReturn(4);
        replayAll();

        // Act
        int actualResult = sut.getFoo();

        // Assert
        verifyAll();
        Assert.assertEquals(4, actualResult);
    }
}

