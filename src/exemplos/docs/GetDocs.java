package exemplos.docs;

import body.doc.DocsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import docs.DocRequests;

import java.io.IOException;

public class GetDocs {
    public static void main(String[] args) throws IOException, InterruptedException {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";
        DocsResponse docsResponse = new DocRequests().getDocs(apiToken);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonDocResponse = ow.writeValueAsString(docsResponse);
        System.out.println(jsonDocResponse);
    }
}
