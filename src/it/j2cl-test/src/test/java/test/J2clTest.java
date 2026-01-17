package test;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Assert;
import org.junit.Test;

import walkingkooka.collect.list.Lists;
import walkingkooka.net.email.EmailAddress;
import walkingkooka.net.expression.function.NetExpressionFunctions;
import walkingkooka.tree.expression.ExpressionEvaluationContexts;

@J2clTestInput(J2clTest.class)
public class J2clTest {

    @Test
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

    @Test
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
        Assert.assertEquals(
            message,
            expected,
            actual
        );
    }
}
