package com.chunkiechunks.web.rest;

import com.chunkiechunks.service.FamilyService;
import com.chunkiechunks.service.Paged;
import com.chunkiechunks.service.SubFamilyService;
import com.chunkiechunks.service.dto.SubFamilyDTO;
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

@Path("/api/families")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class FamilyResource {

    private final Logger log = LoggerFactory.getLogger(FamilyResource.class);

    private final FamilyService familyService;
    private final SubFamilyService subFamilyService;

    @Inject
    public FamilyResource(FamilyService familyService, SubFamilyService subFamilyService) {
        this.familyService = familyService;
        this.subFamilyService = subFamilyService;
    }

    @GET
    public Response getAllFamilies() {
        return Response.ok(familyService.getAllFamilies()).build();
    }

    @GET
    @Path("/{id}/sub_families")
    public Response getAllPaginatedSubFamiliesByFamilyId(@BeanParam PageRequestVM pageRequest, @BeanParam SortRequestVM sortRequest,
                                                         @Context UriInfo uriInfo, @PathParam("id") Long id) {
        log.debug("REST request to get a page of Sub Families");
        var page = pageRequest.toPage();
        var sort = sortRequest.toSort();
        Paged<SubFamilyDTO> result = subFamilyService.getAllPaginatedSubFamiliesByFamilyId(sort, page, id);
        var response = PaginationUtil.withPaginationInfo(Response.ok().entity(result.content), uriInfo, result);
        return response.build();
    }
}
