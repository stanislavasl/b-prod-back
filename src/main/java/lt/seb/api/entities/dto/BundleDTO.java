package lt.seb.api.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BundleDTO {
    private String bundleName;
    private String accountName;
    private String debitCardName;
    private String creditCardName;
}
