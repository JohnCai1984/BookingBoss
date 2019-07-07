package com.helixleisure.bookingboss;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Swagger2MarkupTest {

    private String outputDir = "target/docs/asciidoc/generated";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void convertSwaggerToAsciiDoc() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(Swagger2MarkupResultHandler
                        .outputDirectory(outputDir).build())
                .andExpect(ResultMatcher.matchAll())
                .andReturn();
    }
}