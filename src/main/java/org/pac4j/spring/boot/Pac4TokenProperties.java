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
package org.pac4j.spring.boot;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pac4TokenProperties {

	public static final String AUTHORIZATION_PARAM = "token";

	/** Whether Enable Pac4j Uniauth（浙江音乐学院单点认证）. */
	private boolean enabled = false;

	/** The Name of Client. */
	private String clientName = "token";

    /** Defines the location of the uniauth server login URL, i.e. http://localhost:8080/uniauth/ser/createtocken.action */
	private String loginUrl;
	/** Defines the location of the uniauth server logout URL, i.e. http://localhost:8080/uniauth/ser/logout.action */
	private String logoutUrl;
	/** Defines the location of the uniauth server token validate URL. i.e. https://localhost:8080/uniauth/ser/vaildTocken.action */
	private String vaildateUrl;
  	/** Defines the location of the client callback URL, i.e. https://localhost:8080/myapp/callback */
  	private String callbackUrl; 
	 
	private String authorizationParamName = AUTHORIZATION_PARAM;
	private boolean supportGetRequest = true;
	private boolean supportPostRequest = true;
	/* Map containing user defined headers */
	private Map<String, String> customHeaders = new HashMap<>();
    /* Map containing user defined parameters */
    private Map<String, String> customParams = new HashMap<>();
		
    private String charset = StandardCharsets.UTF_8.name();
    
	// 连接超时 单位毫秒
	private int connectTimeout = 10000;
	// 读取超时 单位毫秒
	private int readTimeout = 3000;

}
