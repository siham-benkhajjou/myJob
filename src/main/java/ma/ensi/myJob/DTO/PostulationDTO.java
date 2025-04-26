package ma.ensi.myJob.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class PostulationDTO {
    private Long id;
    private Long offreId;
    private Long candidatId;
    private String message;
    private LocalDate datePostulation;

}
