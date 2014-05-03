package org.fit.pis.back;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="booleanConverter")
public class BooleanConverter implements Converter {
		
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent component, String value)
	{
		if (value.length() == 0) return null;
		if (value.length() == 4 && value.equalsIgnoreCase("true"))
		{
			return true;
		}
		else if(value.length() == 5 && value.equalsIgnoreCase("false")) {
			return false;
		}
		else
			throw new ConverterException("Invalid ID format");
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent component, Object value)
	{
		try {
			if(value == null) return null;
			if(value.equals(true)) return "true";
			else return "false";
		} catch (ClassCastException e) {
			throw new ConverterException("Invalid ID value");
		}
	}
}
