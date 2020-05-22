package com.logicbig.example;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandler extends StdSerializer<Date> {

    private SimpleDateFormat formatter
            = new SimpleDateFormat("ddMMyyyy");

    public DateHandler() {
        this(null);
    }

    private DateHandler(Class clazz) {
        super(clazz);
    }

    @Override
    public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider arg2) throws IOException {
        jsonGenerator.writeString(formatter.format(value));
    }
}

