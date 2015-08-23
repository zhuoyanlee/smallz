/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blankpix.smallz;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Customized Jackson {@link ObjectMapper} to add Jaxb annoation support using the
 * {@link JaxbAnnotationIntrospector}.
 *
 * @author Alex Lee
 * @since  1.0
 *
 */
public class SpringIntegrationTest {

	@Test
	public void testSpringIntegrationContextStartup() throws Exception{

		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("/META-INF/spring/integration/spring-integration-context.xml", SpringIntegrationTest.class);
		Thread.sleep(4000);
		classPathXmlApplicationContext.close();

	}

}
