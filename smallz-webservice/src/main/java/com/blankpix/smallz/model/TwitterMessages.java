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
package com.blankpix.smallz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Wrapper containing a {@link Collection} of Twitter messages. Used for
 * proper serialization via Jaxb.
 *
 * @author Alex Lee
 * @since  1.0
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TwitterMessages implements Serializable {

	private static final long serialVersionUID = 2350458102814527467L;

	@XmlElement(name="twitterMessage")
	private Collection<TwitterMessage> twitterMessages = new ArrayList<TwitterMessage>(0);

	@XmlAttribute
	private long latestTweetId = 0;

	@XmlAttribute
	private boolean adapterRunning = false;

	public Collection<TwitterMessage> getTwitterMessages() {
		return twitterMessages;
	}

	public void setTwitterMessages(Collection<TwitterMessage> twitterMessages) {

		for (TwitterMessage tweet : twitterMessages) {
			if (latestTweetId < tweet.getId()) {
				this.latestTweetId = tweet.getId();
			}
		}

		this.twitterMessages = twitterMessages;
	}

	public long getLatestTweetId() {
		return latestTweetId;
	}

	public void setLatestTweetId(long latestTweetId) {
		this.latestTweetId = latestTweetId;
	}

	@XmlAttribute
	public String getLatestTweetIdAsString() {
		return String.valueOf(latestTweetId);
	}

	public boolean isAdapterRunning() {
		return adapterRunning;
	}

	public void setAdapterRunning(boolean adapterRunning) {
		this.adapterRunning = adapterRunning;
	}

}
