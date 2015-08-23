/*
 * Copyright 2002-2013 the original author or authors
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package com.blankpix.smallz.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.CompareToBuilder;

/**
 * Represents some common Twitter related fields.
 *
 * @author Alex Lee
 * @since  1.0
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TwitterMessage implements Comparable<TwitterMessage>{

	@XmlAttribute
	private Long id;

	@XmlAttribute
	private Date createdAt;

	private String text;
	private String fromUser;
	private String profileImageUrl;

	/** Default constructor. */
	public TwitterMessage() {
		super();
	}

	/** Minimum constructor. */
	public TwitterMessage(Long id) {
		this.id = id;
	}

	/** Constructor to initialize all fields available. */
	public TwitterMessage(Long id, Date createdAt, String text, String fromUser,
			String profileImageUrl) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.text = text;
		this.fromUser = fromUser;
		this.profileImageUrl = profileImageUrl;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	@XmlAttribute
	public String getCreatedAtISO() {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(this.createdAt);
		return javax.xml.bind.DatatypeConverter.printDateTime(calendar);
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result
				+ ((fromUser == null) ? 0 : fromUser.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((profileImageUrl == null) ? 0 : profileImageUrl.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TwitterMessage other = (TwitterMessage) obj;
		if (createdAt == null) {
			if (other.createdAt != null) {
				return false;
			}
		} else if (!createdAt.equals(other.createdAt)) {
			return false;
		}
		if (fromUser == null) {
			if (other.fromUser != null) {
				return false;
			}
		} else if (!fromUser.equals(other.fromUser)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (profileImageUrl == null) {
			if (other.profileImageUrl != null) {
				return false;
			}
		} else if (!profileImageUrl.equals(other.profileImageUrl)) {
			return false;
		}
		if (text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!text.equals(other.text)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TwitterMessage [id=" + id + ", fromUser=" + fromUser + "]";
	}

	public int compareTo(final TwitterMessage other) {
		return new CompareToBuilder().append(id, other.id).toComparison();
	}

}
