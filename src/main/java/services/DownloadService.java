package services;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/downloadservice")
public class DownloadService {

    @GET
    @Path("/downloadfile")
    @Produces("audio/wav")
    public Response downloadFile() {
        // Path to the directory where uploaded WAV files are stored
        String directoryPath = "C:\\Users\\jonim\\Documents\\GitHub\\palikka-posse-server\\";

        // Get the list of WAV files in the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".wav"));

        // Sort the files by last modified timestamp in descending order
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());

        // Check if there are any WAV files in the directory
        if (files == null || files.length == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Get the most recently modified WAV file
        File mostRecentFile = files[0];

        // Build the response with the file data
        ResponseBuilder response = Response.ok(mostRecentFile);
        response.header("Content-Disposition", "attachment; filename=\"" + mostRecentFile.getName() + "\"");

        return response.build();
    }
}

