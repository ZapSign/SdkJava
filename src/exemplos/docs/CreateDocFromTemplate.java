package exemplos.docs;


import body.doc.DeParaTemplate;
import body.doc.DocFromPdf;
import body.doc.DocFromTemplate;
import body.doc.DocResponse;
import body.signer.Signer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import docs.DocRequests;

import java.io.IOException;
import java.util.ArrayList;

public class CreateDocFromTemplate {
    public static void main(String[] args) throws IOException, InterruptedException  {
        String apiToken = "0a4d6893-f431-4d83-af80-98097029293730b9ddcf-3e60-4b8a-bb4d-5b68448e4038";

        DeParaTemplate deParaTemplateName = DeParaTemplate.deParaTemplateBuilder()
                .de("{{NOME COMPLETO}}")
                .para("Full Name")
                .build();

        DeParaTemplate deParaTemplateCpf= DeParaTemplate.deParaTemplateBuilder()
                .de("{{NÚMERO DO CPF}}")
                .para("Social Security Number")
                .build();

        DeParaTemplate deParaTemplateEnd = DeParaTemplate.deParaTemplateBuilder()
                .de("{{ENDEREÇO COMPLETO}}")
                .para("Full address")
                .build();

        ArrayList<DeParaTemplate> deParaTemplates = new ArrayList<>();
        deParaTemplates.add(deParaTemplateName);
        deParaTemplates.add(deParaTemplateCpf);
        deParaTemplates.add(deParaTemplateEnd);

        DocFromTemplate docFromTemplate = DocFromTemplate.docFromTemplateBuilder()
                .sandbox(false)
                .brand_primary_color("#000000")
                .lang("pt-br")
                .signer_name("My Signer for template")
                .template_id("75a3a92b-36d5-451f-95cd-5af9a927a392")
                .data(deParaTemplates)
                .build();

        DocResponse docResponse = new DocRequests().createDocFromTemplate(apiToken, docFromTemplate);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonDocResponse = ow.writeValueAsString(docResponse);
        System.out.println(jsonDocResponse);
    }
}
