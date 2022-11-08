package com.egotec.starterproject

import com.egotec.starterproject.entity.TodoEntity
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/todo")
class TodoAPI {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getTodo(@PathParam("id") id: String): TodoEntity {
        val ts = ThreadState.begin()
        return ts.em.find(TodoEntity::class.java, id) ?: throw WebApplicationException(Response.Status.NOT_FOUND)
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllTodos(): List<TodoEntity> {
        val ts = ThreadState.begin();
        return ts.em.createQuery("SELECT todo FROM TodoEntity todo", TodoEntity::class.java).resultList
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    fun updateTodoById(@PathParam("id") id: String, newTodo: TodoEntity): TodoEntity {
        val ts = ThreadState.begin()
        val e = ts.em.find(TodoEntity::class.java, id);
        e.content = newTodo.content
        e.done = newTodo.done
        ts.em.transaction.begin();
        ts.em.merge(e)
        ts.em.transaction.commit();
        return e
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun createTodo(todoEntity: TodoEntity): TodoEntity {
        val ts = ThreadState.begin()
        ts.em.transaction.begin()
        ts.em.merge(todoEntity)
        ts.em.transaction.commit()
        return todoEntity
    }


    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    fun deleteTodoById(@PathParam("id") id: String): TodoEntity {
        val ts = ThreadState.begin()
        val e = ts.em.find(TodoEntity::class.java, id);
        ts.em.transaction.begin();
        ts.em.remove(e)
        ts.em.transaction.commit();
        return e
    }

}