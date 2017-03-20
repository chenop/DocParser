package com.chenop.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Chen on 23/10/2015.
 */
@XmlRootElement
public class CVData {

	List<String> keywords;
	private String email;

	public CVData() {
	}

	public CVData(List<String> keywords, String email) {

		this.keywords = keywords;
		this.email = email;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public String getEmail() {
		return email;
	}
}
