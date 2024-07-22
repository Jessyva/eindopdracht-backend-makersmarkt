package com.example.Makersmarkt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarktOndernemerDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Location is mandatory")
    private List<String> marketLocations; // Bijvoorbeeld, een lijst van marktenlocaties

    @NotBlank(message = "Website link is mandatory")
    private String websiteLink;
}
