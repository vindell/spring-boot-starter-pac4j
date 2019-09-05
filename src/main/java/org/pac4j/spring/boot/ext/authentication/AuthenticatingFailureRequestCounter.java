/*
 * Copyright (c) 2018, vindell (https://github.com/vindell).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.pac4j.spring.boot.ext.authentication;


import java.util.Optional;

import org.pac4j.core.context.WebContext;
import org.pac4j.spring.boot.ext.Pac4jExtConstants;


public class AuthenticatingFailureRequestCounter implements AuthenticatingFailureCounter {

    private String retryTimesKeyParameter = Pac4jExtConstants.RETRY_TIMES_KEY_PARAM_NAME;
    
	@Override
	public int get(WebContext context, String retryTimesKeyAttribute) {
		Optional<String> count = context.getRequestParameter(getRetryTimesKeyParameter());
		if (count.isPresent()) {
			return Integer.parseInt(count.get());
		}
		return 0;
	}

	@Override
	public void increment(WebContext context, String retryTimesKeyAttribute) {
		// 参数方式传递错误次数,后端不进行计数累加
	}

	public String getRetryTimesKeyParameter() {
		return retryTimesKeyParameter;
	}

	public void setRetryTimesKeyParameter(String retryTimesKeyParameter) {
		this.retryTimesKeyParameter = retryTimesKeyParameter;
	}
	
}
