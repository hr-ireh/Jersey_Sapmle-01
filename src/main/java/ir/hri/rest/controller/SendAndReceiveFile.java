package ir.hri.rest.controller;

import org.glassfish.jersey.media.multipart.BodyPartEntity;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.hibernate.annotations.Loader;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

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

    @POST
    @Path(PATH_UPLOAD)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @Loader
    public Response uploadFile(final FormDataMultiPart multiPart) {
        List<FormDataBodyPart> bodyParts = multiPart.getFields("files");
        StringBuffer fileDetails = new StringBuffer("");

        for (int i = 0; i < bodyParts.size(); i++) {
            BodyPartEntity bodyPartEntity = (BodyPartEntity) bodyParts.get(i).getEntity();
            String fileName = bodyParts.get(i).getContentDisposition().getFileName();
            saveFile(bodyPartEntity.getInputStream(), fileName);
            fileDetails.append(" File saved at /Volumes/Drive2/temp/file/" + fileName);
        }

        BodyPartEntity bodyPartEntity = ((BodyPartEntity) multiPart.getField("file2").getEntity());
        String file2Name = multiPart.getField("file2").getFormDataContentDisposition().getFileName();
        saveFile(bodyPartEntity.getInputStream(), file2Name);
        fileDetails.append(" File saved at /Volumes/Drive2/temp/file/" + file2Name);

        fileDetails.append(" Tag Details : " + multiPart.getField("tags").getValue());
        System.out.println(fileDetails);

        return Response.ok(fileDetails.toString()).build();
    }

    private void saveFile(InputStream file, String name) {
        try {
            /* Change directory path */
            java.nio.file.Path path = FileSystems.getDefault().getPath("D:\\" + name);
			/* Save InputStream as file */
            Files.copy(file, path);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}