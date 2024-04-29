package services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/uploadservice")
public class UploadService {

    @POST
    @Path("/fileupload")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Response uploadFile(
            @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition fileMetaData,
            @Context ServletContext sc) throws Exception {
        
        // Define the upload directory
        String UPLOAD_PATH = "C:\\Users\\jonim\\Documents\\GitHub\\palikka-posse-server\\";

        try {
            int read;
            byte[] bytes = new byte[1024];

            // Extract filename and file extension
            String fileName = fileMetaData.getFileName();
            String fileExtension = "";
            int dotIndex = fileName.lastIndexOf('.');
            if (dotIndex != -1) {
                fileExtension = fileName.substring(dotIndex);
                fileName = fileName.substring(0, dotIndex);
            }

            // Generate a timestamp for uniqueness
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
            String timestamp = dateFormat.format(new Date());

            // Construct unique filename
            String uniqueFileName = fileName + "_" + timestamp + fileExtension;

            // Set the file path including the unique file name
            String filePath = UPLOAD_PATH + uniqueFileName;

            // Create the output stream to write the file
            OutputStream out = new FileOutputStream(new File(filePath));

            // Read from the input stream and write to the output stream
            while ((read = fileInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            // Close the output stream
            out.flush();
            out.close();

        } catch (IOException e) {
            // Handle errors
            throw new WebApplicationException("Error while uploading file. Please try again !!");
        }

        return Response.ok("Data uploaded successfully !!").build();
    }
}
