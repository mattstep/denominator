package denominator.mock;

import static denominator.Denominator.create;
import static denominator.Denominator.listProviders;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;

import denominator.Provider;

public class MockProviderTest {
    private static final Provider PROVIDER = new MockProvider();

    @Test
    public void testMockMetadata() {
        assertEquals(PROVIDER.getName(), "mock");
        assertEquals(PROVIDER.getCredentialTypeToParameterNames(), ImmutableMultimap.of());
    }

    @Test
    public void testMockRegistered() {
        Set<Provider> allProviders = ImmutableSet.copyOf(listProviders());
        assertTrue(allProviders.contains(PROVIDER));
    }

    @Test
    public void testProviderWiresMockZoneApi() {
        assertEquals(create(PROVIDER).getApi().getZoneApi().getClass(), MockZoneApi.class);
        assertEquals(create("mock").getApi().getZoneApi().getClass(), MockZoneApi.class);
    }
}
