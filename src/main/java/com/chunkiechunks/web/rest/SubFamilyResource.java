package com.chunkiechunks.web.rest;

import com.chunkiechunks.service.Paged;
import com.chunkiechunks.service.PracticeService;
import com.chunkiechunks.service.SubFamilyService;
import com.chunkiechunks.service.dto.PracticeDTO;
import com.chunkiechunks.web.rest.vm.PageRequestVM;
import com.chunkiechunks.web.rest.vm.SortRequestVM;
import com.chunkiechunks.web.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/api/sub_families")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class SubFamilyResource {

    private final Logger log = LoggerFactory.getLogger(SubFamilyResource.class);

    private final SubFamilyService subFamilyService;
    private final PracticeService practiceService;

    @Inject
    public SubFamilyResource(SubFamilyService subFamilyService, PracticeService practiceService) {
        this.subFamilyService = subFamilyService;
        this.practiceService = practiceService;
    }

    @GET
    @Path("/{id}/practices")
    public Response getAllPaginatedPracticesBySubFamilyId(@BeanParam PageRequestVM pageRequest, @BeanParam SortRequestVM sortRequest,
                                                          @Context UriInfo uriInfo, @PathParam("id") Long id) {
        log.debug("REST request to get a page of Practices");
        var page = pageRequest.toPage();
        var sort = sortRequest.toSort();
        if (subFamilyService.findSubFamilyById(id).isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Paged<PracticeDTO> result = practiceService.getAllPaginatedPracticesBySubFamilyId(sort, page, id);
        var response = PaginationUtil.withPaginationInfo(Response.ok().entity(result.content), uriInfo, result);
        return response.build();
    }
}
