/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author mattg
 */
@Provider
public class PersonNotFoundExceptionMapper implements ExceptionMapper<PersonNotFoundException> {

    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Response toResponse(PersonNotFoundException e) {
        Logger.getLogger(PersonNotFoundExceptionMapper.class.getName())
                .log(Level.SEVERE, null, e);
        ExceptionDTO error = new ExceptionDTO(404, e.getMessage());
        return Response
                .status(404)
                .entity(GSON.toJson(error))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
