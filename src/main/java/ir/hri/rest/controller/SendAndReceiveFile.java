package ir.hri.rest.controller;

import org.glassfish.jersey.media.multipart.MultiPart;
import org.hibernate.annotations.Loader;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

import static ir.hri.rest.utils.ApiV1Urls.SendAndReceiveFilePath.*;

@Controller
@Path(FILE)
public class SendAndReceiveFile {
    @GET
    @Path(PATH_DOWNLOAD)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("multipart/mixed")
    @Loader
    public Response downloadFile(@PathParam(PARAM_FILE_NAME) String fileName) {
        File file = new File("C:\\Users\\HR\\Downloads\\Telegram Desktop\\" + fileName);
        MultiPart objMultiPart = new MultiPart();
        objMultiPart.type(new MediaType("multipart", "mixed"));
        objMultiPart.bodyPart(file.getName(), new MediaType("text", "plain"));
        objMultiPart.bodyPart("" + file.length(), new MediaType("text", "plain"));
        objMultiPart.bodyPart(file, new MediaType("multipart", "mixed"));

        return Response.ok(objMultiPart).build();
    }
}