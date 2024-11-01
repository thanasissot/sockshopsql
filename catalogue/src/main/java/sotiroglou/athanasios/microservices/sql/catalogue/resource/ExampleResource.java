package sotiroglou.athanasios.microservices.sql.catalogue.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import sotiroglou.athanasios.microservices.sql.catalogue.model.Sock;
import sotiroglou.athanasios.microservices.sql.catalogue.model.Tag;
import sotiroglou.athanasios.microservices.sql.catalogue.repo.SockRepository;
import sotiroglou.athanasios.microservices.sql.catalogue.repo.TagRepository;

import java.util.List;

@Path("/hello")
@RequiredArgsConstructor
public class ExampleResource {

    private final SockRepository sockRepo;
    private final TagRepository tagRepo;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/sock")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Sock> sock () {
        List<Sock> socks = sockRepo.findAll();
        return socks;
    }

    @GET
    @Path("/tag")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Tag> tag () {
        List<Tag> tags = tagRepo.findAll();
        return tags;
    }
}
