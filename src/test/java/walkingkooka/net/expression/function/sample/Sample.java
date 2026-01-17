/*
 * Copyright 2026 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package walkingkooka.net.expression.function.sample;

import org.junit.jupiter.api.Test;
import walkingkooka.collect.list.Lists;
import walkingkooka.net.email.EmailAddress;
import walkingkooka.net.expression.function.NetExpressionFunctions;
import walkingkooka.tree.expression.ExpressionEvaluationContexts;

public class Sample implements walkingkooka.test.Testing {

    public static void main(final String[] args) {
        final Sample sample = new Sample();

        sample.testEmailAddress();
        sample.testGetHostAddress();
    }

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
}
