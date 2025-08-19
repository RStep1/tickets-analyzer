package com.rstep1.filemanager;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rstep1.app.FileReader;
import com.rstep1.model.Ticket;
import com.rstep1.model.TicketsWrapper;

public class JSONReader implements FileReader<Ticket> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Ticket> read(String filePath) throws IOException {
        TicketsWrapper ticketsWrapper = 
            objectMapper.readValue(new File(filePath), TicketsWrapper.class);
        return ticketsWrapper.tickets();
    }
    
}
