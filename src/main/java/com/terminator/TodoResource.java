package com.terminator;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/todos")
@Tag(name="Todos resources", description = "All the Todos in the application")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {
    
    @Inject
    TodoService todoService;

    @GET
    public Response findAll() {
        List<Todo> todos = todoService.findAll();
        return Response.ok(todos).build();
    }

    @POST
    public Response addTodo(TodoDto todoDto){
        Todo todo = todoService.addTodo(todoDto);
        return Response.ok(todo).status(201).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(Long id){
        Todo todo = todoService.findById(id);
        return Response.ok(todo).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTodo(@PathParam("id") Long id, TodoDto todoDto){
        Todo todo = todoService.updateTodo(id, todoDto);
        return Response.ok(todo).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTodo(@PathParam("id") Long id){
        todoService.deleteTodo(id);
        return Response.ok("Deleted Successfully").build();
    }

    @GET
    @Path("/docs-test")
    @Operation(
        operationId = "Customizing docs",
        summary = "Docs Test",
        description = "This is a test of customizing API Documentation"
    )
    @APIResponse(
        responseCode = "200",
        description = "Customized response expeceted",
        content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response docs(){
        return Response.ok().build();
    }
}