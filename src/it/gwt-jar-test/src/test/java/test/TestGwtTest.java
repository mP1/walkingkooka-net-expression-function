package test;

import com.google.gwt.junit.client.GWTTestCase;

import walkingkooka.collect.list.Lists;
import walkingkooka.net.email.EmailAddress;
import walkingkooka.net.expression.function.NetExpressionFunctions;
import walkingkooka.tree.expression.ExpressionEvaluationContexts;

@walkingkooka.j2cl.locale.LocaleAware
public class TestGwtTest extends GWTTestCase {

    @Override
    public String getModuleName() {
        return "test.Test";
    }

    public void testAssertEquals() {
        assertEquals(
            1,
            1
        );
    }

    public void testEmailAddress() {
        final EmailAddress email = EmailAddress.parse("test@example.com");

        this.checkEquals(
            email,
            NetExpressionFunctions.emailAddress()
                .apply(
                    Lists.of(
                        email
                    ),
                    ExpressionEvaluationContexts.fake()
                ),
            ""
        );
    }

    public void testGetHostAddress() {
        final EmailAddress email = EmailAddress.parse("test@example.com");

        this.checkEquals(
            email.hostAddress(),
            NetExpressionFunctions.getHost()
                .apply(
                    Lists.of(
                        email
                    ),
                    ExpressionEvaluationContexts.fake()
                ),
            ""
        );
    }

    private static void checkEquals(final Object expected,
                                    final Object actual,
                                    final String message) {
        assertEquals(
            message,
            expected,
            actual
        );
    }
}
