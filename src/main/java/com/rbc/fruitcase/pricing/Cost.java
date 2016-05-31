package com.rbc.fruitcase.pricing;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class Cost {
	
	public static final Cost ZERO_COST = new Cost(BigDecimal.ZERO,Currency.getInstance(Locale.getDefault()));
	
	private BigDecimal value;
	private Currency currency;
	
	
	public Cost(BigDecimal value, Currency currency) {
		this.value = value;
		this.currency = currency;
	}
	
	public BigDecimal getValue() {
		return value;
	}

	public Currency getCurrency() {
		return currency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currency == null) ? 0 : currency.getCurrencyCode().hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cost other = (Cost) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.getCurrencyCode().equals(other.currency.getCurrencyCode()))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb  = new StringBuilder();
		sb.append("Cost [");
		if (currency != null) sb.append(currency.getSymbol());
		sb.append(" ");
		sb.append(value);
		sb.append(" ");
		if (currency != null) sb.append(currency.getDisplayName());	
		sb.append("]");
		return sb.toString();
	}
	
	

}
