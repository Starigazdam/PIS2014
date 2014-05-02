package org.fit.pis.back;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="idConverter")
public class IdConverter implements Converter 
{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent component, String value)
	{
		if (value.length() == 11 && value.charAt(6) == '/')
		{
			try {
				long a = Long.parseLong(value.substring(0, 6));
				long b = Long.parseLong(value.substring(7));
				return a * 10000 + b;
			} catch (NumberFormatException e) {
				throw new ConverterException("Invalid ID format");
			}
		}
		else
			throw new ConverterException("Invalid ID format");
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent component, Object value)
	{
		try {
			long val = (Long) value;
			return (val / 10000) + "/" + (val % 10000);
		} catch (ClassCastException e) {
			throw new ConverterException("Invalid ID value");
		}
	}

}
