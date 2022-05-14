package com.pod8.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuotesMaster {
	

		private int id;
		private int businessValueMin;
		private int businessValueMax;
		private int propertyValueMin;
		private int propertyValueMax;
		private String propertyType;
		private int quotes;
	}


