package sotiroglou.athanasios.microservices.sql.catalogue.resource;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import sotiroglou.athanasios.microservices.sql.catalogue.model.Sock;
import sotiroglou.athanasios.microservices.sql.catalogue.model.Tag;
import sotiroglou.athanasios.microservices.sql.catalogue.repo.SockRepository;
import sotiroglou.athanasios.microservices.sql.catalogue.repo.TagRepository;
import sotiroglou.athanasios.microservices.sql.catalogue.service.ImageDirectoryProducer;

import java.util.Collections;
import java.util.List;

@Path("/sock")
@RequiredArgsConstructor
public class SockResource {

    private final SockRepository sockRepo;
    private final TagRepository tagRepo;

    @Inject
    ImageDirectoryProducer imageDirectoryProducer;

    @GET
    @Path("/all")
    public List<Sock> listSocks(
            @QueryParam("tags") List<String> tags,
            @QueryParam("order") String order,
            @QueryParam("pageNum") int pageNum,
            @QueryParam("pageSize") int pageSize
    ) {
        if (tags != null && !tags.isEmpty()) {

            List<Tag> tagList = tagRepo.findAllByNameIn(tags);



            List<ObjectId> tagIds = tagList.stream()
                    .map(tag -> tag.id)
                    .toList();
            if (tagIds.isEmpty()) {
                // No matching tags found, return an empty list
                return Collections.emptyList();
            }

            List<SockTag> sockTagList =
                    SockTag.find(new Document("tagId",
                                    new Document("$in", tagIds)))
                            .list();
            List<ObjectId> sockIds = sockTagList.stream()
                    .map(sockTag -> sockTag.sockId)
                    .toList();

            Document queryDocument = new Document("_id", new Document("$in", sockIds));
            String sortOrder = order != null && !order.isEmpty() && !order.isBlank()
                    ? sortOrder = order
                    : "_id";  // Default sort by _id if no order is provided

            PanacheQuery<Sock> query = Sock.find(queryDocument.toJson(), Sort.by(sortOrder));
            return query.page(Page.of(pageNum, pageSize))
                    .list();
        } else {
            return Sock.findAll().page(pageNum, pageSize).list();
        }
    }


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
