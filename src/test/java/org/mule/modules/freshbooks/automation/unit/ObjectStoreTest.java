package org.mule.modules.freshbooks.automation.unit;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.*;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mule.api.ConnectionException;
import org.mule.api.MuleContext;
import org.mule.api.store.ObjectDoesNotExistException;
import org.mule.api.store.ObjectStoreException;
import org.mule.modules.freshbooks.api.FreshBooksObjectStore;
import org.mule.tools.devkit.ctf.configuration.util.ConfigurationUtils;
import org.mule.tools.devkit.ctf.exceptions.ConfigurationLoadingFailedException;

public class ObjectStoreTest {

    private static FreshBooksObjectStore objectStore;

    @BeforeClass
    public static void setUp() throws IOException, ObjectStoreException, ConnectionException, ConfigurationLoadingFailedException {
        final Properties prop = ConfigurationUtils.getAutomationCredentialsProperties();

        MuleContext muleContext = Mockito.mock(MuleContext.class);
        Mockito.when(muleContext.getExecutionClassLoader()).thenReturn(ObjectStoreTest.class.getClassLoader());

        objectStore = new FreshBooksObjectStore();
        objectStore.initialize();
        objectStore.store((Serializable) prop.getProperty("config.consumerKey"), (Serializable) prop.getProperty("config.consumerSecret"));
    }

    @Test
    public void Persistent() {
        assertThat(objectStore.isPersistent(), is(true));
    }

    @Test
    public void validContains() throws ObjectStoreException {
        final String testKey = RandomStringUtils.randomAlphanumeric(20);
        assertThat(objectStore.contains(testKey), is(false));
        assertThat(objectStore.allKeys().contains(testKey), is(false));
    }

    @Test(expected = ObjectStoreException.class)
    public void invalidContains() throws ObjectStoreException {
        final String testKey = null;
        assertThat(objectStore.contains(testKey), is(false));
    }

    @Test
    public void invalidAllKeysContains() throws ObjectStoreException {
        final String testKey = null;

        assertThat(objectStore.allKeys().contains(testKey), is(false));
    }

    @Test(expected = ObjectDoesNotExistException.class)
    public void invalidRetrieve() throws ObjectStoreException {
        final String testKey = RandomStringUtils.randomAlphanumeric(20);
        objectStore.retrieve(testKey);
    }

    @Test
    public void validRetrieve() throws ObjectStoreException {
        final String testKey = RandomStringUtils.randomAlphanumeric(20);
        final Serializable testValue = BigInteger.valueOf(RandomUtils.nextLong());

        objectStore.store(testKey, testValue);
        assertThat(testValue, is(objectStore.retrieve(testKey)));
    }

    @Test(expected = ObjectStoreException.class)
    public void invalidStore() throws ObjectStoreException {
        final String testKey = null;
        final Serializable testValue = BigInteger.valueOf(RandomUtils.nextLong());

        objectStore.store(testKey, testValue);
    }

}